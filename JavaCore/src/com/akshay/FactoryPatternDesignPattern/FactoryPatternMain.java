package com.akshay.FactoryPatternDesignPattern;

public class FactoryPatternMain 
{
	public static void main(String args[])
	{
		PlanFactory planFactory = new PlanFactory();
		
		Plan plan = planFactory.getPlan("monthly");
		plan.getRate();
		
		plan = planFactory.getPlan("weekly");
		plan.getRate();
		
		plan = planFactory.getPlan("daily");
		plan.getRate();
		
	}
}
