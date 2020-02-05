package com.playingeleven.dao.impl;

import java.sql.Connection;
import java.sql.Statement;

import com.playingeleven.DbConnection;

public class TeamDAOImpl {
	public void addTeam(String teamName,String teamOwner,String teamCoach,int amountRemaining) throws Exception {
		Connection con = DbConnection.getConnection();
		String sql="insert into team (team_id,team_name,team_owner,team_coach,amount_remaining) values(team_id_sq.nextVal,'"+teamName+"','"+teamOwner+"','"+teamCoach+"','"+amountRemaining+"')";
		Statement stmt = con.createStatement();
		int row = stmt.executeUpdate(sql);
		//System.out.println(row);
		con.close();

	}

}
