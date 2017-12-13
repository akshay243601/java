package com.akshay.FactoryPatternDesignPattern;

public class DailyPlan implements Plan
{

	@Override
	public int getRate() {
		System.out.println("Daily Plan is called");
		return 10;
	}


}
