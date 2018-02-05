package com.javasampleapproach.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CustomerAspectAnnotation {
	@Before("@annotation(Loggable)")
	public void myAnnotationAdvice(){
		System.out.println("Execute Advice before Annotation @Loggable");
	}
}
