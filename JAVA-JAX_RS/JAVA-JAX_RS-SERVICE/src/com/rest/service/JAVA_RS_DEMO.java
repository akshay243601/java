package com.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlMimeType;

import com.rs.entity.Person;


@Path("/student")
public class JAVA_RS_DEMO {
	
	@GET
	@Path("/pathParamExample/{classInfo}/{studentInfo}")
	public String GetStudentInfoUsingPathParam(@PathParam("classInfo") String classNumber, @PathParam("studentInfo") String stuInfo)
	{
		return "Path Param Example : ---- >>>>       Student Id :- " + stuInfo + "With class no. :- " + classNumber;
	}
	
	
	//http://stackoverflow.com/questions/8594707/jersey-exception-severe-a-message-body-reader-for-java-class/17777247#17777247
	@GET
	@Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
	@Path("/getPerson/{Name}/{Email}")
	public Person GetStuddentDetaills(@PathParam("Name") String Name, @PathParam("Email") String Email)
	{
		System.out.println("Name :-  " + Name+ " Email :- " + Email );

		Person person = new Person();
		person.setEmail(Email);
		person.setName(Name);
		return person;
	}
	
	
/*	@GET
	@Path("/queryParamExample")
	public String GetStudentInfoUsingQueryParam(@QueryParam("classId") String classNumber, @QueryParam("studentId") String stuInfo)
	{
		return "Query Param Example :----  >>>>>   Student Id :- " + stuInfo + "With class no. :- " + classNumber;
	}
	
	@GET
	@Path("/matrixParamExample")
	public String GetStudentInfoUsingMatrixParam(@MatrixParam("classId") String classNumber, @MatrixParam("studentId") String stuInfo)
	{
		return "Matrix Param Example :----  >>>>>   Student Id :- " + stuInfo + "With class no. :- " + classNumber;
	}
	
	
	//Form param will be used when you are deal with the Forms.
	@POST
	@Path("/formParamExample")
	public String GetStudentInfoUsingFormParam(@FormParam("classId") String classNumber, @FormParam("studentId") String stuInfo)
	{
		return "Form Param Example :----  >>>>>   Student Id :- " + stuInfo + "With class no. :- " + classNumber;
	}
*/	
}
