package com.rest.client;

import com.rs.entity.Person;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JAX_RS_CLIENT {

	public static String TOMCAT_PORT_NUMBER = "8024";

	public static void main(String args[]) {

		Client client = Client.create();
		Person p = new Person();
		p.setEmail("sds");
		System.out.println(" Email :- " + p.getEmail());

		// How to access Entity
		WebResource webResourceEntity = client.resource("http://localhost:" + TOMCAT_PORT_NUMBER
				+ "/JAVA-JAX_RS-SERVICE/rest/student/getPerson/NAME_AKSHAY/EMAIL_AKSHAY");
		ClientResponse responseEntity = (ClientResponse) webResourceEntity.get(ClientResponse.class);
		if (responseEntity.getStatus() == 200) {
			Person output = (Person) responseEntity.getEntity(Person.class);
			System.out.println("Name :-  " + output.getName() + " Email :- " + output.getEmail());
		}

		WebResource webResource = client.resource("http://localhost:" + TOMCAT_PORT_NUMBER
				+ "/JAVA-JAX_RS-SERVICE/rest/student/pathParamExample/afafs/hgsdf");
		ClientResponse response = (ClientResponse) webResource.get(ClientResponse.class);
		if (response.getStatus() == 200) {
			String output = (String) response.getEntity(String.class);
			System.out.println(output);
		}
	}
}
