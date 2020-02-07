package com.playingeleven;

import java.util.Scanner;

import com.playingeleven.dao.impl.TeamDAOImpl;
import com.playingeleven.model.Team;

import logger.Logger;

public class TestTeam {
	private static final Logger log=Logger.getInstance(); 
	public static void main(String[] args) throws Exception {
		insertTeam();
 }
	public static void insertTeam() throws Exception {
		Scanner sc = new Scanner(System.in);
	    log.getInput("Enter Team name");
	    String teamName=sc.next();
	    log.getInput("Enter Team Name");
	    String teamOwner= sc.nextLine();
	    log.getInput("Enter Team Coach");
	    String teamCoach= sc.nextLine();
	    log.getInput("Enter Amount remaining");
	    int amountRemaining=sc.nextInt();
	    Team ob = new Team();
	    ob.setTeamName(teamName);
	    ob.setTeamOwner(teamOwner);
	    ob.setTeamCoach(teamCoach);
	    ob.setAmountRemaining(amountRemaining);
	    TeamDAOImpl impl = new TeamDAOImpl();
		impl.addTeam( ob.getTeamName(),ob.getTeamOwner(),ob.getTeamCoach(),ob.getAmountRemaining());
		sc.close();
	}


}
