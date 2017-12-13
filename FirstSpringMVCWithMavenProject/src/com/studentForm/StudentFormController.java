package com.studentForm;

import java.net.Authenticator.RequestorType;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentFormController 
{
	@ModelAttribute
	public void addCommonObject(Model model)
	{
		model.addAttribute("companuName", "Demo X Y Z");
	}
	
	@RequestMapping(value="/studentForm.html", method=RequestMethod.GET) 
	public ModelAndView studentInfo()
	{
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		return modelAndView;
	}
	
	@RequestMapping(value="/studentFormSubmission.html", method=RequestMethod.POST)
	public ModelAndView studentInfoSubmission(@RequestParam(value="name", defaultValue="Mr. Akg") String studentName,@RequestParam("hobby") String studentHobby)
//	public ModelAndView studentInfoSubmission(@RequestParam Map<String, String>  studentName)
	{
		ModelAndView modelAndView = new ModelAndView("SubmissionForm");
		modelAndView.addObject("welcomeMessage","hi "+studentName +" , your hobbies are :-  " + studentHobby );
		return modelAndView;
	}
}
