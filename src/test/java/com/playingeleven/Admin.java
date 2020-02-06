package com.playingeleven;

import java.sql.Date;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.playingeleven.dao.dto.Batting;
import com.playingeleven.dao.dto.Bowling;
import com.playingeleven.dao.dto.Experience;
import com.playingeleven.dao.dto.TeamPlayerPlayers;
import com.playingeleven.dao.impl.CareerDAOImpl;
import com.playingeleven.dao.impl.CountryDAOImpl;
import com.playingeleven.dao.impl.CricketingDAOImpl;
import com.playingeleven.dao.impl.PlayersDAOImpl;
import com.playingeleven.dao.impl.TeamDAOImpl;
import com.playingeleven.dao.impl.TeamPlayerDAOImpl;
import com.playingeleven.model.Career;
import com.playingeleven.model.Country;
import com.playingeleven.model.Cricketing;
import com.playingeleven.model.Players;
import com.playingeleven.model.Team;
import com.playingeleven.model.TeamPlayer;

import logger.Logger;

public class Admin {
	private static final Logger log=Logger.getInstance(); 
	public static void main(String[] args) throws Exception {
		int n;
		Scanner sc = new Scanner(System.in);
System.out.println("Enter username : ");
		String username=sc.next();
		System.out.println("Enter password");
		String password=sc.next();

		if (username.equals("admin") && password.equals("admin")) {
			System.out.println("you are logged in to Admin");
			do {
				System.out.print("\nTo choose your choice\npress 1 add to player details\npress 2 to remove player details\npress 3 to Add cricketing details\npress 4 to Add career details\npress 5 to Update career details\npress 6 to add country\npress 7 to add team\npress 8 to add teamplayer\npress 9 to start bidding\npress 10 to view players in the team\npress any other to exit");
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
					System.out.println("Add cricketing details");
					testCricketing();
					break;
				case 4:
					System.out.println("Add career details");
					testCareer();
					break;
				case 5:
					System.out.println("Update career details");
					updateCareer();
					break;
				case 6:
				    System.out.println("Add country details");
				    insertCountry();
				    break;
				case 7:
					System.out.println("Add team details");
					insertTeam();
					break;
				case 8:
					System.out.println("Add team player details");
					insertTeamPlayer();
					break;
				case 9:
					System.out.println("Start bidding");
					bidPlayer();
					break;
				case 10:
					System.out.println("to view players in a team");
					playerTeam();
					break;
					default:
					System.out.println("Invalid choice");
					break;
				}
			} while (n <= 10);
		} else {
			System.out.println("you are logged in to team login");
			do {

				System.out.println(
						"\nTo choose your choice\npress 1 to show batting average and rank \npress 2 to show bowling average and rank\npress 3 To find player by role\npress 4 To display player on experience wise\n press any other to exit");

				sc = new Scanner(System.in);
				
				System.out.println("\nEnter your choice no:");
				
				String choice = sc.next();
				System.out.println(choice);
				n = Integer.parseInt(choice);
				switch (n) {
				case 1:
					System.out.println("to show batting average and rank");
					testBatAvg();
					break;
				case 2:
					System.out.println("to show bowling average and rank");
					testBowAvg();
					break;
				case 3:
					System.out.println("To find player by role");
					findRole();
					break;
				case 4:
					System.out.println("To display player on experience wise");
					testExperienced();
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			} while (n <= 4);
		}
		sc.close();
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
		impl.addCareerDetails(ob.getMatches(), ob.getInnings(), ob.getNotOuts(), ob.getRunsScored(),
				ob.getBallsBowled(), ob.getRunsConceded(), ob.getWickets(), ob.getCatches(), ob.getStumpings());
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
		impl.updateCareerDetails(ob.getCareerNo(), ob.getCatches(), ob.getInnings(), ob.getNotOuts(),
				ob.getRunsScored(), ob.getBallsBowled(), ob.getRunsConceded(), ob.getWickets(), ob.getCatches(),
				ob.getStumpings());
		s.close();
	}

