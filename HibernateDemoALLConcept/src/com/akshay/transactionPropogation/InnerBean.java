package com.akshay.transactionPropogation;

public interface InnerBean {

	public void test_Required(Employee employee);
	public void test_RequiresNew(Employee employee);
	public void test_NEVER(Employee employee);
	public void test_MANDATORY(Employee employee);
	public void test_SUPPORTED(Employee employee);
	public void test_NOT_SUPPORTED(Employee employee);
	public void test_NESTED(Employee employee);
	
}
