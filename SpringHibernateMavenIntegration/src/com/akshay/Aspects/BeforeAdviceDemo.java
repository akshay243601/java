package com.akshay.Aspects;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdviceDemo implements MethodBeforeAdvice
{
	@Override
	public void before(Method method, Object[] objects, Object obj) throws Throwable 
	{
		System.out.println(method.getName());
	}
}
