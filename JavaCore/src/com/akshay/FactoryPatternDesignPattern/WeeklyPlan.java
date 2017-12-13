package com.akshay.FactoryPatternDesignPattern;

public class WeeklyPlan implements Plan
{

	@Override
	public int getRate() {
		System.out.println("Weekly Plan is called");
		return 70;
	}

}
