package com.akshay.string;

public class SwapNeighbourDigitsKTimesToFormLargestNumber {

	private static void getLargestNumberAfterKSwap(char[] str, int swap, char[] max) {

		if (swap == 0) {
			System.out.println(max);
			return;
		}

		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (str[i] < str[j]) {
					char temp = str[i];
					str[i] = str[j];
					str[j] = temp;
					if (Integer.parseInt(new String(str)) > Integer.parseInt(new String(max))) {
						max = str;
					}

					getLargestNumberAfterKSwap(str, swap - 1, max);

					temp = str[i];
					str[i] = str[j];
					str[j] = temp;

				}
			}
		}
	}

	public static void main(String[] args) {

		int swap = 4;
		String str = "43256";
		char[] max = str.toCharArray();

		getLargestNumberAfterKSwap(str.toCharArray(), swap, max);

		System.out.println(Integer.parseInt(new String(max)));

	}

}
