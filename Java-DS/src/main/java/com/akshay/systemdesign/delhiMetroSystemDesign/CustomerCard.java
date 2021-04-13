package com.akshay.systemdesign.delhiMetroSystemDesign;

public class CustomerCard extends BaseCard {

	private int cardId;
	private float cardBalance;

	public CustomerCard(int cardId, float cardBalance) {
		this.cardId = cardId;
		this.cardBalance = cardBalance;
	}

	public int getCardId() {
		return cardId;
	}

	public float getCardBalance() {
		return cardBalance;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public void setCardBalance(float cardBalance) {
		this.cardBalance = cardBalance;
	}

}
