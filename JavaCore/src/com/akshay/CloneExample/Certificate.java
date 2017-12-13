package com.akshay.CloneExample;

import java.io.Serializable;

public class Certificate implements Serializable
{

	public Certificate(int id, String name)
	{
		this.certId = id;
		this.certName = name;
	}
	private int certId;
	private String certName;
	
	public int getCertId() {
		return certId;
	}
	
	public void setCertId(int certId) {
		this.certId = certId;
	}
	
	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}
}
