package com.akshay.systemdesign.delhiMetroSystemDesign;

public class Customer {

	private CustomerCard customerCard;
	private JourneyDetails journeyDetails;
	private int customerId;
	private String customerName;

	public Customer(int customerId, String customerName, int cardId, float cardBalance) {
		this.customerCard = new CustomerCard(cardId, cardBalance);
		this.customerId = customerId;
		this.customerName = customerName;
		this.journeyDetails = new JourneyDetails();
	}

	public CustomerCard getCustomerCard() {
		return customerCard;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerCard(CustomerCard customerCard) {
		this.customerCard = customerCard;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public JourneyDetails getJourneyDetails() {
		return journeyDetails;
	}

	public void setJourneyDetails(JourneyDetails journeyDetails) {
		this.journeyDetails = journeyDetails;
	}

}
