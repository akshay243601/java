package com.akshay.MultithreadingCriticalSection;

public class CustomSemaphore {

	public static int value;
	public CustomSemaphore(int noOfThread)
	{
		if(value < 0)
			value = 0;
		value = noOfThread;
	}
	
	public synchronized void down() 
	{
		try 
		{
			while (value == 0) 
			{
				wait();
			}
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		value--;
	}

	public synchronized void up() {
		value++;
		notify();
	}
}
