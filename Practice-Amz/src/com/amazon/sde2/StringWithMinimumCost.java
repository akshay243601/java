package com.amazon.sde2;

import java.util.ArrayList;
import java.util.List;

public class StringWithMinimumCost {

	public static void printCost(String CtoBuild, int A, int B) {
		int money = 0;
		String temp = "";
		String buildedString = "";
		int index = 0;
		boolean isRemoveLastIndex = false;
		while (index < CtoBuild.length()) {
			if ((CtoBuild.charAt(index) + "").equals(" ") || !Character.isLetter(CtoBuild.charAt(index))) {
				buildedString = buildedString + CtoBuild.charAt(index) + "";
				index++;
				continue;
			} else if (index < CtoBuild.length() && !buildedString.contains(CtoBuild.charAt(index) + "")) {
				buildedString = buildedString + CtoBuild.charAt(index);
				money = money + A;
				index++;
			} else {
				isRemoveLastIndex = false;
				temp = CtoBuild.charAt(index) + "";
				while (index < CtoBuild.length() && buildedString.contains(temp)) {
					index++;
					isRemoveLastIndex = true;
					if (index < CtoBuild.length()) {
						temp = temp + CtoBuild.charAt(index);
					} else {
						isRemoveLastIndex = false;
					}
				}

				if (isRemoveLastIndex) {
					temp = temp.substring(0, temp.length() - 1);
					isRemoveLastIndex = false;
				}
				buildedString = buildedString + temp;
				if ((isRemoveLastIndex && temp.length() < 1) || temp.length() < 2) {
					money = money + A;
				} else {
					money = money + B;
				}
			}
		}
		System.out.println(money);
	}

	public static void main(String[] args) {
		List<String> str = new ArrayList<>();
		str.add("9 8 9"); // no. of Test Cases
		str.add("abab"); // 1st Test Case : Array Size , Val

		String indexStr = str.get(0);

		int strLen = Integer.parseInt(indexStr.split(" ")[0]);
		int aPrice = Integer.parseInt(indexStr.split(" ")[1]);
		int bPrice = Integer.parseInt(indexStr.split(" ")[2]);

		indexStr = str.get(1);
		System.out.println(indexStr);
		printCost(indexStr, aPrice, bPrice);
	}
}
