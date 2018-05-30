package com.akshay.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(name = "/employee")
public class EmployeeController {

	@RequestMapping(name = "/get/{empId}")
	public void getEmployee(@RequestParam("empId") int empId) {
		System.out.println("ssfdfd");
		// return null;
	}

	@RequestMapping("/*")
	public ModelAndView home(ModelMap model, Principal principal) {
		System.out.println("Home page");
		model.addAttribute("username", principal.getName());
		model.addAttribute("message", "message custom");
		return new ModelAndView("Home");
	}

	@RequestMapping("/loginPage")
	public ModelAndView loginPageRedirect() {
		System.out.println("Home page");
		return new ModelAndView("Login");
	}

	@RequestMapping("/LoginValidate")
	public ModelAndView loginValidate(@RequestParam("name") String name, @RequestParam("pass") String pass) {
		System.out.println(name);
		if (name.equals(name)) {
			ModelAndView model = new ModelAndView("EmployeePage");
			model.addObject("name", name);
			model.addObject("pass", pass);
			return model;
		}
		return new ModelAndView("Home");
	}
}
