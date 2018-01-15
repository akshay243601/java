<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<jsp:useBean id="dcon" scope="session" class="DBean.DBConnection" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Registration</title>
		<script type="text/javascript">
		</script>
	</head>
	<body>
		<span id="errorMsg"></span>
			<center>
		<table class = "main">
				<tr>
					<td></td><td><hr color="#99CC00"><h1><font><center>Student Registration Form</center></font></h1><hr color="#99CC00"></td>
				</tr>
				<form role="form" action = "studentRegisterAction.jsp" method = "post">
					<tr>
						<td> <label for="rollNo"> Roll Number<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="sRollNumber" placeholder="Enter Roll Number" required = "true"> </td>
					</tr>
					<tr>
						<td> <label for="sFN">First Name<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="sFN" placeholder="Enter First Name" required = "true"> </td>
					</tr>
					<tr>
						<td> <label for="sMN">Middle Name<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="sMN" placeholder="Enter Middle Name" required = "true"> </td>
					</tr>
					<tr>
						<td> <label for="sLN">Last Name<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="sLN" placeholder="Enter Last Name" required = "true"> </td>
					</tr>
					<tr>
						<td> <label for="sEmail">Email<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="sEmail" placeholder="Enter Email" required = "true"> </td>
					</tr>					
 				<%
				 	Connection con;
				 	con=dcon.getConnection();
				 	Statement st=con.createStatement();
				 	ResultSet rs=st.executeQuery("select Class_Code, Class_Name from ClassDetails order by Class_Code");
	 			%>
	 			<tr>
					<td> <label for="sClass">Select Class<sup><b>*</b></sup> </label> </td>
					<td>
						<select name='classCode' style='width:150;text-shadow: black;background-color: black;' > 
								<%
					 				while(rs.next())
									{ 
					 		 	%>
					 		 		<option value=<%=rs.getInt(1)%>> 
					 		 	<%= rs.getString(2).toUpperCase()%>
					 		 		</option>
					 		 	<%} %>
	 					</select>
	 				</td>
				</tr>
	 			<tr>
						<td> <label for="sAddress">Address<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="sAddress" placeholder="Enter Address" required = "true"> </td>
					</tr>	
					<tr>
						<td> <label for="sMobile">Mobile Number<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="sMobile" placeholder="Enter Mobile" required = "true"> </td>
					</tr>	
					<tr>
						<td><input type="submit" class="btn btn-primary" value = "Register"></td>
						<td><input type="Reset" class="btn btn-primary" value = "Reset"></td>
					</tr>
					<tr>
						<td><a href="userProfile.jsp" class="btn btn-primary">Back to User Profile</a></td>
						<td></td>
					</tr>
		</form>
		</table>
		</center>
	</body>
</html>
