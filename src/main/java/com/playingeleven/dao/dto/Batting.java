package com.playingeleven.dao.dto;

public class Batting {

	private String playerFullName;
	private String roleName;
	private String batting;
	private int battingAverage;
	private int rank;

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

	public String getBatting() {
		return batting;
	}

	public void setBatting(String batting) {
		this.batting = batting;
	}

	public int getBattingAverage() {
		return battingAverage;
	}

	public void setBattingAverage(int battingAverage) {
		this.battingAverage = battingAverage;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Batting [playerFullName=" + playerFullName + ", roleName=" + roleName + ", batting=" + batting
				+ ", battingAverage=" + battingAverage + ", rank=" + rank + "]";
	}

}
