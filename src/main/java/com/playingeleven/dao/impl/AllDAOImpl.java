package com.playingeleven.dao.impl;

import logger.Logger;

public class AllDAOImpl {
private static final Logger log=Logger.getInstance(); 
	
public static boolean exists(String tableName,int id) {
	boolean exists=false;
	String sql="select * from "+tableName+" where id = ? ";
	return exists;
	}
}
 