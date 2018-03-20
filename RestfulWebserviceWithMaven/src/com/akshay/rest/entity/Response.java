package com.akshay.rest.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {
	private String message;
	private boolean isSuccess;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}
