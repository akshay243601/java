package com.akshay.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.akshay.rest.entity.Address;
import com.akshay.rest.entity.Employee;
import com.akshay.rest.entity.Response;
import com.akshay.rest.service.EmployeeService;

@Path("/employee")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class EmployeeController {

	public EmployeeController(){
		
	}
	
	private EmployeeService employeeService;

	@Path("/")
	@GET
	public Employee getEmployee(@QueryParam(value = "empId") int empId) {
		return getEmployeeService().getEmployee(empId);
	}

	@Path("/")
	@PUT
	public Response saveEmployeeWithParamValue(Employee emp) {
		Response response = new Response();
		response.setSuccess(false);
		try {
			Address address = new Address();
			address.setAddressId(4);
			address.setCountry("India");
			address.setStreet("Noida Sector 62");
			address.setEmployee(emp);
			emp.setAddress(address);
			response.setSuccess(getEmployeeService().saveEmployee(emp));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return response;
	}

	private EmployeeService getEmployeeService() {
		if (employeeService == null) {
			synchronized (EmployeeService.class) {
				if (employeeService == null) {
					employeeService = new EmployeeService();
				}
			}
		}
		return employeeService;
	}

}
