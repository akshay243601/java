package com.Interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekAccessInterceptor extends HandlerInterceptorAdapter
{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
		if(dayOfWeek == 7)   // 1- Sunday, 2 Monday, 3 Tuesday.........., 7 Saturday
		{
			response.getWriter().write("The website is closed on Saturday; Please accessing it on any other day !!");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception 
	{
		//this method would be called after Spring MVC executes the request handler method for the request
		System.out.println("DayOfWeekAccessInterceptor : postHandle called for the URI :- " + request.getRequestURI());
		
	}

	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception 
	{
		//this method would be called after response object is produced by the view for the request
		System.out.println("DayOfWeekAccessInterceptor : afterCompletion called for the URI :- " + request.getRequestURI());
	}
}
