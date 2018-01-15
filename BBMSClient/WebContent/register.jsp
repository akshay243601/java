<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Registration</title>
		<script src="Resource/jQuery/jquery-1.12.2.js"></script>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="style.css">
		<script type="text/javascript">
		function isValid()
		{
			var pass = $("#pass").val();
			var cpass = $("#cpass").val();
			if(pass==cpass)
			{
				return true;
			}
			else
			{
				$("#errorMsg").html("password or confirm password is not matched");
				return false;
			}
		}
		
		</script>
	</head>
	<body>
	<span id="errorMsg"></span>
	<center>
		<table class = "main">
				<tr>
					<td></td><td><hr color="#99CC00"><h1><font size="8"><center>Register Here:</center></font></h1><hr color="#99CC00"></td>
				</tr>
				<form role="form" action = "registerAction.jsp" method = "post"  onsubmit="return isValid()">
					<tr>
						<td> <label for="Name"> Name<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="ename" placeholder="Enter First Name" required = "true"> </td>
					</tr>
					<tr>
						<td> <label for="email">Email<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="email" placeholder="Enter Last Name" required = "true"> </td>
					</tr>
					<tr>
						<td> <label for="pass">Password<sup><b>*</b></sup> </label> </td>
						<td> <input type="password" class="form-control" id="pass" name="epass" placeholder="Enter Password" required = "true"> </td>
					</tr>
					<tr>
						<td> <label for="cpass">Confirm Password<sup><b>*</b></sup> </label> </td>
						<td> <input type="password" class="form-control" name="cpass" id="cpass" placeholder="Enter Password Again" required = "true"> </td>
					</tr>	
					
					<tr>
						<td> <label for="eaddress">Address<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="eaddress" placeholder="Enter Address" required = "true"> </td>
					</tr>	
					
					
					<tr>
						<td> <label for="emobile">Mobile<sup><b>*</b></sup> </label> </td>
						<td> <input type="text" class="form-control" name="emobile" placeholder="Enter Mobile Number" required = "true"> </td>
					</tr>	
					<tr>
						<td><input type="submit" class="btn btn-primary" value = "Submit"></td>
						<td><a class="btn btn-primary" href="aboutUs.jsp">Cancel</a></td>
					</tr>
			</form>
		<table>
	</center>
