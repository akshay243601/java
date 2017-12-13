package com.studentForm;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.userDefinedEditor.StudentNameEditor;

import Entity.Student;

@Controller
public class studentWithModelAttributeController 
{
	
	@InitBinder
	public void InitBinder(WebDataBinder webDataBinder)
	{
		webDataBinder.setDisallowedFields(new String[]{"mobile"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy***mm**dd");
		webDataBinder.registerCustomEditor(Date.class, "dob" , new CustomDateEditor(dateFormat, false));
		webDataBinder.registerCustomEditor(String.class, "name" , new StudentNameEditor());
	}
	
	@ModelAttribute
	public void addCommonObject(Model model)
	{
		model.addAttribute("companuName", "Demo X Y Z");
	}
	
	
	@RequestMapping(value="/studentFormwithModel.html", method=RequestMethod.GET) 
	public ModelAndView studentInfo() throws Exception
	{
		String exceptionVal = "ArithmeticException1";
		if(exceptionVal.equals("NullPointerException"))
		{
			throw new NullPointerException();
		}
		else if(exceptionVal.equals("IOException"))
		{
			throw new IOException();
		}
		else if(exceptionVal.equals("ArithmeticException"))
		{
			throw new ArithmeticException();
		}
		
		
		System.out.println("studentWithModelAttributeController : request handler method   studentInfo called.");
		ModelAndView modelAndView = new ModelAndView("AdmissionFormWithModel");
		return modelAndView;
	}
	
	@RequestMapping(value="/studentFormWithModelSubmission.html", method=RequestMethod.POST)
	public ModelAndView studentInfoSubmission(@ModelAttribute("student") @Valid Student student, BindingResult result)
	{
		if(result.hasErrors())
		{
			ModelAndView modelAndView = new ModelAndView("AdmissionFormWithModel");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("SubmissionFormWithModel");
		modelAndView.addObject("headerValue","Congratulatiom");
		return modelAndView;
	}
	
	//
	@RequestMapping(value="/fbLoginCheck.html", method=RequestMethod.POST)
	public ModelAndView studentFBLoginStatusCheck()
	{
		ModelAndView modelAndView = new ModelAndView("fbLoginCheck");
		return modelAndView;
	}
	
	
	
//	@ExceptionHandler(value=NullPointerException.class)
//	public String handleNullPointerException(Exception e)
//	{
//		System.out.println("Null Pointer exception occurs");
//		return "NullPointerException";
//	}
//	
//	@ExceptionHandler(value=IOException.class)
//	public String handleIOException(Exception e)
//	{
//		System.out.println("IO exception occurs");
//		return "IOException";
//	}
//
//	@ExceptionHandler(value=Exception.class)
//	public String handleException(Exception e)
//	{
//		System.out.println("Exception occurs");
//		return "Exception";
//	}

	
}
