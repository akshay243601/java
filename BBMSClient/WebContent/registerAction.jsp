<%@page import="Logger.BBMSLogger"%>
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
		System.out.println("Register_Action.jsp is going to save the employee details");
		Connection conn = dcon.getConnection();
		Employee emp = new Employee();
		PreparedStatement ps = conn.prepareStatement("Select * from employee where email=?");
		ps.setString(1, request.getParameter("email"));
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			out.print("Employee with the same name already exist. Please select a different email id");
			BBMSLogger.LogInfo("Employee with the same name already exist. Please select a different email id");
		%>
			<jsp:include page="register.jsp"/>
		<%
		}
		else
		{
			PreparedStatement ps_register = conn.prepareStatement("insert into employee(name, email, password, address, Mobile) values(?,?,?,?,?)");
			ps_register.setString(1,request.getParameter("ename"));
			ps_register.setString(2,request.getParameter("email"));
			ps_register.setString(3,request.getParameter("epass"));
			ps_register.setString(4,request.getParameter("eaddress"));
			ps_register.setString(5,request.getParameter("emobile"));
			int i = ps_register.executeUpdate();
			if(i > 0)
			{
				application.getRequestDispatcher("/userProfile.jsp").forward(request, response);
			}
			else
			{
				out.print("Some problem occurs");
				%>
					<jsp:include page="register.jsp"/>
				<%
			}
		}
	%>
</body>
</html>