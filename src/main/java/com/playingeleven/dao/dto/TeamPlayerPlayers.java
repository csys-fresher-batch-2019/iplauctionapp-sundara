package com.playingeleven.dao.dto;

public class TeamPlayerPlayers {
	private String playerFullName; 
	private String roleName;
	private String playerType;
	private  int soldPrice;
	
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

	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	public int getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(int soldPrice) {
		this.soldPrice = soldPrice;
	}

	@Override
	public String toString() {
		return "TeamPlayerPlayers [playerFullName=" + playerFullName + ", roleName=" + roleName + ", playerType="
				+ playerType + ", soldPrice=" + soldPrice + "]";
	}
	

}
