package com.playingeleven.dao.impl;

import java.sql.Connection;
import java.sql.Statement;

import com.playingeleven.DbConnection;

import logger.Logger;

public class CountryDAOImpl {
	private static final Logger log=Logger.getInstance(); 
	public void addCountry(String countryName,String playerType,int basicPrice) throws Exception {
		Connection con=null;
		Statement stmt=null;
		try
		{
			con = DbConnection.getConnection();
			String sql="insert into country (playerr_id,country_name,player_type,basic_price) values(playerr_id_sq.nextVal,'"+countryName+"','"+playerType+"','"+basicPrice+"')";
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


}
