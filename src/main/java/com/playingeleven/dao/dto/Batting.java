package com.playingeleven.dao.dto;

public class Batting {

	public String playerFullName;
	public String roleName;
	public String batting;
	public int battingAverage;
	public int rank;

	@Override
	public String toString() {
		return "Batting [playerFullName=" + playerFullName + ", roleName=" + roleName + ", batting=" + batting
				+ ", battingAverage=" + battingAverage + ", rank=" + rank + "]";
	}

}
