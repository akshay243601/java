package com.akshay.concurrencyStrategy;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConcurrencyStrategyDemo {
	static AbstractApplicationContext ctx = null;
	static EmployeeService employeeService = null;

	public static void setup() {
		ctx = new ClassPathXmlApplicationContext("applicationContext_CONCURRENCY_STRATEGY.xml");
		employeeService = (EmployeeService) ctx.getBean("employeeService");
	}

	/**
	 * INSERT : WE CAN INSERT NEW ENTRY UPDATE : WE CAN't ALLOW UPDATE [NOT
	 * ALLOWED] DELETE : WE CAN DELETE ENTRY
	 *******/
	// Please check CONCURRENCY_STRATEGY_Employee.java and Set @cache to
	// READ_ONLY if its not set
	public static void concurency_READONLY() {
		CONCURRENCY_STRATEGY_Employee employee = new CONCURRENCY_STRATEGY_Employee();
		employee.setName("ConcurrencyStretegy_READONLY");
		employee.setUsername("ConcurrencyStretegy_READONLY_USERNAME");

		employeeService.saveUser(employee);
		try {

			CONCURRENCY_STRATEGY_Employee emp = employeeService.getUser(employee.getId());
			CONCURRENCY_STRATEGY_Employee emp1 = employeeService.getUser(employee.getId());
			CONCURRENCY_STRATEGY_Employee emp2 = employeeService.getUser(employee.getId());

			emp.setName("UPDATE" + emp.getName());
			employeeService.updateUser(emp);
			System.out.println("UPDATE done");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * INSERT : WE CAN INSERT NEW ENTRY UPDATE : WE CAN UPDATE [CACHE ENTRIES
	 * ARE INVALIDATED INSTEAD OF UPDATE] DELETE : WE CAN DELETE ENTRY
	 *******/
	// Please check CONCURRENCY_STRATEGY_Employee.java and Set @cache to
	// NON_STRICT_READ_wRITE if its not set
	public static void concurency_NON_STRICT_READ_WRITE() {
		CONCURRENCY_STRATEGY_Employee employee = new CONCURRENCY_STRATEGY_Employee();
		employee.setName("ConcurrencyStretegy_READONLY");
		employee.setUsername("ConcurrencyStretegy_READONLY_USERNAME");
		
		employeeService.saveUser(employee);   //1st time insert  [value are not present incache]

		CONCURRENCY_STRATEGY_Employee emp = employeeService.getUser(employee.getId());  //Hit DB to get value and save it into cache
		CONCURRENCY_STRATEGY_Employee emp1 = employeeService.getUser(employee.getId());  //No query will be fired as value present in cache

		emp1.setName("UPDATE" + emp.getName());
		employeeService.updateUser(emp1);   //update query will be fired and mark cache to be invalidated

		CONCURRENCY_STRATEGY_Employee emp2 = employeeService.getUser(emp.getId());   //as cache was invalidated because of update query So it will hit the database and save it into cache
		CONCURRENCY_STRATEGY_Employee emp3 = employeeService.getUser(emp.getId());  //No query will be fired as value present in cache
		CONCURRENCY_STRATEGY_Employee emp4 = employeeService.getUser(emp.getId()); //No query will be fired as value present in cache
	}

	/**
	 * INSERT : WE CAN INSERT NEW ENTRY 
	 * UPDATE : WE CAN UPDATE [CACHE ENTRIES ARE Updated after transaction commit] 
	 * DELETE : WE CAN DELETE ENTRY
	 *******/
	// Please check CONCURRENCY_STRATEGY_Employee.java and Set @cache to
	// READ_wRITE if its not set
	public static void concurency_READ_WRITE() {
		CONCURRENCY_STRATEGY_Employee employee = new CONCURRENCY_STRATEGY_Employee();
		employee.setName("ConcurrencyStretegy_READONLY");
		employee.setUsername("ConcurrencyStretegy_READONLY_USERNAME");
		
		employeeService.saveUser(employee);   //1st time insert  [value are not present in cache]

		CONCURRENCY_STRATEGY_Employee emp = employeeService.getUser(employee.getId());  //Hit DB to get value and save it into cache
		CONCURRENCY_STRATEGY_Employee emp1 = employeeService.getUser(employee.getId());  //No query will be fired as value present in cache

		emp1.setName("UPDATE" + emp.getName());
		employeeService.updateUser(emp1);   //update query will be fired and cache will also updated

		CONCURRENCY_STRATEGY_Employee emp2 = employeeService.getUser(emp.getId());   //No query will be fired as value present in cache and it was updated
		CONCURRENCY_STRATEGY_Employee emp3 = employeeService.getUser(emp.getId());  //No query will be fired as value present in cache
		CONCURRENCY_STRATEGY_Employee emp4 = employeeService.getUser(emp.getId()); //No query will be fired as value present in cache
	}
	

	/**
	 * INSERT : WE CAN INSERT NEW ENTRY 
	 * UPDATE : WE CAN UPDATE [CACHE ENTRIES ARE Updated after transaction commit] 
	 * DELETE : WE CAN DELETE ENTRY
	 *	IT IS SYNCHRONOUS MECHANISM	*/
	// Please check CONCURRENCY_STRATEGY_Employee.java and Set @cache to
	// TRANSACTIONAL if its not set
	public static void concurency_TRANSACTION() {
		CONCURRENCY_STRATEGY_Employee employee = new CONCURRENCY_STRATEGY_Employee();
		employee.setName("ConcurrencyStretegy_READONLY");
		employee.setUsername("ConcurrencyStretegy_READONLY_USERNAME");
		
		employeeService.saveUser(employee);   //1st time insert  [value are not present in cache]

		CONCURRENCY_STRATEGY_Employee emp = employeeService.getUser(employee.getId());  //Hit DB to get value and save it into cache
		CONCURRENCY_STRATEGY_Employee emp1 = employeeService.getUser(employee.getId());  //No query will be fired as value present in cache

		emp1.setName("UPDATE" + emp.getName());
		employeeService.updateUser(emp1);   //update query will be fired and cache will also updated

		CONCURRENCY_STRATEGY_Employee emp2 = employeeService.getUser(emp.getId());   //No query will be fired as value present in cache and it was updated
		CONCURRENCY_STRATEGY_Employee emp3 = employeeService.getUser(emp.getId());  //No query will be fired as value present in cache
		CONCURRENCY_STRATEGY_Employee emp4 = employeeService.getUser(emp.getId()); //No query will be fired as value present in cache
	}

	public static void main(String[] args) {
		setup();
		// concurency_READONLY();
		//concurency_NON_STRICT_READ_WRITE();
		//concurency_READ_WRITE();
		concurency_TRANSACTION();
	}
}
