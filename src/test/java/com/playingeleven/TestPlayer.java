package com.playingeleven;

//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.playingeleven.dao.dto.Experience;
import com.playingeleven.dao.impl.PlayersDAOImpl;
import com.playingeleven.model.Players;

import logger.Logger;

public class TestPlayer {
	private static final Logger log=Logger.getInstance(); 
	public static void main(String[] args) throws Exception {
		int n;
		Scanner sc = new Scanner(System.in);

		do {
			log.getInput(
					"\nTo choose your choice\npress 1 add to player details\npress 2 to remove player details\npress 3 to find players by rolename\npress 4 to show player experience\n press any other to exit");

			log.getInput("\nEnter your choice no:");
			n = sc.nextInt();
			switch (n) {
			case 1:
				log.getInput("Add player details");
				testInsert();
				break;
			case 2:
				log.getInput("remove player details");
				testDelete();
				break;
			case 3:
				log.getInput("find players by role name");
				findRole();
				break;
			case 4:
				log.getInput("show the player experiences");
				testExperienced();
				break;
			case 5:
				log.getInput("Exit");
				break;
			case 6:
				//log.getInput("Saturday");
				break;
			default:
				log.getInput("Invalid choice");
				break;
			}
		} while (n <= 6);
	}

	public static void testInsert() throws Exception {
		Scanner sc = new Scanner(System.in);
		log.getInput("Enter player fullname");
		String playerFullName = sc.nextLine();
		log.getInput("Enter dateofbirth");
		String date = sc.next();
		LocalDate dateOfBirth = LocalDate.parse(date);
		Date rd = Date.valueOf(dateOfBirth);
		log.getInput("Enter nickName");
		String nickName = sc.next();
		log.getInput("Enter roleName");
		String roleName = sc.next();
		log.getInput("Enter playerImage");
		String playerImage = sc.next();
		Players ob = new Players();
		ob.setPlayerFullName(playerFullName);
		ob.setDateOfBirth(dateOfBirth);
		ob.setNickName(nickName);
		ob.setRoleName(roleName);
		ob.setPlayerImage(playerImage);
		PlayersDAOImpl impl = new PlayersDAOImpl();
		impl.addPlayerDetails(ob);
		sc.close();
	}

	public static void testDelete() throws Exception {
		Scanner sc = new Scanner(System.in);
		log.getInput("Enter dateofbirth to delete");
		String date = sc.next();
		LocalDate dateOfBirth = LocalDate.parse(date);
		Date rd = Date.valueOf(dateOfBirth);
		Players ob = new Players();
		ob.setDateOfBirth(dateOfBirth);
		PlayersDAOImpl impl = new PlayersDAOImpl();
		impl.deletePlayerDetails(ob.getDateOfBirth());
		sc.close();
	}

	public static void findRole() throws Exception {
		Scanner sc = new Scanner(System.in);
		log.getInput("Enter role to find players");
		String roleName = sc.next();
		Players ob = new Players();
		ob.setRoleName(roleName);
		PlayersDAOImpl impl = new PlayersDAOImpl();
		List<Players> list = new ArrayList<Players>();
		list = impl.listRoleOfPlayers(roleName);
		for (Players players : list) {
			log.getInput(players.getPlayerId() + "-" + players.getPlayerFullName());
		}
		sc.close();
	}

	public static void testExperienced() throws Exception {
		log.getInput("viewing experienced players");
		PlayersDAOImpl impl = new PlayersDAOImpl();
		impl.listOfExperiencedPlayers();
		ArrayList<Experience> ExperiencePlayers = impl.listOfExperiencedPlayers();
		for (Experience experience : ExperiencePlayers) {
			log.getInput("");
			log.getInput(experience.getPlayerFullName() + "-" + experience.getMatches());
		} 

	}

}
