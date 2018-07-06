package com.akshay.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestController {

	@Path("/get")
	@GET
	public Response sayHello() {
		Response response = Response.status(200).entity("message").build();
		return response;
	}

	@Path("/save/{name}")
	@PUT
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response testUpdate(@PathParam(value = "name") String name) {
		System.out.println("testUpdate is calledaaaaaaaaa");
		Response response = Response.status(200).entity(name).build();
		return response;
	}

	@Path("/save/{name}")
	@PUT
	@Consumes(value = MediaType.APPLICATION_XML)
	public Response testUpdate1(@PathParam(value = "name") String name) {
		System.out.println("testUpdate1 is calledaaaaaaaaaaaaaaa");
		Response response = Response.status(200).entity(name).build();
		return response;
	}

}
