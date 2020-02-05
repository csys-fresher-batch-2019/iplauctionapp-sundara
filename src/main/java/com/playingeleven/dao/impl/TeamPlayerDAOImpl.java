package com.playingeleven.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.playingeleven.DbConnection;
import com.playingeleven.dao.dto.Bowling;
import com.playingeleven.dao.dto.TeamPlayerPlayers;

public class TeamPlayerDAOImpl {
	public void addTeamPlayer(int playrId,int teammId,int soldPrice) throws Exception {
		Connection con = DbConnection.getConnection();
		String sql="insert into teamplayer (playr_id,teamm_id,sold_price) values('"+playrId+"','"+teammId+"','"+soldPrice+"')";
		Statement stmt = con.createStatement();
		int row = stmt.executeUpdate(sql);
		//System.out.println(row);
		con.close();

	}
	public ArrayList<TeamPlayerPlayers> viewTeamPlayer(String teamName) throws Exception {
		Connection con = DbConnection.getConnection();
		String sql = "select p.player_fullname,p.role_name,o.player_type,tp.sold_price from players p,country o,teamplayer tp,team t where player_id=playerr_id and playr_id=player_id and team_id = teamm_id and team_name='"+teamName+"'";
		System.out.println(sql);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<TeamPlayerPlayers> TeamPlayerPlayers = new ArrayList<TeamPlayerPlayers>();
		while (rs.next()) {
			String playerFullName = rs.getString("player_fullname");
			String roleName = rs.getString("role_name");
			String playerType=rs.getString("player_Type");
			int soldPrice = rs.getInt("sold_price");
			com.playingeleven.dao.dto.TeamPlayerPlayers bo = new TeamPlayerPlayers();
			bo.playerFullName = playerFullName;
			bo.roleName = roleName;
			bo.playerType=playerType;
			bo.soldPrice= soldPrice;
			TeamPlayerPlayers.add(bo);
		}
		con.close();
		return TeamPlayerPlayers;
	}

}
