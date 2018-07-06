package com.akshay.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akshay.ejbBeans.StatelessEJB;

//@WebServlet(urlPatterns = {"/statelessAddition"})
public class EJBStatelessController extends HttpServlet {

	// This is mandatory to use EJB
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	StatelessEJB statelessEJB = new StatelessEJB();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			int i = Integer.parseInt(req.getParameter("number1"));
			int j = Integer.parseInt(req.getParameter("number2"));
			PrintWriter out;
			out = res.getWriter();

			// Here i am not creating object of statelessEJB like
			// statelessEJB = new StatelessEJB(); Still it will work. Its a
			// beauty of EJB
			statelessEJB.setI(i);
			statelessEJB.setJ(j);
			statelessEJB.add();
			out.println("Addition of two number using EJB is : " + statelessEJB.getK());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
