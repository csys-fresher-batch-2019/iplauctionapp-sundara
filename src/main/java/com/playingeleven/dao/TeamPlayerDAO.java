package com.playingeleven.dao;

import java.util.ArrayList;

import com.playingeleven.DbException;
import com.playingeleven.dao.dto.TeamPlayerPlayers;

public interface TeamPlayerDAO {
	public void addTeamPlayer(int playrId,int teammId,int soldPrice) throws DbException;
	public ArrayList<TeamPlayerPlayers> viewTeamPlayer(String teamName) throws DbException;
}

