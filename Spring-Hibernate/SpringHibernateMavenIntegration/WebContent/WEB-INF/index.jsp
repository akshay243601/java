<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<H3>${CompanuName }</H3>
	<H3>${errorMessage}</H3>
	Student Name :- ${ StudentName}
	<form action="/SpringHibernateMavenIntegration/validateLogin"
		method="get">
		<table>
			<tr>
				<td><label>User Name :-</label></td>
				<td><input type="text" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><label>Password :</label></td>
				<td><input type="text" name="password" id="epass" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="login" /></td>
				<td><a
					href="/SpringHibernateMavenIntegration/studentRegisterForm">New
						User Register Here</a></td>
			</tr>
		</table>
	</form>
</body>
</html>