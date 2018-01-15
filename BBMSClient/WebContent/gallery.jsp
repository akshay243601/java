<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gallery</title>
<script type="text/javascript">

$(document).on("click", ".display-image", function () 
{
	var studentDetails = $(this).data('id');
	var GalImage = studentDetails.split("GalleryImage:")[1];
	document.getElementById('image-name').src=GalImage;
});
</script>
</head>
<body>
<%
String photoFilePath = "Resource/Gallery/";
String realPath = getServletContext().getRealPath("Resource/Gallery/");
File f = new File(realPath);
File[] list = f.listFiles();
	  %>
	  <center>
		<div id="a">
			<table>	
				<tr>
				<%
				for(int i = 1 ; i <= list.length ; i++)
				{
					  File galleryImages = list[i-1];
	  %>
					<td>
						<table id="productDetails">
							<tr>
								<td> 
									<a href="#enlargeImage" class="display-image" data-id="<%= "GalleryImage:"+photoFilePath + galleryImages.getName()%>" data-toggle="modal">
										<img src="<%=photoFilePath + galleryImages.getName()%>" class="img-thumbnail open-Model" width="200px" height="200px"> 
									</a>
								</td> 
							</tr>
						</table>
					</td>
					<%
					if(i%5 == 0)
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
				</div>
				<div class="modal-body">
					<center>
						<img src=" " id="image-name"   style="max-height: 600px;max-width: 500px" />  
					</center>
				</div>
			</div>
		</div>
	</div>	

</body>
</html>