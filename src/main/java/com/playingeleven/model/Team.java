package com.playingeleven.model;

public class Team {
	private int teamId;
	private String teamName;
	private String teamOwner;
	private String teamCoach;
	private int amountRemaining;
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamOwner() {
		return teamOwner;
	}
	public void setTeamOwner(String teamOwner) {
		this.teamOwner = teamOwner;
	}
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", teamOwner=" + teamOwner + ", teamCoach="
				+ teamCoach + ", amountRemaining=" + amountRemaining + "]";
	}
	public String getTeamCoach() {
		return teamCoach;
	}
	public void setTeamCoach(String teamCoach) {
		this.teamCoach = teamCoach;
	}
	public int getAmountRemaining() {
		return amountRemaining;
	}
	public void setAmountRemaining(int amountRemaining) {
		this.amountRemaining = amountRemaining;
	}
	

}
