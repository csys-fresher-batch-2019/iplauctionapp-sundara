package com.playingeleven.dao.impl;

import java.sql.Connection;
import java.sql.Statement;

import com.playingeleven.DbConnection;
import com.playingeleven.dao.CareerDAO;

import logger.Logger;

public class CareerDAOImpl implements CareerDAO {
	private static final Logger log=Logger.getInstance(); 

	public void addCareerDetails(int matches, int innings, int notOuts, int runsScored, int ballsBowled,
			int runsConceded, int wickets, int catches, int stumpings) throws Exception {
		Connection con=null;
		Statement stmt=null;
		try
		{
			con = DbConnection.getConnection();
			String sql = "insert into career(career_no,matches,innings,not_outs,runs_scored,balls_bowled,runs_conceded,wickets,catches,stumpings) values(career_no_sq.nextval,'"
					+ matches + "','" + innings + "','" + notOuts + "','" + runsScored + "','" + ballsBowled + "','"
					+ runsConceded + "','" + wickets + "','" + catches + "','" + stumpings + "')";
			//log.getInput(sql);
			stmt = con.createStatement();
			int row = stmt.executeUpdate(sql);
			
		}
		catch(Exception e)
		{
			
			log.error(e);
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
		

	}

	public void deleteCareerDetails(int careerNo) throws Exception {
		
		Connection con=null;
		Statement stmt=null;
		try
		{
			con = DbConnection.getConnection();
			String sql = "DELETE FROM career WHERE career_no='" + careerNo + "'";
			//log.getInput(sql);
			stmt = con.createStatement();
			int row = stmt.executeUpdate(sql);
			//log.getInput(row);
			
		}
		catch(Exception e)
		{
			log.error(e);
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
		
	}

	public void updateCareerDetails(int careerNo, int matches, int innings, int notOuts, int runsScored,
			int ballsBowled, int runsConceded, int wickets, int catches, int stumpings) throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		try
		{
			con = DbConnection.getConnection();
			String sql = "update career set matches=matches +" + matches + ",innings=innings+" + innings
					+ ",not_outs=not_outs+" + notOuts + ",runs_scored=runs_scored+ " + runsScored
					+ ",balls_bowled=balls_bowled+ " + ballsBowled + ",runs_conceded=runs_conceded+ " + runsConceded
					+ ",wickets=wickets+ " + wickets + ",catches=catches+" + catches + ",stumpings=stumpings+ " + stumpings
					+ " where career_no=" + careerNo + "";
			//log.getInput(sql);
			stmt = con.createStatement();
			int row = stmt.executeUpdate(sql);
			//log.getInput(row);

			
		}
		catch(Exception e)
		{
			log.error(e);
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

	}

}
