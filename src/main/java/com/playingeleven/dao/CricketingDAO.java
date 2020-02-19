package com.playingeleven.dao;

import java.util.ArrayList;

import com.playingeleven.DbException;
import com.playingeleven.dao.dto.Batting;
import com.playingeleven.dao.dto.Bowling;


public interface CricketingDAO {
	void addCricketingDetails(int jerseyNo,  String batting, String bowling,
			String bowlingSpeed) throws DbException;

	public void deleteCricketingDetails(int cricNo) throws DbException;

	public ArrayList<Batting> bestBattingAverage() throws DbException;

	public ArrayList<Bowling> bestBowlingAverage() throws DbException;

	
}
