package com.akshay.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
public class EmployeeAspect {
	
	@Before("execution(* com.akshay.entity.Employee.*(..))")
	public void beforeAdvice(JoinPoint joinPoint){
		System.out.println("EmployeeAspect Before Advice is called");
		System.out.println(joinPoint.getSignature().getName() + " with args " + Arrays.asList(joinPoint.getArgs()));
	}
	
	@After("execution(* com.akshay.entity.Employee.*(..))")
	public void afterAdvice(JoinPoint joinPoint){
		System.out.println("EmployeeAspect After Advice is called");
		System.out.println(joinPoint.getSignature().getName() + " with args " + Arrays.asList(joinPoint.getArgs()));
	}
	
}
