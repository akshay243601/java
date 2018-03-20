package com.akshay.systemdesign.delhiMetroSystemDesign;

import java.util.Calendar;
import java.util.Date;

public class DelhiMetroDesignDemo {

	public void swipeIn(Customer customer, Stations statationName) throws Exception {
		if (!isSwipInAllow(customer)) {
			throw new Exception("Card balance is low. Please recharge your card");
		}
		customer.getJourneyDetails().setStartStation(statationName);
	}

	public void swipeOut(Customer customer, Stations destination) throws Exception {
		float fare = getTotalfare(customer.getJourneyDetails().getStartStation(),
				destination);
		
		System.out.println("Starting Point is : " + customer.getJourneyDetails().getStartStation() + "  Destination : " + destination + "  fare : " + fare);
		if (fare > customer.getCustomerCard().getCardBalance()) {
			throw new Exception("Card Balace is low.");
		}
		customer.getCustomerCard().setCardBalance(customer.getCustomerCard().getCardBalance() - fare);
		customer.setJourneyDetails(new JourneyDetails());
	}

	public float getTotalfare(Stations startPoint, Stations endPoint) throws Exception {
		return  BaseCard.farePerDay.get(new Date().getDay()) * noOfStationTraveled(startPoint, endPoint);
	}

	public int noOfStationTraveled(Stations startPoint, Stations endPoint) throws Exception {
		return Math.abs(startPoint.ordinal() - endPoint.ordinal());
	}

	
	public boolean isSwipInAllow(Customer customer) {
		return customer != null && customer.getCustomerCard() != null
				&& customer.getCustomerCard().getCardBalance() >= BaseCard.MIN_CARD_BALANCE;
	}

	public static void main(String[] args) {
		Customer customer = new Customer(1, "Akshay", 101, 50);
		DelhiMetroDesignDemo delhiMetroDesignDemo = new DelhiMetroDesignDemo();
		try{
			delhiMetroDesignDemo.swipeIn(customer, Stations.A1);
			delhiMetroDesignDemo.swipeOut(customer, Stations.A3);
			System.out.println("Card remaining Balance : " + customer.getCustomerCard().getCardBalance());
			
			
			delhiMetroDesignDemo.swipeIn(customer, Stations.A4);
			delhiMetroDesignDemo.swipeOut(customer, Stations.A1);
			System.out.println("Card remaining Balance : " + customer.getCustomerCard().getCardBalance());

			
			
			delhiMetroDesignDemo.swipeIn(customer, Stations.A13);
			delhiMetroDesignDemo.swipeOut(customer, Stations.A13);
			System.out.println("Card remaining Balance : " + customer.getCustomerCard().getCardBalance());

			
		} catch (Exception e){
			System.out.println(e);
		}
	}

}
