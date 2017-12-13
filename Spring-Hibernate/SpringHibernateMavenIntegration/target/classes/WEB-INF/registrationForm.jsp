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

	<form method="post" action="register">
		<table>
			<tr>
				<td><label>Name</label></td>
				<td><input type="text" name="studentName" /></td>
			</tr>
			<tr>
				<td><label>Email</label></td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td><label> Student Age </label></td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td><label> Password </label></td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><label>Company</label></td>
				<td><input type="text" name="company" /></td>
			</tr>
			<tr>
				<td><label>Address</label></td>
				<td><input type="text" name="address.addressName" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>