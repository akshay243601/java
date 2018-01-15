package com.rest.client;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import org.apache.tomcat.util.http.parser.MediaType;

import com.rs.entity.Person;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JAX_RS_CLIENT 
{
	
	public static void main(String args[])
	{
		
		Client client = Client.create();
		Person p = new Person();
		p.setEmail("sds");
		System.out.println(" Email :- " + p.getEmail() );

		//How to access Entity
		WebResource  webResourceEntity = client.resource("http://localhost:8888/JAVA-JAX_RS-SERVICE/rest/student/getPerson/NAME_AKSHAY/EMAIL_AKSHAY");
		ClientResponse responseEntity = webResourceEntity.get(ClientResponse.class);
		if(responseEntity.getStatus() == 200)
		{
			Person output =  responseEntity.getEntity(Person.class);
			System.out.println("Name :-  " + output.getName() + " Email :- " + output.getEmail() );
		}
		
		WebResource  webResource = client.resource("http://localhost:8888/JAVA-JAX_RS-SERVICE/rest/student/pathParamExample/afafs/hgsdf");
		ClientResponse response = webResource.get(ClientResponse.class);
		if(response.getStatus() == 200)
		{
			String output =  response.getEntity(String.class);
			System.out.println(output);
		}
	}
}
