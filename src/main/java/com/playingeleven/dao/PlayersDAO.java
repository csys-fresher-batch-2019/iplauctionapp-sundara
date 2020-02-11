package com.playingeleven.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.playingeleven.DbException;
import com.playingeleven.dao.dto.Experience;
import com.playingeleven.model.Players;

public interface PlayersDAO {

	public void addPlayerDetails(Players player) throws DbException;

	public void deletePlayerDetails(LocalDate dateOfBirth) throws DbException;

	public List<Players> listRoleOfPlayers(String roleName) throws DbException;

	public ArrayList<Experience> listOfExperiencedPlayers() throws DbException;

}
