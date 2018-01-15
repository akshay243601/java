<%@page import="java.io.File"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Models.Employee"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DBean.DBConnection"%>
<jsp:useBean id="dcon" scope="session" class="DBean.DBConnection" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Profile</title>

<style type="text/css">
	body
	{
/* 		padding-top:30px; */
		color: black;
	}
	.glyphicon 
	{  
		margin-bottom: 10px;
		margin-right: 10px;
	}
	small 
	{
		display: block;
		line-height: 1.428571429;
		color: #999;
	}
</style>


</head>
<body>
<%
	String message = request.getParameter("message");
	if(message != null && message.trim() != "")
	{
		 %>
			<h3> <%= message%></h3>		 
		 <%
	}

		System.out.println("Register_Action.jsp is going to save the employee details");
		Connection conn = dcon.getConnection();
		PreparedStatement ps = conn.prepareStatement("Select * from StudentDetails as SD JOIN ClassDetails as CD ON SD.Class_Code = CD.Class_Code where StudentId=?");
		ps.setString(1, request.getParameter("studentId"));
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			%>
			<div class="container">
				    <div class="row">
				        <div class="col-xs-70 col-sm-46 col-md-46">
				            <div class="well well-sm">
				                <div class="row">
				                    <div class="col-sm-6 col-md-4">
			
									<%
										String photoFileName = rs.getString("PhotoFileName");
										if(photoFileName != null && photoFileName != "")
										{
											photoFileName = application.getInitParameter("StudentImagePath") + photoFileName;
										}
										else
										{
											photoFileName = "Resource/images/noPhoto.png";
										}
											%>
											<img src="<%= photoFileName %>" class="img-rounded img-responsive" />
											<form action=<%= "upload?studentId="+request.getParameter("studentId") %> method="post" enctype="multipart/form-data">
											<h6 class="well well-sm"> Upload a different Image.... </h6>
												<input type="hidden" name="studentId" value="<%=request.getParameter("studentId")%>"/>
												<input type="file" name="studentPhotoFile" style="float:left;" class="well well-sm">
												<input type="submit" class="btn btn-primary" style="float:right;" value="save" />
											</form>    
				                    </div>
				                    <div class="col-sm-6 col-md-8">
				                        <h4>
				                            <%= rs.getString("FirstName") %> <%= " "+rs.getString("MiddleName") %> <%=" "+ rs.getString("LastName") %></h4>
				                        <small><cite title="<%= rs.getString("Address") %>"><%= rs.getString("Address") %> <i class="glyphicon glyphicon-map-marker">
				                        </i></cite></small>
				                        <p>
				                            <i class="glyphicon glyphicon-envelope">
				                            	<b>Email :- <%= rs.getString("Email") %></b>
				                            </i>
				                            <br />
				                            <i class="glyphicon glyphicon-globe">
					                            <b>Mobile :- <%= rs.getString("Mobile") %></b>
				                            </i>
				                            <br />
				                            <i class="glyphicon">
				                            	<b> Class :- <%= rs.getString("Class_Name") %></b>
				                            </i>
				                            <br />
											<i class="glyphicon">
				                            	<b>Roll Number:- <%= rs.getString("RollNumber") %></b>
				                            </i>
				                            <br />
				                            
				                        <!-- Split button -->
				                          <div class="btn-group">
									           <a class="btn btn-primary" href=<%="EditStudentDetails.jsp?studentId="+request.getParameter("studentId")%>>Edit Student Profile</a>
										</div>
				                    </div>
				                </div>
				            </div>
				        </div>
				    </div>
				</div>
			<%
		}
		else
		{
			out.println("Student is not found.");
			application.getRequestDispatcher("/StudentClass.jsp?Class_Code=0").include(request, response);
		}
%>

</body>
</html>