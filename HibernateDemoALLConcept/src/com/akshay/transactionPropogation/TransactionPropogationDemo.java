package com.akshay.transactionPropogation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionPropogationDemo {

	public static void test_Propogation_REQUIRED() {

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_TRANSACTION_PROPOGATION.xml");
		OuterBean testBean = (OuterBean) ctx.getBean(OuterBean.class);

		Employee user = new Employee();
		user.setUsername("johndoe");
		user.setName("John Doe");
		testBean.test_Required(user);

	}

	public static void test_Propogation_REQUIRED_NEW() {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_TRANSACTION_PROPOGATION.xml");
		OuterBean testBean = (OuterBean) ctx.getBean(OuterBean.class);

		Employee user = new Employee();
		user.setUsername("johndoe");
		user.setName("John Doe");

		testBean.test_RequiresNew(user);
	}

	public static void test_Propogation_NESTED() {
		// TODO
	}

	public static void test_Propogation_NEVER() {
		
//		ctx = new ClassPathXmlApplicationContext("applicationContext_CONCURRENCY_STRATEGY.xml");

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_TRANSACTION_PROPOGATION.xml");
		OuterBean testBean = (OuterBean) ctx.getBean(OuterBean.class);

		Employee employee = new Employee();
		employee.setUsername("johndoe");
		employee.setName("John Doe");
		testBean.test_NEVER(employee);

	}

	public static void test_Propogation_SUPPORTED() {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_TRANSACTION_PROPOGATION.xml");
		OuterBean testBean = (OuterBean) ctx.getBean(OuterBean.class);

		Employee user = new Employee();
		user.setUsername("johndoe");
		user.setName("John Doe");
		testBean.test_SUPPORTED(user);

	}

	public static void test_Propogation_NOT_SUPPORTED() {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_TRANSACTION_PROPOGATION.xml");
		OuterBean testBean = (OuterBean) ctx.getBean(OuterBean.class);

		Employee user = new Employee();
		user.setUsername("johndoe");
		user.setName("John Doe");

		testBean.test_NOT_SUPPORTED(user);

	}

	public static void test_Propogation_MANDATORY() {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_TRANSACTION_PROPOGATION.xml");
		OuterBean testBean = (OuterBean) ctx.getBean(OuterBean.class);

		Employee user = new Employee();
		user.setUsername("johndoe");
		user.setName("John Doe");

		testBean.test_MANDATORY(user);

	}

	public static void main(String[] args) {

	//	test_Propogation_REQUIRED();

	//	 test_Propogation_REQUIRED_NEW();

		 test_Propogation_NEVER();

//		 test_Propogation_SUPPORTED();

//			test_Propogation_NOT_SUPPORTED();

//		 test_Propogation_MANDATORY();

		// test_Propogation_NESTED();

	}
}
