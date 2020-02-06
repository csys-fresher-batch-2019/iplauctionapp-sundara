package com.playingeleven.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import com.playingeleven.DbConnection;
import com.playingeleven.dao.PlayersDAO;
import com.playingeleven.dao.dto.Experience;
import com.playingeleven.model.Players;

public class PlayersDAOImpl implements PlayersDAO {

	public void addPlayerDetails(Players player) throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		try
		{
			con = DbConnection.getConnection();
			String sql = "INSERT INTO players(player_id,player_fullname,date_of_birth,nick_name,role_name) VALUES (player_id_sq.nextval,?,?,?,?)";
			//System.out.println(sql);
			pst = con.prepareStatement(sql);
			pst.setString(1, player.getPlayerFullName());
			pst.setDate(2, Date.valueOf(player.getDateOfBirth()));
			pst.setString(3, player.getNickName());
			pst.setString(4, player.getRoleName());
			//pst.setInt(5,player.getActive());
			int rows = pst.executeUpdate();
			//System.out.println(rows);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	finally
	{
		if(pst!=null)
		{
			pst.close();
		}
		if(con!=null)
		{
			con.close();
		}
		
	}
		
			
	}

	public void deletePlayerDetails(LocalDate dateOfBirth) throws Exception {
		Connection con=null;
		PreparedStatement pst=null;
		try
		{
			con = DbConnection.getConnection();
			String sql="UPDATE players  SET active=0  WHERE date_of_birth < ?";
			//System.out.println(sql);
			pst = con.prepareStatement(sql);
			pst.setDate(1, Date.valueOf(dateOfBirth)); 
			int rows = pst.executeUpdate();
			//System.out.println(rows)
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pst!=null)
			{
				pst.close();
			}
			if(con!=null)
			{
				
			}
		}
		

	}

	public List<Players> listRoleOfPlayers(String roleName) throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		List<Players> list = new ArrayList<Players>();
		try
		{
			con = DbConnection.getConnection();
			String sql = "select player_id,player_fullname from players where lower(role_name)=lower('" + roleName + "') and active =1";
			//System.out.println(sql);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Players p = new Players();
				p.setPlayerId(rs.getInt("player_id"));
				p.setPlayerFullName(rs.getString("player_fullname"));
				list.add(p);
			
		}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		finally
		{
			if(stmt!=null)
			{
				stmt.close();
			}
			if(con!=null)
			{
				con.close();
			}
		}
		
		
		
		return list;
		
	}

	public ArrayList<Experience> listOfExperiencedPlayers() throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		ArrayList<Experience> Experience = new ArrayList<Experience>();
		try
		{
			con = DbConnection.getConnection();
			String sql = "select players.player_fullname as player_fullname,career.matches as matches from players inner join career on player_id=career_no where active=1 order by matches desc";
			//System.out.println(sql);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String playerFullName = rs.getString("player_fullname");
				int matches = rs.getInt("matches");
				// System.out.println(player + "," + player1);
				// dat=dat + "\n"+player+","+player1;

				com.playingeleven.dao.dto.Experience e = new Experience();
				e.playerFullName = playerFullName;
				e.matches = matches;
				Experience.add(e);
			}

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(stmt!=null)
			{
				stmt.close();
			}
			if(con!=null)
			{
				con.close();
			}
		}
				
       return Experience;

	}

}
