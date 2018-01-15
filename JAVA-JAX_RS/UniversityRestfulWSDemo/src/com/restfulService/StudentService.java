package com.restfulService;

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

@Path("/student")
public class StudentService 
{
	@GET
	@Path("/pathParamExample/{classInfo}/{studentInfo}")
	public String GetStudentInfoUsingPathParam(@PathParam("classInfo") String classNumber, @PathParam("studentInfo") String stuInfo)
	{
		return "Path Param Example : ---- >>>>       Student Id :- " + stuInfo + "With class no. :- " + classNumber;
	}
	
	@GET
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
	
	
}
