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

You can <a href="/SpringHibernateMavenIntegration/">Logout</a> here
Check  session attribute <a href="/SpringHibernateMavenIntegration/checkSessionAttribute/">Logout</a> here
Student Name :- 	${ StudentName}

<table>
	<tr>
		<td>
			Name
		</td>
		<td>
			${student.studentName}
		</td>
	</tr>
	<tr>
		<td>
			age
		</td>
		<td>
			${student.age}
		</td>
	</tr>
	<tr>
		<td>
			Company
		</td>
		<td>
			${student.company}
		</td>
	</tr>
	<tr>
		<td>
			Address
		</td>
		<td>
			${student.address.addressName}
		</td>
	</tr>
	<tr>
		<td>
			Email
		</td>
		<td>
			${student.email }
		</td>
	</tr>
</table>

</body>
</html>