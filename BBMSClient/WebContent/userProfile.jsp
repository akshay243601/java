<%@page import="Logger.BBMSLogger"%>
<%@page import="org.apache.log4j.pattern.LogEvent"%>
<%@page import="Models.Employee"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="dcon" scope="session" class="DBean.DBConnection" />
    <jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>

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
		BBMSLogger.LogDebug(message);
		 %>
			<h3> <%= message%></h3>		 
		 <%
	}
	String empEmail = (String)session.getAttribute("EmployeeEmail");
	Employee emp = new Employee();
	Connection conn = dcon.getConnection();
	PreparedStatement ps = conn.prepareStatement("Select * from employee where email=?");
	ps.setString(1, empEmail);
	ResultSet rs = ps.executeQuery();
	String imageFileName = "";
	if(rs.next())
	{
		emp.Address = rs.getString("Address");
		emp.Name = rs.getString("Name");
		emp.Email = rs.getString("Email");
		emp.MobileNumber = rs.getString("Mobile");
		emp.PhotoFileName = rs.getString("PhotoFileName");
		emp.Id = Integer.parseInt(rs.getString("ID"));
	}
	else
	{
		
	%>
		<jsp:forward page="login.jsp">
			<jsp:param name="message" value="Invalid Credentials"/>
		</jsp:forward>
	<%
		return;
	}
%>
<div class="container">
    <div class="row">
        <div class="col-xs-70 col-sm-46 col-md-46">
            <div class="well well-sm">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
									<%
										if(emp.PhotoFileName != null && emp.PhotoFileName != "")
										{
											imageFileName = application.getInitParameter("EmployeeImagePath") + emp.PhotoFileName;
										}
										else
										{
											imageFileName = "Resource/images/noPhoto.png";
										}
									%>
											<img src="<%= imageFileName %>" class="img-rounded img-responsive" />
											<form action="<%= "employeeImageUpload?employeeId="+emp.Id%>" method="post" enctype="multipart/form-data">
											<h6 class="well well-sm"> Upload a different Image.... </h6>
												<input type="hidden" name="employeeId" value="<%=emp.Id%>"/>
												<input type="file" name="employeePhotoFile" style="float:left;" class="well well-sm">
												<input type="submit" class="btn btn-primary" style="float:right;" value="save" />
											</form>    
				                    </div>
                    <div class="col-sm-2 col-md-8">
                        <h1>
                            <%= emp.Name %></h1>
                            
                        <h3><cite title="<%= emp.Address %>"><%= emp.Address %> <i class="glyphicon glyphicon-map-marker">
                        </i></cite></h3><br/>
                        <p>
                            <h4><i class="glyphicon glyphicon-envelope"></i><%= emp.Email %></h4> <br/>
                            <h4><i class="glyphicon glyphicon-globe"></i><%= emp.MobileNumber %></h4> <br/>
                        </p>
                        
                        <div class="btn-group">
                            <a href="updateEmployeeDetails.jsp" class="btn btn-primary">Edit Profile</a>
                            <a href="StudentRegister.jsp" class="btn btn-primary">Add New Student</a>
                            <a href="StudentClass.jsp?Class_Code=0" class="btn btn-primary">Student Details</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>