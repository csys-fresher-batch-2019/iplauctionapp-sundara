package com.playingeleven.dao.dto;

public class Bowling {

	private String playerFullName;
	private String roleName;
	private String bowling;
	private int bowlingAverage;
	private int rank;
	private String playerImage;
	

	public String getPlayerImage() {
		return playerImage;
	}


	public void setPlayerImage(String playerImage) {
		this.playerImage = playerImage;
	}


	public String getPlayerFullName() {
		return playerFullName;
	}


	public void setPlayerFullName(String playerFullName) {
		this.playerFullName = playerFullName;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getBowling() {
		return bowling;
	}


	public void setBowling(String bowling) {
		this.bowling = bowling;
	}


	public int getBowlingAverage() {
		return bowlingAverage;
	}


	public void setBowlingAverage(int bowlingAverage) {
		this.bowlingAverage = bowlingAverage;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	@Override
	public String toString() {
		return "Bowling [playerFullName=" + playerFullName + ", roleName=" + roleName + ", bowling=" + bowling
				+ ", bowlingAverage=" + bowlingAverage + ", rank=" + rank + ", playerImage=" + playerImage + "]";
	}

}
