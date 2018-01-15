<%@page import="java.sql.PreparedStatement"%>
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
		<title>Edit Student Details</title>
		<script src="Resource/jQuery/jquery-1.12.2.js"></script>
		<script type="text/javascript">
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
		int studentId;
		String FN="";
		String LN="";
		String MN="";
		int ClassCode=0;
		String Address="";
		String Mobile="";
		String Email="";
		String RollNumber="";
	%>
	<%
		Connection conn = dcon.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from StudentDetails where studentId = ?");
		ps.setString(1, request.getParameter("studentId"));
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			studentId = Integer.parseInt(rs.getString(1));
			RollNumber= rs.getString(2);
			FN=rs.getString(3) ;
			LN=rs.getString(4) ;
			MN=rs.getString(5) ;
			Email=rs.getString(6);
			Address=rs.getString(7) ;
			Mobile=rs.getString(8);
			ClassCode= Integer.parseInt(rs.getString(9));
		}
		else
		{	
			out.print("Student not found");
			%>
				<jsp:include page="userProfile.jsp"/>
			<%
		}
		%>
	
		<span id="errorMsg"></span>
		<center>
		<table class = "main">
				<tr>
					<td></td><td><hr color="#99CC00"><h1><font size="8"><center>Student Registration Form:</center></font></h1><hr color="#99CC00"></td>
				</tr>
				<form role="form" action = "updateStudentDetailAction.jsp" method = "post">
					<input type="hidden" id="studentId" name="studentId" value= <%= studentId%>>
					<tr>
						<td> <label for="rollNo"> Roll Number<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="sRollNumber" value=<%= RollNumber%> placeholder="Enter Roll Number" required = "true"> </td>
					</tr>
				<tr>
						<td> <label for="sFN">First Name<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="sFN" value=<%= FN%> placeholder="Enter First Name" required = "true"> </td>
					</tr>
					<tr>
						<td> <label for="sMN">Middle Name<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="sMN" value=<%= MN%> placeholder="Enter Middle Name" required = "true"> </td>
					</tr>
					<tr>
						<td> <label for="sLN">Last Name<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="sLN" value=<%= LN%> placeholder="Enter Last Name" required = "true"> </td>
					</tr>
					<tr>
						<td> <label for="sEmail">Email<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="sEmail" value=<%= Email%> placeholder="Enter Email" required = "true"> </td>
					</tr>
 				<%
				 	Statement st=conn.createStatement();
				 	ResultSet rs1=st.executeQuery("select Class_Code, Class_Name from ClassDetails order by Class_Code");
	 			%>
	 				<tr>
						<td><label for="classCode">Select Class<sup><b>*</b></sup> </label> </td>
						<td>
							<select name='classCode' style='width:150;text-shadow: black;background-color: black;' > 
								<%
					 				while(rs1.next())
									{ 
							 		 	%>
							 		 	<option value=<%=rs1.getInt(1)%> <%= rs1.getInt(1)==ClassCode  ?  " selected='selected'" :""%>>
							 		 	<%= rs1.getString(2).toUpperCase()%>
							 		 		</option>
							 			<%
							 		} %>
			 				</select>
			 			</td>
					</tr>
	 				<tr>
						<td> <label for="sAddress">Address<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="sAddress" value=<%= Address%> placeholder="Enter Address" required = "true"> </td>
					</tr>	
					<tr>
						<td> <label for="sMobile">Mobile Number<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="sMobile" value=<%= Mobile%> placeholder="Enter Mobile" required = "true"> </td>
					</tr>	
					<tr>
						
						<td><input type="submit" class="btn btn-primary" value = "Update"></td>
						<td><a class="btn btn-primary"  href="userProfile.jsp">Cancel</a> </td>
					</tr>
		</form>
	</body>
</html>
