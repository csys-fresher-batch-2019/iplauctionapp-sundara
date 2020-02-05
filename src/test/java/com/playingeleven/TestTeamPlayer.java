package com.playingeleven;
import java.util.Scanner;
import com.playingeleven.dao.impl.TeamPlayerDAOImpl;
import com.playingeleven.model.TeamPlayer;
public class TestTeamPlayer {
        public static void main(String[] args) throws Exception {
		insertTeamPlayer();
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
		}
