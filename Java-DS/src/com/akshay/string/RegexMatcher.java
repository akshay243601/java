package com.akshay.string;

public class RegexMatcher {

	private static boolean isValid(String regex, String s) {

		if (regex == null || s == null || regex.length() == 0 || s.length() == 0) {
			return false;
		}
		
		int prev = 0, k = 0;
		for (int i = 0; i < s.length(); i++) {

			char ch = regex.charAt(k);

			if (ch == '*') {
				k++;
				continue;
			} else if (ch == '?') {
				if (k == i) {
					i = i + 1;
				} else {
					return false;
				}
			} else {

				int index = s.indexOf(ch);
				if (index < 0) {
					return false;
				}
				
				s = s.substring(index + 1, s.length());
				k++;
				// }
			}

		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValid("a?ksh?", "akshj"));
	}

}
