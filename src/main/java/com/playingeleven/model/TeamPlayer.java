package com.playingeleven.model;

public class TeamPlayer {
	private int playrId;
	private int teammId;
	private int soldPrice;
	public int getPlayrId() {
		return playrId;
	}
	public void setPlayrId(int playrId) {
		this.playrId = playrId;
	}
	public int getTeammId() {
		return teammId;
	}
	@Override
	public String toString() {
		return "TeamPlayer [playrId=" + playrId + ", teammId=" + teammId + ", soldPrice=" + soldPrice + "]";
	}
	public void setTeammId(int teammId) {
		this.teammId = teammId;
	}
	public int getSoldPrice() {
		return soldPrice;
	}
	public void setSoldPrice(int soldPrice) {
		this.soldPrice = soldPrice;
	}
}
