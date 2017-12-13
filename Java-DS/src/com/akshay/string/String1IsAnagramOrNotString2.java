package com.akshay.string;

import java.util.Arrays;

public class String1IsAnagramOrNotString2 {

	private static boolean isString1AnagramOrNotString2(String smallStr, String largeStr) {

		for (int i = 0; i < largeStr.length() - smallStr.length() + 1; i++) {
			if (isAnagram2(smallStr, largeStr.substring(i, i + smallStr.length()))) {
				return true;
			}
		}
		return false;
	}

	// Method 1
	private static boolean isAnagram(String Str1, String Str2) {

		StringBuilder temp = new StringBuilder(Str1.replaceAll(" ", ""));
		for (char ch : Str2.toCharArray()) {
			int index = temp.indexOf("" + ch);
			if (index > -1) {
				temp.deleteCharAt(index);
			} else {
				return false;
			}
		}
		if (temp.length() == 0) {
			return true;
		}
		return false;
	}

	// Method 2
	private static boolean isAnagram2(String Str1, String Str2) {

		char[] char1 = Str1.replaceAll(" ", "").toCharArray();
		char[] char2 = Str2.replaceAll(" ", "").toCharArray();

		Arrays.sort(char1);
		Arrays.sort(char2);

		Str1 = new String(char1);
		Str2 = new String(char2);

		return char1.equals(char2);

	}

	public static void main(String[] args) {
		String smallStr = "mazo";
		String largeStr = "amazon";
		System.out.println(isString1AnagramOrNotString2(smallStr, largeStr));
	}
}