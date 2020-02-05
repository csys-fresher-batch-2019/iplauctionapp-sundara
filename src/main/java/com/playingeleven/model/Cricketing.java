package com.playingeleven.model;

public class Cricketing {

	private int cricNo;
	private int jerseyNo;
	private String batting;
	private String bowling;
	private String bowlingSpeed;
	public int getCricNo() {
		return cricNo;
	}
	public void setCricNo(int cricNo) {
		if(cricNo < 0) {
			throw new IllegalArgumentException("Invalid id");
		}
		this.cricNo = cricNo;
	}
	@Override
	public String toString() {
		return "Cricketing [cricNo=" + cricNo + ", jerseyNo=" + jerseyNo + ", batting=" + batting + ", bowling="
				+ bowling + ", bowlingSpeed=" + bowlingSpeed + "]";
	}
	public int getJerseyNo() {
		return jerseyNo;
	}
	public void setJerseyNo(int jerseyNo) {
		this.jerseyNo = jerseyNo;
	}

	public String getBatting() {
		return batting;
	}
	public void setBatting(String batting) {
		this.batting = batting;
	}
	public String getBowling() {
		return bowling;
	}
	public void setBowling(String bowling) {
		this.bowling = bowling;
	}
	public String getBowlingSpeed() {
		return bowlingSpeed;
	}
	public void setBowlingSpeed(String bowlingSpeed) {
		this.bowlingSpeed = bowlingSpeed;
	}
	

}
