package com.akshay.enums;

import com.sun.org.apache.regexp.internal.recompile;

enum StationEnum {
	A1 ("Station A1"), A2("Station A2");
	String stationName = "";
	StationEnum(String stationName) {
		System.out.println("By Cons. calling : " + stationName);
		this.stationName = stationName;
	}
	
	public static StationEnum getEnumValue(String stationName) {
		if(stationName.equalsIgnoreCase("A1")){
			return A1;
		} else {
			return A2;
		}
	}
	

}

public class EnumDemo {

	public static void main(String[] args) {
		System.out.println(StationEnum.getEnumValue(StationEnum.A1.toString()));
	}

}
