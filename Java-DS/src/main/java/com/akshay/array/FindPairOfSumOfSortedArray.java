package com.akshay.array;

import java.util.HashSet;

public class FindPairOfSumOfSortedArray {

	/*
	 * It is perfect solution for sorted array with o(n) complexity
	 * 
	 * */
	public static void printPair(int[] a, int sum) {
		int low=0;
		int high=a.length-1;
		
		System.out.println("start");
		
		while(high > low ){
			
			if(sum == a[low] + a[high]){
				System.out.println("Pairs are :- " + " [ " + a[low] + " , " + a[high] + " ] ");
				high--;
				low++;
			} else if(sum < a[low] + a[high]){
				high--;
			} else if(sum > a[low] + a[high]){
				low++;
			}
		}

		System.out.println("end");

	}
	
	
	/*
	 * It is perfect solution for sorted . it is best solution
	 * https://www.youtube.com/watch?v=XKu_SEDAykw
	 * */
	public static void printPairWithLessTime(int[] a, int sum) {
		HashSet<Integer> set=new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			int diff=sum-a[i];
			if(set.contains(a[i])){
				System.out.println("Pairs are :- " + " [ " + diff + " , " + a[i] + " ] ");
				continue;
			}
			set.add(diff);
		}
		System.out.println("end");
	}
	
	
	

	public static void main(String[] args) {
		int[] a = new int[] {2,3,6,6,9,12,34,57};
		int sum=12;
		printPair(a, sum);
		printPairWithLessTime(a, sum);
	}
}
