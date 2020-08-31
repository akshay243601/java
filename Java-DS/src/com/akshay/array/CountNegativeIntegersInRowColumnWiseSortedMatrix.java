package com.akshay.array;

public class CountNegativeIntegersInRowColumnWiseSortedMatrix {

	private static int getNegativeNumbers(int[][] array) {
		int negativeNumber = 0;

		int rowLen = array.length;
		int colLen = array[0].length;

		int row = 0, col = colLen - 1;

		while (row < rowLen && col >= 0) {

			if (array[row][col] >= 0) {
				col--;
			} else {
				negativeNumber = negativeNumber + col + 1;
				row++;
			}

		}

		return negativeNumber;
	}

	public static void main(String[] args) {

		int[][] array = new int[][] 
				{ 
					{ -5, -4, -2, 5 }, 
					{ -3, -2, -1, 10 }, 
					{ -3, -2, -1, 11 }, 
					{ -3, -2, -1, 12 } 
				};
		System.out.println(getNegativeNumbers(array));
	}

}
