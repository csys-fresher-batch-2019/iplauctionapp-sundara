package com.playingeleven.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.playingeleven.DbConnection;
import com.playingeleven.DbException;
import com.playingeleven.dao.dto.TeamPlayerPlayers;

import logger.Logger;

public class TeamPlayerDAOImpl {
	private static final Logger log=Logger.getInstance(); 
	public void addTeamPlayer(int playrId,int teammId,int soldPrice) throws DbException {
		Connection con=null;
		Statement stmt=null;
		try
		{
			con= DbConnection.getConnection();
			String sql="insert into teamplayer (playr_id,teamm_id,sold_price) values('"+playrId+"','"+teammId+"','"+soldPrice+"')";
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			//log.getInput(row);
			}
		catch(Exception e)
		{
			log.error(e);
		}
		

	}
	public ArrayList<TeamPlayerPlayers> viewTeamPlayer(String teamName) throws DbException {
	
		ArrayList<TeamPlayerPlayers> TeamPlayerPlayers = new ArrayList<TeamPlayerPlayers>();
		String sql = "select p.player_fullname,p.role_name,o.player_type,tp.sold_price from players p,country o,teamplayer tp,team t where player_id=playerr_id and playr_id=player_id and team_id = teamm_id and team_name='"+teamName+"'";
		try
		(Connection con=DbConnection.getConnection();Statement stmt=con.createStatement();ResultSet rs = stmt.executeQuery(sql);){
		while (rs.next()) {
				String playerFullName = rs.getString("player_fullname");
				String roleName = rs.getString("role_name");
				String playerType=rs.getString("player_Type");
				int soldPrice = rs.getInt("sold_price");
				com.playingeleven.dao.dto.TeamPlayerPlayers bo = new TeamPlayerPlayers();
				bo.setPlayerFullName(playerFullName);
				bo.setRoleName(roleName);
				bo.setPlayerType(playerType);
				bo.setSoldPrice(soldPrice);
				TeamPlayerPlayers.add(bo);
			}
		}
				
		catch(SQLException e)
		{
		log.error(e);
		}
		
		return TeamPlayerPlayers;
	}

}
