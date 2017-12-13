package com.akshay.CollebraProgramms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeTwoArray 
{	
	private static void mergeTwoArrayIntoOne() 
	{
		int[] arr1 = {1,3,4,2,58,32,34,12,42,54,10};
		int[] arr2 = {1,1,2,20,14,42,458,432,344,142,7,4,1};

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int i = 0;
		int j = 0;
		
		System.out.println(arr1);
		System.out.println(arr2);
		
		int[] sortedArray = new int[arr1.length + arr2.length -1];
		
		for(int k = 0; k < arr1.length + arr2.length -1 ; k++)
		{
			if(i>=arr1.length)
			{
				System.out.println(arr2[j]);
				sortedArray[k] = arr2[j];
				j++;
			}
			else if(j >=arr2.length)
			{
				System.out.println(arr1[i]);
				sortedArray[k] = arr1[i];
				i++;
			}
			else if(arr1[i] < arr2[j])
			{
				System.out.println(arr1[i]);
				sortedArray[k] = arr1[i];
				i++;
			}
			else if(arr1[i] > arr2[j])
			{

				System.out.println(arr2[j]);
				sortedArray[k] = arr2[j];
				j++;
			}
			else if(arr1[i] == arr2[j])
			{

				System.out.println(arr1[i]);
				sortedArray[k] = arr1[i];
				i++;
			}
		}
		System.out.println(sortedArray);
	}
	
	public static void main(String args[])
	{
		
		mergeTwoArrayIntoOne();
	}
}
