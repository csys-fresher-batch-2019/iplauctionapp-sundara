package com.playingeleven;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import logger.Logger;

public class team_bid {
	private static final Logger log=Logger.getInstance(); 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		log.getInput("Enter playerId ");
		int playerId = sc.nextInt();
		int n = 1;
		int teamId;
		log.getInput("round no" + n);
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
				log.getInput(
						"Team " + teamName + ", Enter the bidding Amount for playerid " + playerId + " at round no" + n);
				
				amount = sc.nextInt();
				if (amountSet.contains(amount)) {
					repeat = true;
					log.getInput("Reenter different Amount. Already someone has bidded.");
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
		log.getInput(bid);
		// int [] numbers = {};
		int numbers;
		Set<Integer> keySet = bid.keySet();
		for (int x : keySet) {
			// int arr[]=sc.nextInt();
			// System.out.print( x );`
		}
		// int arr[] = {bid1, bid2,bid3, bid4, bid5};
		//int max = 0;// bid. Arrays.stream(arr).max().getAsInt();
		log.getInput("TeamId " + selectedTeamId + ",highest bid is " + max);

	}
}


