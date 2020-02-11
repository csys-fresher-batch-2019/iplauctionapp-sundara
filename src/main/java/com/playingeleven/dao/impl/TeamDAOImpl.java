package com.playingeleven.dao.impl;

import java.sql.Connection;
import java.sql.Statement;

import com.playingeleven.DbConnection;
import com.playingeleven.DbException;

import logger.Logger;

public class TeamDAOImpl {
	private static final Logger log=Logger.getInstance(); 
	public void addTeam(String teamName,String teamOwner,String teamCoach,int amountRemaining) throws DbException {
		String sql="insert into team (team_id,team_name,team_owner,team_coach,amount_remaining) values(team_id_sq.nextVal,'"+teamName+"','"+teamOwner+"','"+teamCoach+"','"+amountRemaining+"')";

		try
		{
			Connection con = DbConnection.getConnection();
						Statement stmt = con.createStatement();
						stmt.executeUpdate(sql);
			
		}
		catch(Exception e) {
			log.error(e);
		}
	}

}
