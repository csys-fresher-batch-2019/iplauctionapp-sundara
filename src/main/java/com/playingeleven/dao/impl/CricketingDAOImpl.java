package com.playingeleven.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.playingeleven.DbConnection;
import com.playingeleven.DbException;
import com.playingeleven.dao.CricketingDAO;
import com.playingeleven.dao.dto.Batting;
import com.playingeleven.dao.dto.Bowling;

import logger.Logger;

public class CricketingDAOImpl implements CricketingDAO {
	private static final Logger log=Logger.getInstance(); 
    public void addCricketingDetails(int jerseyNo,String batting, String bowling,
			String bowlingSpeed) throws DbException 
	{
		String sql = "insert into cricketing(cric_no,jersey_no,batting,bowling,bowling_speed)values(cric_no_sq.nextval,'" + jerseyNo + "','" + batting + "','" + bowling + "','"+ bowlingSpeed + "')";
		
  		try(	Connection	con = DbConnection.getConnection();
			Statement stmt = con.createStatement();){
			stmt.executeUpdate(sql);
			
		}
		catch(Exception e)
		{
			log.error(e);
		}
	}

	public void deleteCricketingDetails(int cricNo) throws DbException {
		
		String sql = "DELETE FROM cricketing WHERE cric_no='" + cricNo + "'";
		
		try(	Connection con = DbConnection.getConnection();

			Statement 	stmt = con.createStatement();){
			 stmt.executeUpdate(sql);
	}
		catch(Exception e)
		{
			log.error(e);
		}
}

	public ArrayList<Batting> bestBattingAverage() throws DbException 
	{
		ArrayList<Batting> Batting = new ArrayList<Batting>();
		String sql = "select * from ( select p.player_image,p.player_fullname as player_fullname,p.role_name as role_name,r.batting as batting,round(BATTING_AVERAGE_CALC(runs_scored, not_outs,innings),2)as batting_average, rank() over (order by round(BATTING_AVERAGE_CALC(runs_scored,not_outs,innings)) desc) as rank from players p, career c,cricketing r where p.player_id = c.career_no and p.player_id=r.cric_no and  (role_name IN('batsman','wicketkeeper/Batsman')) and active=1) ";
		try(Connection con = DbConnection.getConnection();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql);){
while (rs.next()) {
	String playerImage=rs.getString("player_image");
				String playerFullName = rs.getString("player_fullname");
				String roleName = rs.getString("role_name");
				String batting = rs.getString("batting");
				int battingAverage = rs.getInt("batting_average");
				int rank = rs.getInt("rank");
	            com.playingeleven.dao.dto.Batting b = new Batting();
	            b.setPlayerImage(playerImage);
				b.setPlayerFullName(playerFullName);
				b.setRoleName(roleName);
				b.setBatting(batting);
				b.setBattingAverage(battingAverage);
				b.setRank(rank);
				Batting.add(b);
		
			}
			}
	catch (SQLException e) {
		log.error(e);
	}
			return Batting;
			}
public ArrayList<Bowling> bestBowlingAverage() throws DbException {
		ArrayList<Bowling> Bowling = new ArrayList<Bowling>();
		String sql = "select * from ( select p.player_image,p.player_fullname,p.role_name,r.bowling,r.bowling_speed,round(BOWLING_AVERAGE_CALC (runs_conceded,wickets),2) as bowling_average, rank() over (order by round(BOWLING_AVERAGE_CALC(runs_conceded,wickets)) asc) as rank from players p, career c,cricketing r where p.player_id = c.career_no and p.player_id=r.cric_no and role_name='bowler' and active=1  )";
			try(Connection con = DbConnection.getConnection();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql);){
				while (rs.next()) {
					String playerImage=rs.getString("player_image");
				String playerFullName = rs.getString("player_fullname");
				String roleName = rs.getString("role_name");
				String bowling = rs.getString("bowling");
				int bowlingAverage = rs.getInt("bowling_average");
				int rank = rs.getInt("rank");
				com.playingeleven.dao.dto.Bowling bo = new Bowling();
				bo.setPlayerImage(playerImage);
				bo.setPlayerFullName(playerFullName);
				bo.setRoleName(roleName);
				bo.setBowling(bowling);
				bo.setBowlingAverage(bowlingAverage);
				bo.setRank(rank);
				Bowling.add(bo);
			}
		}
		catch (SQLException e) {
			log.error(e);
		}
		return Bowling;
	}
}
