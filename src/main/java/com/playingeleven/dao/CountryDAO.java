package com.playingeleven.dao;

import com.playingeleven.DbException;

public interface CountryDAO {
	public void addCountry(String countryName,String playerType,int basicPrice) throws DbException;
	

}
