package com.akshay.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.akshay.entity.Student;
import com.akshay.service.IStudentService;


@Controller	
@SessionAttributes(value="StudentName")
public class StudentController {
	@Autowired
	IStudentService studentService;
	
	@ModelAttribute
	public void addCommonObject(Model model)
	{
		model.addAttribute("CompanuName", "Demo X Y Z");
	}
	

	@RequestMapping(value = "/")
	public ModelAndView Home() {
		
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/studentRegisterForm")
	public ModelAndView registration() 
	{
		return new ModelAndView("registrationForm");
	}
	
	@RequestMapping(value = "/validateLogin", method = RequestMethod.GET)
	public ModelAndView validate(@RequestParam("email") String email, @RequestParam("password") String password)
	{
		Student student = studentService.validateLogin(email, password, true);
		if(student == null)
		{
			return new  ModelAndView("index","errorMessage","Invalid Login details...... ");// throw new Exception("");
		}
		
		return new ModelAndView("profile", "student", student).addObject("StudentName", student.getStudentName());
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("student") @Valid Student student)
	{
		Student studentDetails = studentService.validateLogin(student.getEmail(), student.getPassword(), false);
		if(studentDetails != null && studentDetails.getId() != 0)
		{
			return new ModelAndView("registrationForm", "errorMessage", "Student with same mail already exist");
		}
		Student studentdetail= null;
		try
		{
			studentdetail =  studentService.registerStudent(student);
		}
		catch(Exception e)
		{
			System.out.println();
			return new ModelAndView("registrationForm", "errorMessage", "Some problem occured....");
		}
		return new ModelAndView("profile", "student", studentdetail).addObject("StudentName", student.getStudentName());
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView insertStudentDetail() {
		return new ModelAndView("insert");
	}
	
	@RequestMapping(value="/checkSessionAttribute" , method = RequestMethod.GET)
	public ModelAndView checkSession() {
		return new ModelAndView("checkSessionPage");
	}
	
}
