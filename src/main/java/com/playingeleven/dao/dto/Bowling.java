package com.playingeleven.dao.dto;

public class Bowling {

	public String playerFullName;
	public String roleName;
	public String bowling;
	public int bowlingAverage;
	public int rank;

	@Override
	public String toString() {
		return "Bowling [playerFullName=" + playerFullName + ", roleName=" + roleName + ", bowling=" + bowling
				+ ", bowlingAverage=" + bowlingAverage + ", rank=" + rank + "]";
	}

}
