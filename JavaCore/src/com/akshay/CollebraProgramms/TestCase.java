package com.akshay.CollebraProgramms;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.JUnit4;

import com.google.common.annotations.VisibleForTesting;

import junit.framework.Assert;


@VisibleForTesting
public class TestCase 
{

	@Before
	public void Setup()
	{
		System.out.println("Before test case start called.......");
	}
	
	@Test
	public void SampleTest1()
	{
		System.out.println("Test 1 is running...");
		Integer integer = new Integer(10);
		int i =10;

		if(i==integer)
		{
			System.out.println("Equals...");
		}
//		org.junit.Assert.assertEquals("Equals", new Integer(i), integer);
		org.junit.Assert.assertEquals("Equals", new Integer(i), integer);
		
	}
	
	@Test
	public void SampleTest2()
	{
		System.out.println("Test 2 is running...");
	}
	
	public static void main(String args[])
	{
		Result results = JUnitCore.runClasses(TestCase.class);
		List<Failure> failures =  results.getFailures();
		for (Failure failure : failures) {
			System.out.println(failure.getMessage());
		}

		System.out.println(results.wasSuccessful());
		
	}
	
	@After
	public void end()
	{
		System.out.println("After test case end called.......");
	}

}
