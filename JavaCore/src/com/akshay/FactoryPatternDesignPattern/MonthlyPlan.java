package com.akshay.FactoryPatternDesignPattern;

public class MonthlyPlan implements Plan
{

	@Override
	public int getRate() {
		System.out.println("Montly Plan is called");
		return 300;
	}


}
