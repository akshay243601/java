package com.akshay.CollebraProgramms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.Set;

public class FindDuplicate 
{
	private static void findDuplicateUsingSet(String[] strArr) {
		
		Set<String> set = new LinkedHashSet<String>();
		ArrayList<String> dupElement = new ArrayList<String>();
		for (String string : strArr) {
			if(set.add(string) == false)
			{
				dupElement.add(string);
			}
		}
		
		System.out.println(Arrays.asList(strArr));
		System.out.println(set);
		System.out.println(dupElement);
		
		
	}

	private static void findDuplicateUsingHashMap(String[] strArr) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (String string : strArr) 
		{
			if(map.containsKey(string))
			{
				map.put(string, map.get(string) + 1);
			}
			else
			{
				map.put(string, 1);
			}
		}
		
		Set<Entry<String,Integer>> entry = map.entrySet();
		for (Entry<String, Integer> entry2 : entry) 
		{
			System.out.println(entry2.getKey() + " " + entry2.getValue());
		}
		
		Set<String> keySet = map.keySet();
		System.out.println(keySet);
		
		Iterator<Integer> values =   map.values().iterator();
		System.out.println(values);
		System.out.println();
	}

	private static void findDuplicateUsingForLoop(String[] strArr) 
	{
		for(int i = 0; i < strArr.length ; i++)
		{
			for(int j = i+1; j < strArr.length ; j++)
			{
				if(strArr[i].equals(strArr[j]))
				{
					System.out.println(strArr[j]);
				}
			}	
		}	
	}
	
	public static void main(String args[])
	{
		String str = "Hi i am the best boy understand best boy best he am i is the am";
		String[] strArr = str.split(" ");
		findDuplicateUsingForLoop(strArr);
		findDuplicateUsingHashMap(strArr);
		findDuplicateUsingSet(strArr);
	}
}
