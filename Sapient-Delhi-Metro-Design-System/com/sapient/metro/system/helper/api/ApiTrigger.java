package com.sapient.metro.system.helper.api;

import java.util.List;

import com.sapient.metro.system.SmartCard;

public class ApiTrigger {
	public static void main(String[] args) {
		
		// assumed that bean will be created
	    //  ApplicationContext context =   new ClassPathContext("Beans.xml");
	      
	      try{
	   //   TravelDetailsJDBCTemplate travelDetailsJDBCTemplate =    (TravelDetailsJDBCTemplate)context.getBean("TravelDetailsJDBCTemplate");
	    	  TravelDetailsJDBCTemplate  travelDetailsJDBCTemplate=null;
	      System.out.println("------Records Creation--------" );
	     // travelDetailsJDBCTemplate.create("","","");
	      

	      System.out.println("------Listing Multiple Records--------" );
	      List<SmartCard> SmCard = travelDetailsJDBCTemplate.listCardDetails();
	      for (SmartCard record : SmCard) {
	        // System.out.print("ID : " + record.getId() );
	         
	      }
	      }catch (Exception e){
	    	  e.printStackTrace();
	      }
	     
	   }
}
