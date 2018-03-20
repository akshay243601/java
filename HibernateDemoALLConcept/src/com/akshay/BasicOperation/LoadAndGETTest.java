package com.akshay.BasicOperation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.akshay.transactionPropogation.OuterBean;

public class LoadAndGETTest {

	public static void test_LOAD(int id) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_TRANSACTION_PROPOGATION.xml");
		OuterBean testBean = (OuterBean) ctx.getBean("outerBean");
		try {
			System.out.println(testBean.loadUser(id));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void test_GET(int id) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_TRANSACTION_PROPOGATION.xml");
		OuterBean testBean = (OuterBean) ctx.getBean("outerBean");
		try {
			System.out.println(testBean.getUser(id));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String args[]) {
		int EMPLOYEE_ANY_ID = 36;
		test_LOAD(EMPLOYEE_ANY_ID);
		test_GET(EMPLOYEE_ANY_ID);
	}
}
