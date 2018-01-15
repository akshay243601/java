package com.restfulService;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;

@Path("/university")
public class UniversityService 
{
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String GetUniversityHTMLName()
	{
		return "<html><title>University</title><body>"+"GBTU"+"</body></html>";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String GetUniversityHTMLName1()
	{
		return "Name - GBTU";
	}
	
	@PUT
	@Path("{studentInfo}")
	public String GetUniversityHTMLName2(@PathParam("studentInfo") String stuInfo)
	{
		//Some logic for Studentinfo updation
		return stuInfo;
	}
}
