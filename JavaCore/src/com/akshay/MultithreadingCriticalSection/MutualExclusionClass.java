package com.akshay.MultithreadingCriticalSection;

public class MutualExclusionClass extends Thread
{	
	CustomSemaphore customSemaphore;
	public MutualExclusionClass(CustomSemaphore customSemaphore, String Threadname)
	{
		this.customSemaphore = customSemaphore;
		this.setName(Threadname);
	}
	
	public void run()
	{
		while(true)
		{
			customSemaphore.down();
			System.out.println(Thread.currentThread().getName()  +  " Is down");
			
			try
			{
				Thread.sleep((int)(Math.random()*100));
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			System.out.println(Thread.currentThread().getName()  +  " Is Up");
			customSemaphore.up();
		}
	}
}
