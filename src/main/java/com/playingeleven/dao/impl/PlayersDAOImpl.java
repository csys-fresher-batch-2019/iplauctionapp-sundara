package com.playingeleven.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.playingeleven.DbConnection;
import com.playingeleven.DbException;
import com.playingeleven.dao.PlayersDAO;
import com.playingeleven.dao.dto.Experience;
import com.playingeleven.model.Players;

import logger.Logger;

public class PlayersDAOImpl implements PlayersDAO {
	private static final Logger log=Logger.getInstance(); 

	public void addPlayerDetails(Players player) throws DbException {
		String sql = "INSERT INTO players(player_id,player_fullname,date_of_birth,nick_name,role_name,player_image) VALUES (player_id_sq.nextval,?,?,?,?,?)";

	
		try(Connection con = DbConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);)
			{
			pst.setString(1, player.getPlayerFullName());
			pst.setDate(2, Date.valueOf(player.getDateOfBirth()));
			pst.setString(3, player.getNickName());
			pst.setString(4, player.getRoleName());
			pst.setString(5, player.getPlayerImage());
			pst.executeUpdate();
			}
		catch(Exception e)
		{
			log.error(e);
		}	
	}

	public void deletePlayerDetails(LocalDate dateOfBirth) throws DbException {
		String sql="UPDATE players  SET active=0  WHERE date_of_birth < ?";
		
		try(	Connection 		con = DbConnection.getConnection();
			
			PreparedStatement pst = con.prepareStatement(sql);){
			pst.setDate(1, Date.valueOf(dateOfBirth)); 
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			log.error(e);
		}
	}

	public List<Players> listRoleOfPlayers(String roleName) throws DbException {
	
		List<Players> list = new ArrayList<Players>();
		String sql = "select player_id,player_image,player_fullname from players where lower(role_name)=lower('" + roleName + "') and active =1";
		try
		(
			Connection con = DbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);){
			while (rs.next()) {
				Players p = new Players();
				p.setPlayerId(rs.getInt("player_id"));
				p.setPlayerImage(rs.getString("player_image"));
				p.setPlayerFullName(rs.getString("player_fullname"));
				list.add(p);
			
		}
		}
			catch(SQLException e)
			{
				log.error(e);
			}
		return list;
		
	}

	public ArrayList<Experience> listOfExperiencedPlayers() throws DbException {

	
		ArrayList<Experience> Experience = new ArrayList<Experience>();
	
			
			String sql = "select players.player_image as player_image,players.player_fullname as player_fullname,career.matches as matches from players inner join career on player_id=career_no where active=1 order by matches desc";
			try(Connection con = DbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);){
			
			while (rs.next()) {
				String playerImage=rs.getString(1);
				String playerFullName = rs.getString(2);
				int matches = rs.getInt(3);
                com.playingeleven.dao.dto.Experience e = new Experience();
    
                e.setPlayerImage(playerImage);
				e.setPlayerFullName(playerFullName);
				e.setMatches(matches);
				Experience.add(e);
			}
}
		catch(SQLException e)
		{
			log.error(e);
		}
				
       return Experience;

	}

}
