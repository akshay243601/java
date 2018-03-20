package com.akshay.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestController {

	@Path("/")
	@GET
	public Response sayHello() {
		Response response = Response.status(200).entity("message").build();
		return response;
	}

	@Path("{name}")
	@PUT
	public Response testUpdate(@PathParam(value="name") String name) {
		Response response = Response.status(200).entity(name).build();
		return response;
	}
}
