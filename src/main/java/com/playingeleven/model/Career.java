package com.playingeleven.model;

public class Career {
	private int careerNo;
	private int matches;
	private int innings;
	private int notOuts;
	private int runsScored;
	private int ballsBowled;
	private int runsConceded;
	private int wickets;
	private int catches;
	@Override
	public String toString() {
		return "Career [careerNo=" + careerNo + ", matches=" + matches + ", innings=" + innings + ", notOuts=" + notOuts
				+ ", runsScored=" + runsScored + ", ballsBowled=" + ballsBowled + ", runsConceded=" + runsConceded
				+ ", wickets=" + wickets + ", catches=" + catches + ", stumpings=" + stumpings + "]";
	}
	private int stumpings;
	public int getCareerNo() {
		if(careerNo < 0) {
			throw new IllegalArgumentException("Invalid id");
		}
		return careerNo;
	}
	public void setCareerNo(int careerNo) {
		this.careerNo = careerNo;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public int getInnings() {
		return innings;
	}
	public void setInnings(int innings) {
		this.innings = innings;
	}
	public int getNotOuts() {
		return notOuts;
	}
	public void setNotOuts(int notOuts) {
		this.notOuts = notOuts;
	}
	public int getRunsScored() {
		return runsScored;
	}
	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}
	public int getBallsBowled() {
		return ballsBowled;
	}
	public void setBallsBowled(int ballsBowled) {
		this.ballsBowled = ballsBowled;
	}
	public int getRunsConceded() {
		return runsConceded;
	}
	public void setRunsConceded(int runsConceded) {
		this.runsConceded = runsConceded;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public int getCatches() {
		return catches;
	}
	public void setCatches(int catches) {
		this.catches = catches;
	}
	public int getStumpings() {
		return stumpings;
	}
	public void setStumpings(int stumpings) {
		this.stumpings = stumpings;
	}

}
