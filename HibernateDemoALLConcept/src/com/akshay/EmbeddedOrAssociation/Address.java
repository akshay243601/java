package com.akshay.EmbeddedOrAssociation;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Address {
	private int AddressId;
	
	@Column(name="AddressName")
	private String AddressName;

	public int getAddressId() {
		return AddressId;
	}

	public void setAddressId(int addressId) {
		AddressId = addressId;
	}

	public String getAddressName() {
		return AddressName;
	}

	public void setAddressName(String addressName) {
		AddressName = addressName;
	}

}
