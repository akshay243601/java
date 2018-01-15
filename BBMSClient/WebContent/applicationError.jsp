<%@page import="Logger.BBMSLogger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
<style type="text/css">
body { 
	background:url(Resouce/images/tail-top.gif) left top repeat-x #140100;
	font-family:Georgia, "Times New Roman", Times, serif;
	font-size:100%; 
	line-height:1.5em;
	color:#cbe0ff;
}

img {
	border:0; 
	vertical-align:top; 
	text-align:left;
}

ul, ol { 
	list-style:none;
}


.wrapper { 
	width:100%;
	overflow:hidden;
}


/*==== GLOBAL =====*/
#main {
	width:1000px; 
	margin:0 auto;
	background:url(Resource/images/main-bg.jpg) no-repeat left top;
	font-size:1.3125em;
	position:relative;
}

#header {
	height:190px;
}
#content {
	min-height:457px;
	height:auto !important;
	height:457px;
}
/*----- txt, links, lines, titles -----*/
a {
	color:#fff; 
	outline:none;
}
a:hover{
	text-decoration:none;
}

#err {
	font-size:55px;
	line-height:1.2em;
	font-weight:normal;
	color:#cbe0ff;
	text-align:center;
	padding:62px 0 0 0;
	font-variant:small-caps;
	text-transform:capitalize;
}
	#err span {
		display:block;
		font-size:20px;
		line-height:25px;
		font-variant:normal;
		text-transform:uppercase;
	}
	#err strong {
		font-weight:normal;
		font-size:1.11em;
	}


/*===== content =====*/
#content .nav {
	position:relative;
	height:368px;
}
	#content .nav li {
		position:absolute;
		font-size:14px;
		line-height:1.2em;
		font-weight:bold;
		font-variant:small-caps;
		text-transform:capitalize;
	}
	#content .nav li.home {
		left:451px;
		top:300px;
		font-size:18px;
	}
	#content .nav li.login {
		left:273px;
		top:263px;
	}
	#content .nav li.register {
		right:230px;
		top:261px;
	}
		#content .nav li a {
			color:#fff;
			text-decoration:none;
		}
		#content .nav li a:hover {
			text-decoration:underline;
		}

/*==========================================*/
</style>
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
	
	BBMSLogger.LogError(exception.toString());
%>
	<div id="main">
		<!-- header -->
		<div id="header">
			<h1 id="err">Nothing alive here!<span><strong>404</strong> error - not found</span></h1>
		</div>
		<!-- content -->
		<div id="content">
			<ul class="nav">
         	<li class="home"><a href="aboutUs.jsp">Home Page</a></li>
            <li class="login"><a href="login.jsp">Login</a></li>
            <li class="register"><a href="register.jsp">Register</a></li>
         </ul>
	</div>
</body>
</html>