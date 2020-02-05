package com.playingeleven.model;

public class Country {
       private int playerrId; 
       private String countryName;
       private String playerType;
       private int basicPrice;
	public int getPlayerrId() {
		return playerrId;
	}
	public void setPlayerrId(int playerrId) {
		this.playerrId = playerrId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getPlayerType() {
		return playerType;
	}
	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}
	public int getBasicPrice() {
		return basicPrice;
	}
	public void setBasicPrice(int basicPrice) {
		this.basicPrice = basicPrice;
	}
	@Override
	public String toString() {
		return "Country [playerrId=" + playerrId + ", countryName=" + countryName + ", playerType=" + playerType
				+ ", basicPrice=" + basicPrice + "]";
	}
       

}
