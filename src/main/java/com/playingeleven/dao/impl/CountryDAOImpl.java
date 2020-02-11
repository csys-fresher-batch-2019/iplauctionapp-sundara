package com.playingeleven.dao.impl;

import java.sql.Connection;
import java.sql.Statement;

import com.playingeleven.DbConnection;
import com.playingeleven.DbException;

import logger.Logger;

public class CountryDAOImpl {
	private static final Logger log=Logger.getInstance(); 
	public void addCountry(String countryName,String playerType,int basicPrice) throws DbException {
		
		String sql="insert into country (playerr_id,country_name,player_type,basic_price) values(playerr_id_sq.nextVal,'"+countryName+"','"+playerType+"','"+basicPrice+"')";

		try
		{
			Connection con = DbConnection.getConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			log.error(e);
		}
}
}
