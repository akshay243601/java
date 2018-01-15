<%@page import="Models.Employee"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DBean.DBConnection"%>
<jsp:useBean id="dcon" scope="session" class="DBean.DBConnection" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Action</title>
</head>
<body>
	<%
		System.out.println("UpdateEmployeeDetailsAction.jsp is going to update the employee details");
		Connection conn = dcon.getConnection();
		Employee emp = new Employee();
		
		PreparedStatement ps = conn.prepareStatement("Select * from employee where email=?");
		ps.setString(1, request.getParameter("email"));
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			PreparedStatement ps_register = conn.prepareStatement("Update employee SET name=?, password=?, address=?, Mobile=? where Email=?");
			ps_register.setString(1,request.getParameter("ename"));
			ps_register.setString(2,request.getParameter("epass"));
			ps_register.setString(3,request.getParameter("eaddress"));
			ps_register.setString(4,request.getParameter("emobile"));
			ps_register.setString(5,request.getParameter("email"));
			int i = ps_register.executeUpdate();
			if(i > 0)
			{
				request.setAttribute("message", "Employee Details are update successfully");
				application.getRequestDispatcher("/userProfile.jsp").forward(request, response);
			}
			else
			{
			
				%>
					<jsp:forward page="updateEmployeeDetails.jsp">
						<jsp:param value="Some problem occured. Please try again" name="message"/>
					</jsp:forward>
				<%
			}
		}
		else
		{
		out.print("Employee not exist");
		%>
			<jsp:include page="register.jsp"/>
		<%
		}
		%>
</body>
</html>