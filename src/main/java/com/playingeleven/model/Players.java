package com.playingeleven.model;

import java.time.LocalDate;

public class Players {
	private int playerId;
	private String playerFullName;
	private LocalDate dateOfBirth;
	private String nickName;
	private String roleName;
	private int active=1;
	
	public void setId(int playerId)
	{
		if(playerId < 0) {
			throw new IllegalArgumentException("Invalid id");
		}
		this.setPlayerId(playerId);
	}
	
	public String getPlayerFullName() {
		return playerFullName;
	}

	public void setPlayerFullName(String playerFullName) {
		this.playerFullName = playerFullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getId()
	{
		return getPlayerId();
	}
	@Override
	public String toString() {
		return "Players [playerId=" + playerId + ", playerFullName=" + playerFullName + ", dateOfBirth=" + dateOfBirth
				+ ", nickName=" + nickName + ", roleName=" + roleName + ", active=" + active + "]";
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	
}
