package com.playingeleven.dao;

import java.util.ArrayList;

import com.playingeleven.dao.dto.Batting;
import com.playingeleven.dao.dto.Bowling;

public interface CricketingDAO {
	void addCricketingDetails(int jerseyNo,  String batting, String bowling,
			String bowlingSpeed) throws Exception;

	public void deleteCricketingDetails(int cricNo) throws Exception;

	public ArrayList<Batting> bestBattingAverage() throws Exception;

	public ArrayList<Bowling> bestBowlingAverage() throws Exception;

}
