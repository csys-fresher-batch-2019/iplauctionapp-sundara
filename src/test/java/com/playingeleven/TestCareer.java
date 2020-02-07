package com.playingeleven;

import java.util.Scanner;

import com.playingeleven.dao.impl.CareerDAOImpl;
import com.playingeleven.model.Career;

import logger.Logger;

public class TestCareer {
	private static final Logger log=Logger.getInstance(); 
	public static void main(String[] args) throws Exception {
		testCareer();
		testDelete();
		updateCareer();
	}

	public static void testCareer() throws Exception {
		Scanner s = new Scanner(System.in);
		log.getInput("Enter Matches played");
		int matches = s.nextInt();
		log.getInput("Enter Innings played");
		int innings = s.nextInt();
		log.getInput("Enter not outs");
		int notOuts = s.nextInt();
		log.getInput("Enter runs scored");
		int runsScored = s.nextInt();
		log.getInput("Enter balls bowled");
		int ballsBowled = s.nextInt();
		log.getInput("Enter runs conceded");
		int runsConceded = s.nextInt();
		log.getInput("Enter wickets taken");
		int wickets = s.nextInt();
		log.getInput("Enter catches taken");
		int catches = s.nextInt();
		log.getInput("Enter stumpings");
		int stumpings = s.nextInt();
		Career ob = new Career();
		ob.setMatches(matches);
		ob.setInnings(innings);
		ob.setNotOuts(notOuts);
		ob.setRunsScored(runsScored);
		ob.setBallsBowled(ballsBowled);
		ob.setRunsConceded(runsConceded);
		ob.setWickets(wickets);
		ob.setCatches(catches);
		ob.setStumpings(stumpings);
		CareerDAOImpl impl = new CareerDAOImpl();
		impl.addCareerDetails(ob.getMatches(), ob.getInnings(), ob.getNotOuts(), ob.getRunsScored(), ob.getBallsBowled(), ob.getRunsConceded(),
				ob.getWickets(), ob.getCatches(), ob.getStumpings());
		s.close();
	}

	public static void updateCareer() throws Exception {
		Scanner s = new Scanner(System.in);
		log.getInput("Enter career number");
		int careerNo = s.nextInt();
		log.getInput("Enter Matches played");
		int matches = s.nextInt();
		log.getInput("Enter Innings played");
		int innings = s.nextInt();
		log.getInput("Enter not outs");
		int notOuts = s.nextInt();
		log.getInput("Enter runs scored");
		int runsScored = s.nextInt();
		log.getInput("Enter balls bowled");
		int ballsBowled = s.nextInt();
		log.getInput("Enter runs conceded");
		int runsConceded = s.nextInt();
		log.getInput("Enter wickets taken");
		int wickets = s.nextInt();
		log.getInput("Enter catches taken");
		int catches = s.nextInt();
		log.getInput("Enter stumpings");
		int stumpings = s.nextInt();
		Career ob = new Career();
		ob.setCareerNo(careerNo);
		ob.setMatches(matches);
		ob.setInnings(innings);
		ob.setNotOuts(notOuts);
		ob.setRunsScored(runsScored);
		ob.setBallsBowled(ballsBowled);
		ob.setRunsConceded(runsConceded);
		ob.setWickets(wickets);
		ob.setCatches(catches);
		ob.setStumpings(stumpings);
		CareerDAOImpl impl = new CareerDAOImpl();
		impl.updateCareerDetails(ob.getCareerNo(), ob.getCatches(), ob.getInnings(), ob.getNotOuts(), ob.getRunsScored(), ob.getBallsBowled(),
				ob.getRunsConceded(), ob.getWickets(), ob.getCatches(), ob.getStumpings());
		s.close();
	}

	public static void testDelete() throws Exception {
		Scanner sc = new Scanner(System.in);
		log.getInput("Enter career_no to delete");
		int careerNo = sc.nextInt();
		Career ob = new Career();
		ob.setCareerNo(careerNo);
		CareerDAOImpl impl = new CareerDAOImpl();
		impl.deleteCareerDetails(ob.getCareerNo());
		sc.close();

	}
}
