<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
    <jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Update Employee Information</title>
		<script src="Resource/jQuery/jquery-1.12.2.js"></script>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="style.css">
		<jsp:useBean id="dcon" scope="session" class="DBean.DBConnection" />
		<script type="text/javascript">
		function isValid()
		{
			var pass = $("#pass").val();
			var cpass = $("#cpass").val();
			if(pass==cpass)
			{
				return true;
			}
			else
			{
				$("#errorMsg").html("password or confirm password is not matched");
				return false;
			}
		}
		
		</script>
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
%>
	
	<%!
		String name="";
		String email="";
		String password="";
		String address="";
		String mobile="";
	%>
	<%
	
		String empEmail = (String)session.getAttribute("EmployeeEmail");
		Connection conn = dcon.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from Employee where Email = ?");
		ps.setString(1, empEmail);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			name=rs.getString("name");
			email=rs.getString("email");
			address=rs.getString("address") ;
			mobile=rs.getString("mobile");
			password=rs.getString("password");
		}
		else
		{	
			%>
				<jsp:forward page="userProfile.jsp">
					<jsp:param value="Employee not Found" name="message"/>
				</jsp:forward>
				
			<%
		}
		%>
	<span id="errorMsg"></span>
	<center>
		<table class = "main">
				<tr>
					<td></td><td><hr color="#99CC00"><h1><font size="8"><center>Update Employee Information:</center></font></h1><hr color="#99CC00"></td>
				</tr>
				<form role="form" action = "updateEmployeeDetailsAction.jsp" method = "post"  onsubmit="return isValid()">
					<input type="hidden" name="email" placeholder="Enter Email" value=<%= email %>  required = "true"> 
					<tr>
						<td> <label for="Name"> Name<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="ename" placeholder="Enter Name" value=<%= name %> required = "true"></td>
					</tr>
					<tr>
						<td> <label for="email">Email<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" disabled="disabled" class="form-control" name="eemail" placeholder="Enter Email" value=<%= email %>  required="true"> </td>
					</tr>
					<tr>
						<td> <label for="pass">Password<sup><b>*</b></sup> </label> </td>
						<td> <input type="password" class="form-control" id="pass" value=<%= password %> name="epass" placeholder="Enter Password" required = "true"> </td>
					</tr>
					<tr>
						<td> <label for="cpass">Confirm Password<sup><b>*</b></sup> </label> </td>
						<td> <input type="password" class="form-control" name="cpass" value=<%= password %> id="cpass" placeholder="Enter Password Again" required = "true"> </td>
					</tr>	
					<tr>
						<td> <label for="eaddress">Address<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="eaddress" placeholder="Enter Address" value=<%= address %> required = "true"> </td>
					</tr>	
					<tr>
						<td> <label for="emobile">Mobile<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="emobile" placeholder="Enter Mobile Number" value=<%= mobile %> required = "true"> </td>
					</tr>	
					<tr>
						<td><input type="submit" class="btn btn-primary" value = "Submit"></td>
						<td><a href="userProfile.jsp" class="btn btn-primary">Back</a></td>
	 				</tr>
		</form>
		</table>
		</center>
	</body>
</html>
	