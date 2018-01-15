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
		System.out.println("StudentRegisterAction.jsp is going to save the employee details");
		Connection conn = dcon.getConnection();
		PreparedStatement ps = conn.prepareStatement("Select * from studentdetails where RollNumber=? and Class_Code=?");
		ps.setString(1, request.getParameter("sRollNumber"));
		ps.setInt(2, Integer.parseInt(request.getParameter("classCode")));
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			out.print("Same roll number in same class already exist. Please select a different roll number/Class");
		%>
			<jsp:include page="StudentRegister.jsp"/>
		<%
		}
		else
		{
			PreparedStatement ps_register = conn.prepareStatement("INSERT INTO  studentdetails(RollNumber,  FirstName,  LastName,  MiddleName, Email, Class_Code, Address, Mobile) VALUES(?,?,?,?,?,?,?,?)");
			ps_register.setString(1,request.getParameter("sRollNumber"));
			ps_register.setString(2,request.getParameter("sFN"));
			ps_register.setString(3,request.getParameter("sLN"));
			ps_register.setString(4,request.getParameter("sMN"));
			ps_register.setString(5,request.getParameter("sEmail"));
			ps_register.setInt(6,Integer.parseInt(request.getParameter("classCode")));
			ps_register.setString(7,request.getParameter("sAddress"));
			ps_register.setString(8,request.getParameter("sMobile"));
			int i = ps_register.executeUpdate();
			if(i > 0)
			{
				%>
					<jsp:forward page="userProfile.jsp" >
						<jsp:param name="message" value="registered"/>
					</jsp:forward>
				<%
			}
			else
			{
				out.print("Some problem occurs");
				%>
					<jsp:include page="StudentRegister.jsp"/>
				<%
			}
		}
	%>
</body>
</html>
