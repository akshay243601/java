package com.akshay.FactoryPatternDesignPattern;

public class PlanFactory 
{
	public Plan getPlan(String planType)
	{
		Plan plan = null;
		
		if(planType == "monthly" )
		{	
			plan = new MonthlyPlan();
		}
		else if(planType == "daily" )
		{	
			plan = new DailyPlan();
		}
		else if(planType == "weekly" )
		{	
			plan = new WeeklyPlan();
		}
		return plan;
	}
}
