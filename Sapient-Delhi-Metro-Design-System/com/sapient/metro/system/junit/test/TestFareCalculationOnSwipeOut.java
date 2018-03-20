package com.sapient.metro.system.junit.test;


import com.sapient.metro.system.FareMapping;
import com.sapient.metro.system.MetroStation;
import com.sapient.metro.system.SmartCard;
import com.sapient.metro.system.SwipeInCommand;
import com.sapient.metro.system.SwipeOutCommand;

public class TestFareCalculationOnSwipeOut {

	SmartCard smcard = new SmartCard("1010","A1","weekend");
	
	SwipeInCommand swipeIn = new SwipeInCommand(smcard);
	SwipeOutCommand swipeOut = new SwipeOutCommand(smcard, 2);
	
	MetroStation metroStation = new MetroStation();
	
	// TEST 1 to check if correct fare is calculated
//	@Test
	   public void testFareCalculation() {
		
		metroStation.setCommand(swipeOut);
		try {
			metroStation.SwipeCard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	     // assertEquals(6, smcard.getCardbalance());
	   }
	
	   //TEST 2
	 //  to check if low balance at swipe out throws exception
///	 @Test(expected = NullPointerException.class)
	   public void testPrintMessage() throws Exception {	
	     // System.out.println("swipe out test");     
		  swipeOut = new SwipeOutCommand(smcard, 2);
			 metroStation.setCommand(swipeOut);
			metroStation.SwipeCard();
	   }
	
	  // TEST 3
	   public void testDayValidation() {
			
			metroStation.setCommand(swipeOut);
			try {
				metroStation.SwipeCard();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  //    assertEquals("weekday",FareMapping.fareMap.get(smcard.getDay()));
		   }
	   
		 
}
