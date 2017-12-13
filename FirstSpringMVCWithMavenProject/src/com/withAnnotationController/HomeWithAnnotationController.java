package com.withAnnotationController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeWithAnnotationController 
{
	@RequestMapping("/welcomeWithAnnotation")
	public ModelAndView helloWorld()
	{
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage","hi User! Welcome to the first spring mvc web application");
		return modelAndView;
	}

}
