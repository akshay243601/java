package com.restfulService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/fileManage")
public class FileManagementSystemUploadAndDownLoad 
{
	@GET
	@Path("/downloadFile")
	@Produces("text/plain")
	public Response GetFile()
	{
		File f = new File("D:\\Practice\\UniversityRestfulWSDemo\\WebContent\\demoTextFile");
		ResponseBuilder res = Response.ok((Object)f);
		res.header("Content-Disposition", "attachment;filename=DisplayName-FileName1.txt");
		return res.build();
	}
	
	@POST
	@Path("/uploadFile")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String uploadFile(
			@FormDataParam("file")  InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetails
			)
	{
		String uploadFileLocation = "D://Practice/UniversityRestfulWSDemo/WebContent/" + fileDetails
				.getFileName();
		try
		{
			OutputStream out = new FileOutputStream(new File(uploadFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];
			while((read = uploadedInputStream.read(bytes)) != -1)
			{
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return "File Saved Successfully";
	}
	
	
}
