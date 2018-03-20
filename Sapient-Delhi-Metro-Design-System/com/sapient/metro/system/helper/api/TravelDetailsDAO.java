package com.sapient.metro.system.helper.api;

import java.util.List;

import javax.sql.DataSource;

import com.sapient.metro.system.SmartCard;

public interface TravelDetailsDAO {

	/** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource ds);
	   /** 
	    * This is the method to be used to create
	    * a record in the TravelDetails table.
	    */
	   public void create(String Cardname, int Balance, String StartStation, String EndStation, Double Fare);
	   /** 
	    * This is the method to be used to list down
	    * a record from the TravelDetails table corresponding
	    * to a valid Card id.
	    */
	   public SmartCard getCard(String id);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the TravelDetails table.
	    */
	   public List<SmartCard> listCardDetails();
	   
	
	}

