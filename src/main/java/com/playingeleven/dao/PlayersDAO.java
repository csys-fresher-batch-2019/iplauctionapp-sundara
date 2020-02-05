package com.playingeleven.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.playingeleven.dao.dto.Experience;
import com.playingeleven.model.Players;

public interface PlayersDAO {

	public void addPlayerDetails(Players player) throws Exception;

	public void deletePlayerDetails(LocalDate dateOfBirth) throws Exception;

	public List<Players> listRoleOfPlayers(String roleName) throws Exception;

	public ArrayList<Experience> listOfExperiencedPlayers() throws Exception;

}
