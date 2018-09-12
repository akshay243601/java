package com.akshay.coreBasics;

public class EnumTest {

	public enum days {
		MON, TUES, WED
	};

	public static void main(String[] args) {
		for (days d : days.values()) {
			days[] d2 = days.values();
			System.out.println(d2[2]);
		}

	}

}
