package com.akshay.array;

import java.util.HashSet;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class FindWordInChessBoard {

	public static Set<Integer> set = new HashSet<>();
	public static boolean isWordPresent(char[][] a, String word) {

		if (a != null && a.length > 0 && word != null && word.length() > 0) {
			char ch = word.charAt(0);

			int length = a.length;
			int colLen = a[0].length;

			System.out.println("Row Length :- " + length + " colLength :- " + colLen);
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < colLen; j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}

			boolean isFound;
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < colLen; j++) {
					if (ch == a[i][j]) {
						isFound = isPresent(a, 0, i, j, word);
						if (isFound) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static boolean isPresent(char[][] a, int index, int row, int column, String word) {
		
		

		if (!(word.length() > index && a.length > row && row > -1 && column > -1 & a[0].length > column)) {
			return false;
		}

			char ch = word.charAt(index);
			if (ch == a[row][column]) {
				
				//Set it to # so that it will not count again for the same search
				a[row][column]='#';
				if (word.length() == index + 1) {
					return true;
				}
			} else {
				return false;
			}
			boolean isFound =	
					isPresent(a, index + 1, row, column + 1, word) 
					|| isPresent(a, index + 1, row, column - 1, word)
					|| isPresent(a, index + 1, row + 1, column, word) 
					|| isPresent(a, index + 1, row - 1, column, word)
					|| isPresent(a, index + 1, row - 1, column + 1, word)
					|| isPresent(a, index + 1, row + 1, column + 1, word)
					|| isPresent(a, index + 1, row - 1, column - 1, word)
					|| isPresent(a, index + 1, row + 1, column - 1, word);
	
			
			//reset it for further search
			a[row][column] = ch;
			return isFound;
		
	}

	public static void main(String[] args) {
		char a[][]= {
				{'A', 'S', 'H'},
				{'K', 'A', 'S'},
				{'Y', 'A', 'K'},
				};
/*		System.out.println(isWordPresent(a, "AKSHAY"));
		System.out.println(isWordPresent(a, "STAKSBFARAAAA"));*/
		System.out.println(isWordPresent(a, "AKSHSKA"));

	}
}
