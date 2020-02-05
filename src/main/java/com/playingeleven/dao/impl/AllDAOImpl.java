package com.playingeleven.dao.impl;

public class AllDAOImpl {

	
public static boolean exists(String tableName,int id) {
	boolean exists=false;
	String sql="select * from "+tableName+" where id = ? ";
	return exists;
	}
}
 