package com.akshay.SerializationExample;

import java.io.Serializable;

public class Address implements Serializable
{
	private int addressId;
	private String Addressname;
	
	public int getAddressId() {
		return addressId;
	}
	
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	public String getAddressname() {
		return Addressname;
	}
	
	public void setAddressname(String addressname) {
		Addressname = addressname;
	}
}
