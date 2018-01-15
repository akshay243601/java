package Controller;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.net.SecureNioChannel.ApplicationBufferHandler;

import DBean.DBConnection;
import Logger.BBMSLogger;

/**
* Servlet to handle File upload request from Client
* @author Akshay Gupta
*/
public class FileUploadHandler extends HttpServlet {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String UPLOAD_DIRECTORY;
 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException 
          {
	   BBMSLogger.LogInfo("File Upload is called");
	   BBMSLogger.LogInfo("Path :-" + request.getParameter("studentPhotoFile"));
	   		
	   		UPLOAD_DIRECTORY = getServletContext().getRealPath(getServletContext().getInitParameter("StudentImagePath"));
	   		File tempDir = new File(UPLOAD_DIRECTORY);
	   		if(!tempDir.exists())
	   		{
	   			if(tempDir.mkdir())
	   			{
	   				BBMSLogger.LogInfo("Directory " + UPLOAD_DIRECTORY + " Created");
	   			}
	   			else
	   			{
	   				BBMSLogger.LogWarn("Failed in creating the Directory " + UPLOAD_DIRECTORY);
	   			}
	   		}
	   		
           //process only if its multipart content
	   		BBMSLogger.LogInfo("Upload Directory for Student Image" + UPLOAD_DIRECTORY);
	       if(ServletFileUpload.isMultipartContent(request))
	       {
	           try 
	           {
	        	   String name = "";
	               List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	               for(FileItem item : multiparts)
	               {
	                   if(!item.isFormField())
	                   {
	                	   String fileExtension =  FilenameUtils.getExtension(item.getName());
	                	   if(fileExtension != null && fileExtension != "")
	                	   {
	                		   name = "Student Image_" + request.getParameter("studentId") + "." + fileExtension;
	                	   }
	                	   File isFileExist = new File(UPLOAD_DIRECTORY + File.separator + name);
	                       if(isFileExist.exists())
	                       {
	                    	   isFileExist.delete();
	                       };
	                       item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
	                   }
	               }
	               DBConnection con = new DBConnection();
	               Connection conn = con.getConnection();
	               PreparedStatement ps=conn.prepareStatement("UPDATE StudentDetails SET PhotoFileName= ? Where StudentId = ?");
				   ps.setString(1, name);
				   ps.setString(2, request.getParameter("studentId"));
				   ps.executeUpdate();
	               System.out.println("Done");
				   request.setAttribute("message", "File Uploaded Successfully");
	           } 
	           catch (Exception ex) 
	           {   
	              request.setAttribute("message", "File Upload Failed due to " + ex);
	              BBMSLogger.LogError(ex);
	           }
	       }
	       else
	       {
	           request.setAttribute("message",
	                                "Sorry this Servlet only handles file upload request");
	       }
	       request.getRequestDispatcher("/StudentProfile.jsp?studentId="+request.getParameter("studentId")).forward(request, response);
	    
	   }
 
}