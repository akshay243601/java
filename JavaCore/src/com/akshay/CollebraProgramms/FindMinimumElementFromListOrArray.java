package com.akshay.CollebraProgramms;

public class FindMinimumElementFromListOrArray 
{
	
	
	
	public static void main(String args[])
	{
		
		int[] arr = {3,1,34,21,54,55,2,4,5,23,21};
		printMinimumElement(arr);
		printMmaximumElement(arr);
	}

	private static void printMinimumElement(int[] arr) {
		
		int temp = arr[0];
		for (int i : arr) {
			if(temp > i)
			{
				temp = i;
			}
		}
		System.out.println(temp);
	}
	
	private static void printMmaximumElement(int[] arr) {
		
		int temp = arr[0];
		for (int i : arr) {
			if(temp < i)
			{
				temp = i;
			}
		}
		System.out.println(temp);
		
	}

}
