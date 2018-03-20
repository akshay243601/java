package com.akshay.rest.controller;

import java.io.StringWriter;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.akshay.rest.entity.Address;
import com.akshay.rest.entity.Employee;
import com.akshay.rest.entity.Response;
import com.akshay.rest.service.EmployeeService;

@Path("/employee")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class EmployeeController {

	public EmployeeService employeeService;

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
			Address address  = new Address();
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

	/*
	 * @Path("/")
	 * 
	 * @PUT
	 * 
	 * @Consumes(MediaType.APPLICATION_XML) public Response
	 * saveEmployeeWithParamValue(@QueryParam(value = "empName") String empName,
	 * String xmlData) { boolean isSuccess =
	 * getEmployeeService().saveEmployee(xmlToObject(xmlData, Employee.class));
	 * return
	 * Response.status(Status.OK).entity(convertToXML(isSuccess)).build(); }
	 */

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

	/*
	 * private <T> String convertToXML(T object) { String result = ""; try {
	 * JAXBContext context = JAXBContext.newInstance(object.getClass());
	 * Marshaller marshallerObj = context.createMarshaller();
	 * marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 * StringWriter out = new StringWriter(); marshallerObj.marshal(object,
	 * out); out.flush(); return out.toString(); } catch (JAXBException e) {
	 * e.printStackTrace(); } return result; }
	 * 
	 * private <T> T xmlToObject(String data, Class className) {
	 * 
	 * try { JAXBContext context = JAXBContext.newInstance(className);
	 * Unmarshaller unmarshallerObj = context.createUnmarshaller(); T result =
	 * (T) unmarshallerObj.unmarshal(new StreamSource(data)); return result; }
	 * catch (Exception e) { System.out.println(e); } return null; }
	 */

}
