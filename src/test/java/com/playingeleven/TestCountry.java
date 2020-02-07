package com.playingeleven;

import java.util.Scanner;

import com.playingeleven.dao.impl.CountryDAOImpl;
import com.playingeleven.model.Country;

import logger.Logger;

public class TestCountry {
	private static final Logger log=Logger.getInstance(); 

	public static void main(String[] args) throws Exception {
		insertCountry();
		}
	public static void insertCountry() throws Exception {
		Scanner sc = new Scanner(System.in);
		log.getInput("Enter Country name");
		String countryName = sc.next();
		log.getInput("Enter Player type(indian,overseas)");
		String playerType = sc.next();
		log.getInput("Enter Basic prize of the player");
		int basicPrice = sc.nextInt();
	    Country ob = new Country();
	    ob.setCountryName(countryName);
	    ob.setPlayerType(playerType);
	    ob.setBasicPrice(basicPrice);
	    CountryDAOImpl impl = new CountryDAOImpl();
		impl.addCountry(ob.getCountryName(),ob.getPlayerType(),ob.getBasicPrice());
		sc.close();
	}

}
