package com.playingeleven.dao;

import com.playingeleven.DbException;

public interface TeamDAO {
	public void addTeam(String teamName,String teamOwner,String teamCoach,int amountRemaining) throws DbException;
}
