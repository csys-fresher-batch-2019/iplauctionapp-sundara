package com.playingeleven.dao.dto;

public class Experience {

	private String playerFullName;
	private int matches;
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



	public int getMatches() {
		return matches;
	}



	public void setMatches(int matches) {
		this.matches = matches;
	}



	@Override
	public String toString() {
		return "Experience [playerFullName=" + playerFullName + ", matches=" + matches + ", playerImage=" + playerImage
				+ "]";
	}
}
