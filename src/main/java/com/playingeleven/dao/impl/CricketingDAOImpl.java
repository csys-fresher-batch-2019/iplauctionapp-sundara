package com.playingeleven.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.playingeleven.DbConnection;
import com.playingeleven.dao.CricketingDAO;
import com.playingeleven.dao.dto.Batting;
import com.playingeleven.dao.dto.Bowling;
import com.playingeleven.dao.dto.Experience;

public class CricketingDAOImpl implements CricketingDAO {

	public void addCricketingDetails(int jerseyNo,String batting, String bowling,
			String bowlingSpeed) throws Exception {
		Connection con = DbConnection.getConnection();
		String sql = "insert into cricketing(cric_no,jersey_no,batting,bowling,bowling_speed)values(cric_no_sq.nextval,'" + jerseyNo + "','" + batting + "','" + bowling + "','"+ bowlingSpeed + "')";
		//System.out.println(sql);
		Statement stmt = con.createStatement();
		int row = stmt.executeUpdate(sql);
		//System.out.println(row);
		con.close();

	}

	public void deleteCricketingDetails(int cricNo) throws Exception {
		Connection con = DbConnection.getConnection();
		String sql = "DELETE FROM cricketing WHERE cric_no='" + cricNo + "'";
		//System.out.println(sql);
		Statement stmt = con.createStatement();
		int row = stmt.executeUpdate(sql);
		//System.out.println(row);
		con.close();

	}

	public ArrayList<Batting> bestBattingAverage() throws Exception {
		Connection con = DbConnection.getConnection();
		String sql = "select * from ( select p.player_fullname as player_fullname,p.role_name as role_name,r.batting as batting,round(BATTING_AVERAGE_CALC(runs_scored, not_outs,innings),2)as batting_average, rank() over (order by round(BATTING_AVERAGE_CALC(runs_scored,not_outs,innings)) desc) as rank from players p, career c,cricketing r where p.player_id = c.career_no and p.player_id=r.cric_no and  (role_name IN( 'batsman' , 'wicketkeeper/Batsman')) and active=1  ) where rank <=2 ";
		//System.out.println(sql);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Batting> Batting = new ArrayList<Batting>();
		while (rs.next()) {
			String playerFullName = rs.getString("player_fullname");
			String roleName = rs.getString("role_name");
			String batting = rs.getString("batting");
			int battingAverage = rs.getInt("batting_average");
			int rank = rs.getInt("rank");
            com.playingeleven.dao.dto.Batting b = new Batting();
			b.playerFullName = playerFullName;
			b.roleName = roleName;
			b.batting = batting;
			b.battingAverage = battingAverage;
			b.rank = rank;
			Batting.add(b);
		}
		con.close();

		return Batting;
	}

	public ArrayList<Bowling> bestBowlingAverage() throws Exception {
		Connection con = DbConnection.getConnection();
		String sql = "select * from ( select p.player_fullname,p.role_name,r.bowling,r.bowling_speed,round(BOWLING_AVERAGE_CALC (runs_conceded,wickets),2) as bowling_average, rank() over (order by round(BOWLING_AVERAGE_CALC(runs_conceded,wickets)) asc) as rank from players p, career c,cricketing r where p.player_id = c.career_no and p.player_id=r.cric_no and role_name='bowler' and active=1  ) where rank<=2";
		//System.out.println(sql);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Bowling> Bowling = new ArrayList<Bowling>();
		while (rs.next()) {
			String playerFullName = rs.getString("player_fullname");
			String roleName = rs.getString("role_name");
			String bowling = rs.getString("bowling");
			int bowlingAverage = rs.getInt("bowling_average");
			int rank = rs.getInt("rank");
			com.playingeleven.dao.dto.Bowling bo = new Bowling();
			bo.playerFullName = playerFullName;
			bo.roleName = roleName;
			bo.bowling = bowling;
			bo.bowlingAverage = bowlingAverage;
			bo.rank = rank;
			Bowling.add(bo);
		}
		con.close();
		return Bowling;
	}
}
