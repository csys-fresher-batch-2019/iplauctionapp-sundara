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
		System.out.println("Enter Matches played");
		int matches = s.nextInt();
		System.out.println("Enter Innings played");
		int innings = s.nextInt();
		System.out.println("Enter not outs");
		int notOuts = s.nextInt();
		System.out.println("Enter runs scored");
		int runsScored = s.nextInt();
		System.out.println("Enter balls bowled");
		int ballsBowled = s.nextInt();
		System.out.println("Enter runs conceded");
		int runsConceded = s.nextInt();
		System.out.println("Enter wickets taken");
		int wickets = s.nextInt();
		System.out.println("Enter catches taken");
		int catches = s.nextInt();
		System.out.println("Enter stumpings");
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
		System.out.println("Enter career number");
		int careerNo = s.nextInt();
		System.out.println("Enter Matches played");
		int matches = s.nextInt();
		System.out.println("Enter Innings played");
		int innings = s.nextInt();
		System.out.println("Enter not outs");
		int notOuts = s.nextInt();
		System.out.println("Enter runs scored");
		int runsScored = s.nextInt();
		System.out.println("Enter balls bowled");
		int ballsBowled = s.nextInt();
		System.out.println("Enter runs conceded");
		int runsConceded = s.nextInt();
		System.out.println("Enter wickets taken");
		int wickets = s.nextInt();
		System.out.println("Enter catches taken");
		int catches = s.nextInt();
		System.out.println("Enter stumpings");
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
		System.out.println("Enter career_no to delete");
		int careerNo = sc.nextInt();
		Career ob = new Career();
		ob.setCareerNo(careerNo);
		CareerDAOImpl impl = new CareerDAOImpl();
		impl.deleteCareerDetails(ob.getCareerNo());
		sc.close();

	}
}
