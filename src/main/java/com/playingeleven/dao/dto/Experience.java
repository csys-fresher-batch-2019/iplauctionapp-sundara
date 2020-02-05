package com.playingeleven.dao.dto;

public class Experience {

	public String playerFullName;
	public int matches;

	@Override
	public String toString() {
		return "Experience [playerFullName=" + playerFullName + "| matches=" + matches + "]";
	}
}
