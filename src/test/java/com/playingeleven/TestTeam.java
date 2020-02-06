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
	    System.out.println("Enter Team name");
	    String teamName=sc.next();
	    System.out.println("Enter Team Name");
	    String teamOwner= sc.nextLine();
	    System.out.println("Enter Team Coach");
	    String teamCoach= sc.nextLine();
	    System.out.println("Enter Amount remaining");
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
