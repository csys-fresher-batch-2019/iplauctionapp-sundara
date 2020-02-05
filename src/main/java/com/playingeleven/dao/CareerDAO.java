package com.playingeleven.dao;

public interface CareerDAO {

	public void addCareerDetails(int matches, int innings, int notOuts, int runsScored, int ballsBowled,
			int runsConceded, int wickets, int catches, int stumpings) throws Exception;

	public void deleteCareerDetails(int careerNo) throws Exception;

	public void updateCareerDetails(int careerNo, int matches, int innings, int notOuts, int runsScored,
			int ballsBowled, int runsConceded, int wickets, int catches, int stumpings) throws Exception;

}
