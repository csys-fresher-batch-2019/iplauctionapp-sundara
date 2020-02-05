package com.playingeleven.dao;

import java.util.ArrayList;

import com.playingeleven.dao.dto.TeamPlayerPlayers;

public interface TeamPlayerDAO {
	public void addTeamPlayer(int playrId,int teammId,int soldPrice) throws Exception;
	public ArrayList<TeamPlayerPlayers> viewTeamPlayer(String teamName) throws Exception;

}
