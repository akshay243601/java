<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>LOGIN</title>
</head>
<body>
	<center><font size="6"><center>Login Here</center></font>
		<h3 style="color: red;">
				<%
					String message = request.getParameter("message");
					if(message != null && message.trim() != "")
					{
						 %>
							<%= message%>		 
						 <%
					}
				%>
		</h3>
		<table class = "main">
			<form role="form" action = "loginValidation.jsp" method = "post">
				<tr>
					<td> <label for="email">Email id<sup><b>*</b></sup> </label> </td>
					<td> <input type="text" class="form-control" name="email" placeholder="Enter email id" required = "true"> </td>
				</tr>	
				<tr>
					<td> <label for="InputPassword">Password<sup><b>*</b></sup> </label> </td>
					<td> <input type="password" id = "epass" class="form-control" name="epass" placeholder="Enter password" required = "true" > </td>
				</tr>
				<tr>
					<td></td><td><input type="submit" class="btn btn-primary" value = "Submit"></td>
				</tr>
			</form>
			<fieldset>
				<tr>
					<td> <label>New User Can Register Here :-<sup><b></b></sup> </label> </td>
					<td> <a class="btn btn-primary" href="register.jsp">Register Here</a></td>
				</tr>
			</fieldset>
		</table>
	</center>
</body>
</html>
