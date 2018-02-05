package com.amazon.sde2;

import java.util.ArrayList;
import java.util.List;

public class BoysAndGirlMaxStandingTogether {

	public static void printMaxBoyOrGirlStandingTogether(int girls, int boys) {
		int max = girls > boys ? girls : boys;
		int min = girls > boys ? boys : girls;
		int result = 0;
		int rem = 0;

		if (min == 0 && max == 0) {
			result = 0;
		} else if (min == 0 || max == 0) {
			result = max;
		} else if (min < ((max + 1) / 2)) {
			result = max / (min + 1);
			rem = max % (min + 1);
			if (rem > 0) {
				result = result + 1;
			}
		} else if (min >= ((max + 1) / 2) && (max - min) >= 2) {
			result = 2;
		} else if ((max - min) < 2) {
			result = 1;
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		List<String> str = new ArrayList<>();
		str.add("3"); // no. of Test Cases
		str.add("20 5"); // 1st Test Case :
		str.add("999999 21313"); // 2nd Test Case :
		str.add("25 4");// 3rd Array Values :

		int noOfTestCases = Integer.parseInt(str.get(0));
		for (int i = 0; i < noOfTestCases; i++) {
			String indexStr = str.get(i + 1);
			int girls = Integer.parseInt(indexStr.split(" ")[0]);
			int boys = Integer.parseInt(indexStr.split(" ")[1]);
			printMaxBoyOrGirlStandingTogether(girls, boys);
		}
	}
}
