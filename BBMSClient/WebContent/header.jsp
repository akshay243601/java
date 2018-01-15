<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BBMS</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Log In</title>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script> 
	<script type="text/javascript" src="Resource/js/bootstrap.js"></script> 
	<script src="Resource/jQuery/jquery-1.12.2.js"></script>
	<link rel="stylesheet" type="text/css" href="Resource/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="Resource/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="Resource/style.css">
<!-- 	<link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'> -->
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  	 <script type="text/javascript">
    jQuery(function($){
          $('body').vidbg({
              'mp4': 'Resource/media/mp4_video.mp4',
              'webm': 'Resource/media/webm_video.webm',
              'poster': 'Resource/media/fallback.jpg',
          }, {
            // Options
            muted: true,
            loop: true,
  			overlay: true,
            overlayColor: '#000',
            overlayAlpha: '0.3',
          });
      });
  </script>
  <script src="Resource/dist/vidbg.min.js"></script>
</head>
<body>
<%
	String loggedInUser = (String)session.getAttribute("EmployeeEmail");

%>

  <div class="block-container">
    <div class="block">
    </div>
  </div>
	  <center>
	    <ul class="nav nav-tabs ">
		    <li><a href="aboutUs.jsp">About Us</a></li>
			
			<%
				if(loggedInUser == null || loggedInUser == "")
				{
					%>
						<li><a href="login.jsp">Log in</a></li>
						<li><a href="register.jsp">Register</a></li>
					<%					
					
				}
				else
				{
					%>
						<li><a href="userProfile.jsp">User Profile</a></li>
						<li><a href="logOut.jsp">Log Out</a></li>
					<%
				}
			%>
			
			<li><a href="gallery.jsp">Gallery</a></li>
			<li><a href="contactUs.jsp">Contact Us</a></li>
			<li><a href="socialConnect.jsp">Connect With Facebook</a></li>
        </ul>
        </center>			
<br><br>
</body>
</html>
 