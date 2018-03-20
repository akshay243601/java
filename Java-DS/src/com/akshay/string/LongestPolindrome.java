package com.akshay.string;

public class LongestPolindrome {

	private static String getLongestPolingdrome(String value) {

		if (value == null || value.length() == 0) {
			return null;
		}

		String longestPolingdrome = value.substring(0, 1);
		for (int i = 0; i < value.length() - 1; i++) {
			String palingdrome = getInterPolingdrome(value, i, i);
			if (palingdrome.length() > longestPolingdrome.length()) {
				longestPolingdrome = palingdrome;
			}

			palingdrome = getInterPolingdrome(value, i, i + 1);
			if (palingdrome.length() > longestPolingdrome.length()) {
				longestPolingdrome = palingdrome;
			}

		}

		return longestPolingdrome;
	}

	private static String getInterPolingdrome(String value, int left, int right) {
		if (left > right)
			return null;
		
		while (left >= 0 && right < value.length() && value.charAt(left) == value.charAt(right)) {
			left--;
			right++;
		}
		
		return value.substring(left + 1, right);
	}

	public static void main(String args[]) {

		System.out.println(getLongestPolingdrome("sdhaaaaaaaaajkdhsjhfjkdhjfhdjhkAkshayyahskAskhsdjfhdkjfd"));
		System.out.println(getLongestPolingdrome("aa1aaaaa"));

	}
}
