<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<body>
	
<form method="post" action="LoginValidate">
	<table>
		<tr>
			<td>
				<label> Name :- </label>
			</td>
			<td>
				<input type="text" name="name"/>
			</td>
		</tr>
		<tr>
			<td>
				<label> Password :- </label>
			</td>
			<td>
				<input type="password" name="pass"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="submit"/>
			</td>
			<td>
				<input type="reset" value="reset"/>
			</td>
			
		</tr>
	</table>
</form>
</body>
</html>