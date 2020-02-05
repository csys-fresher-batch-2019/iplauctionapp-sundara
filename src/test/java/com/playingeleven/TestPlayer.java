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

public class TestPlayer {

	public static void main(String[] args) throws Exception {
		int n;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print(
					"\nTo choose your choice\npress 1 add to player details\npress 2 to remove player details\npress 3 to find players by rolename\npress 4 to show player experience\n press any other to exit");

			System.out.println("\nEnter your choice no:");
			n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("Add player details");
				testInsert();
				break;
			case 2:
				System.out.println("remove player details");
				testDelete();
				break;
			case 3:
				System.out.println("find players by role name");
				findRole();
				break;
			case 4:
				System.out.println("show the player experiences");
				testExperienced();
				break;
			case 5:
				System.out.println("Exit");
				break;
			case 6:
				// System.out.println("Saturday");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (n <= 6);
	}

	public static void testInsert() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter player fullname");
		String playerFullName = sc.nextLine();
		System.out.println("Enter dateofbirth");
		String date = sc.next();
		LocalDate dateOfBirth = LocalDate.parse(date);
		Date rd = Date.valueOf(dateOfBirth);
		System.out.println("Enter nickName");
		String nickName = sc.next();
		System.out.println("Enter roleName");
		String roleName = sc.next();
		Players ob = new Players();
		ob.setPlayerFullName(playerFullName);
		ob.setDateOfBirth(dateOfBirth);
		ob.setNickName(nickName);
		ob.setRoleName(roleName);
		PlayersDAOImpl impl = new PlayersDAOImpl();
		impl.addPlayerDetails(ob);
		sc.close();
	}

	public static void testDelete() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dateofbirth to delete");
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
		System.out.println("Enter role to find players");
		String roleName = sc.next();
		Players ob = new Players();
		ob.setRoleName(roleName);
		PlayersDAOImpl impl = new PlayersDAOImpl();
		List<Players> list = new ArrayList<Players>();
		list = impl.listRoleOfPlayers(roleName);
		for (Players players : list) {
			System.out.println(players.getPlayerId() + "-" + players.getPlayerFullName());
		}
		sc.close();
	}

	public static void testExperienced() throws Exception {
		System.out.println("viewing experienced players");
		PlayersDAOImpl impl = new PlayersDAOImpl();
		impl.listOfExperiencedPlayers();
		ArrayList<Experience> ExperiencePlayers = impl.listOfExperiencedPlayers();
		for (Experience experience : ExperiencePlayers) {
			System.out.println();
			System.out.println(experience.playerFullName + "-" + experience.matches);
		} 

	}

}
