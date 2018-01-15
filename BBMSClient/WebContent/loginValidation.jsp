<%@page import="Logger.BBMSLogger"%>
<%@page import="DBean.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<jsp:useBean id="dcon" scope="session" class="DBean.DBConnection" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<%
		Connection conn = dcon.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from Employee where email = ? and password = ? ");
		ps.setString(1, request.getParameter("email"));
		ps.setString(2, request.getParameter("epass"));
		BBMSLogger.LogDebug("Email :- " + request.getParameter("email") +"  ePass :- " + request.getParameter("epass"));
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			request.getSession(false);
			session.setAttribute("EmployeeEmail", request.getParameter("email"));
		%>
			<jsp:forward page="userProfile.jsp"/>
		<%
		}
		else
		{	
		%>
			<jsp:forward page="login.jsp">
				<jsp:param name="message" value="Invalid Credentials"/>
			</jsp:forward>
		<%
		}
	%>
</body>
</html>