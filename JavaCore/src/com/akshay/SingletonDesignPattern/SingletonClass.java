package com.akshay.SingletonDesignPattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SingletonClass implements Cloneable
{
	private static SingletonClass singletonClass;
	
	private SingletonClass()
	{
		
	}
	
	/*public static synchronized SingletonClass getSingletonClass()
	{
		if(singletonClass == null)
		{
			singletonClass = new SingletonClass();
		}	
		return singletonClass;
	}*/
	
	public static SingletonClass getSingletonClass()
	{
		if(singletonClass == null)
		{
			synchronized (SingletonClass.class)  
			{
				if(singletonClass == null)
				{
					singletonClass = new SingletonClass();
				}
			}
		}	
		return singletonClass;
	}
	
	
	public void writeInfo(String str)
	{
		System.out.println(str);
	}
	
	public void writeError(String str)
	{
		System.out.println(str);
	}
	
	public void writeWarning(String str)
	{
		System.out.println(str);
	}
}
