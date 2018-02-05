package com.akshay.geekForGeek;

import java.util.Scanner;
import java.util.TreeMap;

/*
		Given an array containing N words, you need to find the most frequent word in the array. If multiple words have same frequency then print the word that comes first in lexicographical order.
		
		Input:
		The first line of the input contains a single integer T, denoting the number of test cases. Then T test case follows. Each test case contains 2 lines:-
		The size of array N
		N words separated by spaces
		
		Output:
		For each testcase, print the most frequent word.
		
		Constraints:
		1<=T<=100
		1<=N<=1000
		
		Example:
		
		Input:
		3
		3
		geeks for geeks
		2
		hello world
		3
		world wide fund
		
		Output:
		geeks
		hello
		fund
		
		Explanation:
		For testcase 1: geeks comes 2 times.
		For testcase 2: hello and world both have 1 frequency. We print hello as it comes first in lexicographical order.
*/

public class MostFrequentWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No. Of Test Cases");
		int noOfTestCases = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < noOfTestCases; i++) {
			System.out.print("Enter the " + (i + 1) + " word");
			String wordString = sc.nextLine();
			System.out.println(getMostFrequentWord(wordString));
		}
	}

	private static String getMostFrequentWord(String wordString) {
		TreeMap<String, Integer> _wordCount = new TreeMap<>();
		String words[] = wordString.split(" ");
		
		int maxCount = 0;
		String mostFreqWord = words[0];
		for (String string : words) {
			if(!_wordCount.containsKey(string.toUpperCase())){
				_wordCount.put(string.toUpperCase(), 0);
			}
			int count = _wordCount.get(string.toUpperCase())+1;
			_wordCount.put(string.toUpperCase(),count);
			
			if(count >= maxCount){
				if(string.compareToIgnoreCase(mostFreqWord.toUpperCase()) < 0){
					mostFreqWord = string.toUpperCase();
				}
				maxCount = count;
			}
		}
		
		return mostFreqWord;
	}

}