	public static void testCricketing() throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter player name");
		String fullName = s.nextLine();
		System.out.println("Enter Jersey number");
		int jerseyNo = s.nextInt();
		System.out.println("Enter batting"); 
		String batting = s.next();
		System.out.println("Enter bowling");
		String bowling = s.next();
		System.out.println("Enter bowling speed");
		String bowlingSpeed = s.next();
		Cricketing ob = new Cricketing();
		ob.setJerseyNo(jerseyNo);
		ob.setBatting(batting);
		ob.setBowling(bowling);
		ob.setBowlingSpeed(bowlingSpeed);
		CricketingDAOImpl impl = new CricketingDAOImpl();
		impl.addCricketingDetails(ob.getJerseyNo(), ob.getBatting(), ob.getBowling(), ob.getBowlingSpeed());
		s.close();

	}

	public static void testBatAvg() throws Exception {
		System.out.println("viewing batting average of players");
		CricketingDAOImpl impl = new CricketingDAOImpl();
		// impl.bestBowlingAvg();
		impl.bestBowlingAverage();
		ArrayList<Batting> BattingAverage = impl.bestBattingAverage();
		for (Batting batting : BattingAverage) {
			System.out.println();
			System.out.println(batting.getPlayerFullName() + "," + batting.getRoleName() + "," + batting.getBatting() + ","
					+ batting.getBattingAverage() + "," + batting.getRank());
		}

	}

	public static void testBowAvg() throws Exception {
		System.out.println("viewing bowling average of players");
		CricketingDAOImpl impl = new CricketingDAOImpl();
		impl.bestBowlingAverage();
		ArrayList<Bowling> BowlingAverage = impl.bestBowlingAverage();
		for (Bowling bowling : BowlingAverage) {
			System.out.println();
			System.out.println(bowling.getPlayerFullName() + "," + bowling.getRoleName() + "," + bowling.getBowling() + ","
					+ bowling.getBowlingAverage() + "," + bowling.getRank());
		}
	}

	public static void findRole() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter role to find players(\n1.batsman \n2.bowler \n3.all-rounder \n4.wicketkeeper/Batsman)");
		String roleName = sc.next();
		Players ob = new Players();
		ob.setRoleName(roleName);
		PlayersDAOImpl impl = new PlayersDAOImpl();
		List<Players> list = new ArrayList<Players>();
		list = impl.listRoleOfPlayers(roleName);
		for (Players players : list) {
			System.out.println(players.getPlayerId() + "-" + players.getPlayerFullName());
		}
		//sc.close();
	}

	public static void testExperienced() throws Exception {
		System.out.println("viewing experienced players");
		PlayersDAOImpl impl = new PlayersDAOImpl();
		impl.listOfExperiencedPlayers();
		ArrayList<Experience> ExperiencePlayers = impl.listOfExperiencedPlayers();
		for (Experience experience : ExperiencePlayers) {
			System.out.println();
			System.out.println(experience.getPlayerFullName() + "-" + experience.getMatches());
		}
	}
		public static void insertCountry() throws Exception {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Country name");
			String countryName = sc.next();
			System.out.println("Enter Player type(indian,overseas)");
			String playerType = sc.next();
			System.out.println("Enter Basic prize of the player");
			int basicPrice = sc.nextInt();
		    Country ob = new Country();
		    ob.setCountryName(countryName);
		    ob.setPlayerType(playerType);
		    ob.setBasicPrice(basicPrice);
		    CountryDAOImpl impl = new CountryDAOImpl();
			impl.addCountry(ob.getCountryName(),ob.getPlayerType(),ob.getBasicPrice());
			sc.close();
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
		public static void insertTeamPlayer() throws Exception {
			Scanner sc = new Scanner(System.in);
		    System.out.println("Enter player id");
		    int playrId=sc.nextInt();
		    System.out.println("Enter team id");
		    int teammId=sc.nextInt();
		    System.out.println("Enter Amount sold");
		    int soldPrice=sc.nextInt();
		    TeamPlayer ob = new TeamPlayer();
		    ob.setPlayrId(playrId);
		    ob.setTeammId(teammId);
		    ob.setSoldPrice(soldPrice);
		    TeamPlayerDAOImpl impl = new TeamPlayerDAOImpl();
			impl.addTeamPlayer(ob.getPlayrId(),ob.getTeammId(),ob.getSoldPrice());
			sc.close();
		}
		public static void bidPlayer() throws Exception {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter playerId ");
			int playerId = sc.nextInt();
			int n = 1;
			int teamId;
			System.out.println("round no" + n);
	        String[] teams = { "CSK", "MI", "RCB", "SRH", "KKR" };
			int[] teamIds = { 101, 102, 103, 104, 105 };
			int selectedTeamId = 0;
			Map<Integer, Integer> bid = new HashMap<Integer, Integer>();
			Set<Integer> amountSet = new HashSet<Integer>();
			int max = -1;
			for (int i = 0; i < teams.length; i++) {
				String teamName = teams[i];
				int teaamId = teamIds[i];
				boolean repeat = false;
				int amount = 0;
				do {
					System.out.println(
							"Team " + teamName + ", Enter the bidding Amount for playerid " + playerId + " at round no" + n);
					
					amount = sc.nextInt();
					if (amountSet.contains(amount)) {
						repeat = true;
						System.out.println("Reenter different Amount. Already someone has bidded.");
					}
					else{
						amountSet.add(amount);
						repeat = false;
					}
				}
				while( repeat);
				
				if (amount > 0) {
					bid.put(teaamId, amount);
				}
				if ( amount > max) {
					max = amount;
					selectedTeamId = teaamId;
				}		

			}
			System.out.println(bid);
			// int [] numbers = {};
			int numbers;
			Set<Integer> keySet = bid.keySet();
			for (int x : keySet) {
				// int arr[]=sc.nextInt();
				// System.out.print( x );`
			}
			// int arr[] = {bid1, bid2,bid3, bid4, bid5};
			//int max = 0;// bid. Arrays.stream(arr).max().getAsInt();
			System.out.println("TeamId " + selectedTeamId + ",highest bid is " + max);
		    //System.out.println("Enter player id");
		    //int playrId=sc.nextInt();
		    //System.out.println("Enter team id");
		    //int teammId=sc.nextInt();
		    //System.out.println("Enter Amount sold");
		    //int soldPrice=sc.nextInt();
		    TeamPlayer ob = new TeamPlayer();
		    ob.setPlayrId(playerId);
		    ob.setTeammId(selectedTeamId);
		    ob.setSoldPrice(max);
		    TeamPlayerDAOImpl impl = new TeamPlayerDAOImpl();
			impl.addTeamPlayer(ob.getPlayrId(),ob.getTeammId(),ob.getSoldPrice());
			
			sc.close();
		}
		public static void playerTeam() throws Exception
		{
			Scanner sc=new Scanner(System.in);
			String teamName=sc.next();
			System.out.println("viewing players from "+teamName);
			TeamPlayerDAOImpl impl = new TeamPlayerDAOImpl();
			impl.viewTeamPlayer(teamName);
			ArrayList<TeamPlayerPlayers> TeamPlayers = impl.viewTeamPlayer(teamName);
			for (TeamPlayerPlayers e : TeamPlayers) {
				System.out.println();
				System.out.println(e.getPlayerFullName() + " " + e.getRoleName() + " " + e.getPlayerType() + " " +e.getSoldPrice());
			}
		}
}