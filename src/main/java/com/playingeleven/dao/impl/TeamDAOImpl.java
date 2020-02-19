package com.playingeleven.dao.impl;

import java.sql.Connection;
import java.sql.Statement;

import com.playingeleven.DbConnection;
import com.playingeleven.DbException;
import com.playingeleven.dao.TeamDAO;

import logger.Logger;

public class TeamDAOImpl  implements TeamDAO {
	private static final Logger log=Logger.getInstance(); 
	public void addTeam(String teamName,String teamOwner,String teamCoach,int amountRemaining) throws DbException {
		String sql="insert into team (team_id,team_name,team_owner,team_coach,amount_remaining) values(team_id_sq.nextVal,'"+teamName+"','"+teamOwner+"','"+teamCoach+"','"+amountRemaining+"')";

		try
		(
			Connection con = DbConnection.getConnection();
						Statement stmt = con.createStatement();){
						stmt.executeUpdate(sql);
			
		}
		catch(Exception e) {
			log.error(e);
		}
	}
/*	public void UpdateTotalAmount(int teamId,int amount)throws Exception
	{
		
		String sql1="UPDATE team SET amount_remaining= bid_pricee(?,?) where team_id=?";
            int remainingAmount=0;
		try
		(
			Connection con = DbConnection.getConnection();
						PreparedStatement stmt1 = con.prepareStatement(sql1);){
			stmt1.setInt(1, teamId);
			stmt1.setInt(2, amount);
			stmt1.setInt(3,teamId);
			
			int rows=stmt1.executeUpdate();
			System.out.println(rows);
			
			
		}
		catch(Exception e) {
			log.error(e);
		}
	}*/
	@Override
	public void UpdateTotalAmount(int teamId, int amount) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
