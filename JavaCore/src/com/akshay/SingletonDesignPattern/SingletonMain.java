package com.akshay.SingletonDesignPattern;

public class SingletonMain 
{
	public static void main(String args[])
	{
		SingletonClass Logger  = SingletonClass.getSingletonClass();
		SingletonClass Logger1  = SingletonClass.getSingletonClass();
		SingletonClass Logger2  = SingletonClass.getSingletonClass();
		SingletonClass Logger3  = SingletonClass.getSingletonClass();
		
		Logger.writeInfo("This is called for information");
		Logger.writeError("This is called for Error");
		Logger.writeWarning("This is called for Warining");
		
		
		System.out.println(Logger);
		System.out.println(Logger1);
		System.out.println(Logger2);
		System.out.println(Logger3);
	}
}
