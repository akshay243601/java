<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DBean.DBConnection"%>
<jsp:useBean id="dcon" scope="session" class="DBean.DBConnection" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Class</title>

<script type="text/javascript">

$(function(){
  $("#classCode").change(function(){
    window.location='StudentClass.jsp?Class_Code='+this.value;
  });
});

$(document).on("click", ".display-image", function () 
{
	var studentDetails = $(this).data('id');
	var StudentImage = studentDetails.split("StudentImage:")[1].split(":MobileNumber:")[0];
	var Name = "dfs";//studentDetails.split(":Name:")[1].split(":Pvisible")[0];
	var mobileNumber= "sdfsdf";//studentDetails.split(":ProCode:")[1].split(":Price:")[0];
	var address = "sdfsd";//studentDetails.split("ProImage:")[0].split("ProName:")[1];
	document.getElementById('image-name').src=StudentImage;
	document.getElementById('Student-Mobile').innerHTML="Mobile :"+mobileNumber;
	document.getElementById('Student-Address').innerHTML="Address :"+address;
	document.getElementById('Student-Name').innerHTML="Name :"+Name;
});


</script>
</head>
<body>
<div>
	<%
					int ClassCode=Integer.parseInt(request.getParameter("Class_Code"));
				 	Connection conn;
				 	conn=dcon.getConnection();
				 	Statement st=conn.createStatement();
				 	ResultSet rs_ClassCode=st.executeQuery("select Class_Code, Class_Name from ClassDetails order by Class_Code");
	 			%>
	 			Class :- 
	 			<select name='classCode' id="classCode" style='width:150;text-shadow: black;background-color: black;' onchange=""> 
								<%
					 				while(rs_ClassCode.next())
									{ 
					 		 	%>
					 		 		<option value=<%=rs_ClassCode.getInt(1)%> <%= rs_ClassCode.getInt(1)==ClassCode  ?  " selected='selected'" :""%>> 
					 		 	<%= rs_ClassCode.getString(2).toUpperCase()%>
					 		 		</option>
					 		 	<%} %>
	 			</select>
</div>
	<%
		PreparedStatement ps = conn.prepareStatement("select * from StudentDetails where Class_Code = ?");
		ps.setInt(1, ClassCode);
		ResultSet rs = ps.executeQuery();
		int i = 0;
		String photoFilePath = application.getInitParameter("StudentImagePath");
	%>
	<center>
		<div id="a">
			<table>	
				<tr>
				<%
					while(rs.next())
					{
						i++;
			
						%>
						<td>
							<table id="productDetails">
								<tr>
									<td>
									 	<%
										 	String studentImage = rs.getString("PhotoFileName");
									 		String imagePath = "Resource/images/noPhoto.png";
									 		if(studentImage != "" && studentImage != null)
									 		{
									 			imagePath = photoFilePath + studentImage;
									 		}
								 		%>	
										 	<a href="#enlargeImage" class="display-image" data-id="<%= "Name:"+ rs.getString("FirstName") +" " +rs.getString("MiddleName") +" " +rs.getString("LastName")+"StudentImage:"+imagePath+":MobileNumber:"+ rs.getString("Mobile")+":Address:"+ rs.getString("Address")%>" data-toggle="modal">
										 	<img src="<%=imagePath%>" class="img-thumbnail open-Model" width="200px" height="200px">
										 	
										 </a> 
									</td> 
									</tr>
									<tr>
									<td id="<%= rs.getString("FirstName") +" " +rs.getString("MiddleName") +" " +rs.getString("LastName")%>">
										<center>
											<a href = "<%="StudentProfile.jsp?studentId="+ rs.getString("studentId")%>"><%= rs.getString("FirstName") +" " +rs.getString("MiddleName") +" " +rs.getString("LastName")%></a>
										</center>
									</td> 
								</tr>
							</table>
						</td>
						<%
						if(i%3 == 0)
						{
							%>
						</tr><tr>
							<%			
						}
		}
	 %>
	</table>	
	</div>
	</center>
	<div class="modal fade" id="enlargeImage">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<center>
						<h3 id="Student-Name">Name :   </h3>
					</center>
				</div>
				<div class="modal-body">
					<center>
						<img src=" " id="image-name"  style="max-height: 700px;max-width: 500px" /> 
					</center>
				</div>
				<div class="modal-footer">
					<center>
						<table border="0px">
							<tr>
								<td width="100%">
									<center>
										<div id="Student-Address">Address :  </div> <br>
										<div id="Student-Mobile">Mobile :</div> 
									</center>
								</td>
							</tr>
						</table>
					</center>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>