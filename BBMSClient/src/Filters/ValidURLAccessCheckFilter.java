package Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import Logger.BBMSLogger;

public class ValidURLAccessCheckFilter implements Filter 
{

	public void destroy() 
	{
	
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterChain) throws IOException, ServletException 
			{
				HttpServletRequest request = (HttpServletRequest)req;
				HttpServletResponse response = (HttpServletResponse)res;
				HttpSession session = request.getSession();
				if(request == null || (String)session.getAttribute("EmployeeEmail") == null || (String)session.getAttribute("EmployeeEmail") == "")
				{
					BBMSLogger.LogInfo("Employee Emails :- " + (String)request.getAttribute("EmployeeEmail"));
					BBMSLogger.LogInfo("You are trying to access URL directly");
					response.sendRedirect("login.jsp");
		            return;
				}
				filterChain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException 
	{

	}
}
