package com.javasampleapproach.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CustomerAspect {
	
	@Before("execution(* com.javasampleapproach.springaop.service.CustomerService.getCustomerById(..))")
	public void getCustomerByIdAdvice() {
		System.out.println("Execute advice on getCustomerByIdAdvice()");
	}

	@Before("execution(* com.javasampleapproach.springaop.service.CustomerService.set*(..))")
	public void getAllSetAdvices(JoinPoint joinPoint) {
		System.out.println("Excute advice on Service set Method: " + joinPoint.getSignature().getName());
	}
}
