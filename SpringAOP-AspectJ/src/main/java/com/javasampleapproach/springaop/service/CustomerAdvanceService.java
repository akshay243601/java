package com.javasampleapproach.springaop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javasampleapproach.springaop.model.Customer;

@Component
public class CustomerAdvanceService {

	private static Map<Long, Customer> store = new HashMap<Long, Customer>();
	static {
		store.put(1L, new Customer(1, "Jack", "Smith"));
		store.put(2L, new Customer(2, "Adam", "Johnson"));
	}

	public Customer getCustomerById(long id) {
		return store.get(id);
	}

	public Customer setCustomerFirstName(String firstName, long id) {
		Customer cust = store.get(id);
		cust.setFirstName(firstName);
		return cust;
	}

	public Customer setCustomerLastName(String lastName, long id) {
		Customer cust = store.get(id);
		cust.setLastName(lastName);
		return cust;
	}

	public List<Customer> findCustomerByLastName(String lastName) {
		List<Customer> listCust = new ArrayList<>();

		for (Long id : store.keySet()) {
			if (store.get(id).getLastName().equals(lastName)) {
				listCust.add(store.get(id));
			}
		}

		return listCust;
	}

	public List<Customer> findAllCustomers() {
		List<Customer> listCust = new ArrayList<>();

		for (Long id : store.keySet()) {
			listCust.add(store.get(id));
		}

		return listCust;
	}
}
