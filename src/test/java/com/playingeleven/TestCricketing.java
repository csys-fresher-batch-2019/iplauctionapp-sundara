package com.playingeleven;

import java.util.ArrayList;
import java.util.Scanner;

import com.playingeleven.dao.dto.Batting;
import com.playingeleven.dao.dto.Bowling;
import com.playingeleven.dao.impl.CricketingDAOImpl;
import com.playingeleven.model.Cricketing;

import logger.Logger;

public class TestCricketing {
	private static final Logger log=Logger.getInstance(); 

	public static void main(String[] args) throws Exception {
		//testCricketing();
		//testDelete();
		//testBatAvg();
		//testBowAvg();
	}

	public static void testCricketing() throws Exception {
		Scanner s = new Scanner(System.in);
		log.getInput("Enter player name");
		String fullName = s.nextLine();
		log.getInput("Enter Jersey number");
		int jerseyNo = s.nextInt();
		log.getInput("Enter batting");
		String batting = s.next();
		log.getInput("Enter bowling");
		String bowling = s.next();
		log.getInput("Enter bowling speed");
		String bowlingSpeed = s.next();
		Cricketing ob = new Cricketing();
		ob.setJerseyNo(jerseyNo);
		ob.setBatting(batting);
		ob.setBowling(bowling);
		ob.setBowlingSpeed(bowlingSpeed);
		CricketingDAOImpl impl = new CricketingDAOImpl();
		impl.addCricketingDetails(ob.getJerseyNo(),  ob.getBatting(), ob.getBowling(), ob.getBowlingSpeed());
		s.close();
	}

	public static void testDelete() throws Exception {
		Scanner sc = new Scanner(System.in);
		log.getInput("Enter cric_no to delete");
		int cricNo = sc.nextInt();
		Cricketing ob = new Cricketing();
		ob.setCricNo(cricNo);
		CricketingDAOImpl impl = new CricketingDAOImpl();
		impl.deleteCricketingDetails(ob.getCricNo());
		sc.close();

	}

	public static void testBatAvg() throws Exception {
		log.getInput("viewing batting average of players");
		CricketingDAOImpl impl = new CricketingDAOImpl();
		// impl.bestBowlingAvg();
		impl.bestBowlingAverage();
		ArrayList<Batting> BattingAverage = impl.bestBattingAverage();
		for (Batting batting : BattingAverage) {
			log.getInput();
			log.getInput(batting.getPlayerFullName() + "," + batting.getRoleName() + "," + batting.getBatting() + ","
					+ batting.getBattingAverage() + "," + batting.getRank());
		}

	}

	public static void testBowAvg() throws Exception {
		log.getInput("viewing bowling average of players");
		CricketingDAOImpl impl = new CricketingDAOImpl();
		impl.bestBowlingAverage();
		ArrayList<Bowling> BowlingAverage = impl.bestBowlingAverage();
		for (Bowling bowling : BowlingAverage) {
			log.getInput();
			log.getInput(bowling.getPlayerFullName() + "," + bowling.getRoleName() + "," + bowling.getBowling() + ","
					+ bowling.getBowlingAverage() + "," + bowling.getRank());
		}
	}

}