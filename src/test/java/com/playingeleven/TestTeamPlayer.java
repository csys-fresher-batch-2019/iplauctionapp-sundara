package com.playingeleven;
import java.util.Scanner;

import com.playingeleven.dao.impl.TeamDAOImpl;
import com.playingeleven.dao.impl.TeamPlayerDAOImpl;
import com.playingeleven.model.TeamPlayer;

import logger.Logger;
public class TestTeamPlayer {
	private static final Logger log=Logger.getInstance(); 
        public static void main(String[] args) throws Exception {
		//insertTeamPlayer();
        	TeamDAOImpl impl1=new TeamDAOImpl();
impl1.UpdateTotalAmount(105, 5);
        
        }
		public static void insertTeamPlayer() throws Exception {
			Scanner sc = new Scanner(System.in);
		    log.getInput("Enter player id");
		    int playrId=sc.nextInt();
		    log.getInput("Enter team id");
		    int teammId=sc.nextInt();
		    log.getInput("Enter Amount sold");
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
