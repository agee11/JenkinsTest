package com.project1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project1.models.Employee;
import com.project1.service.EmployeeService;

public class LoginController {
	
	private static EmployeeService eService = new EmployeeService();
	
	public static void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {		
		
		if(req.getMethod().equals("POST")) {
			Employee emp = null;

			if(eService.validCredentials(req.getParameter("username"), req.getParameter("password"))) {
				emp = eService.getEmployeeByCred(req.getParameter("username"), req.getParameter("password"));
				
				HttpSession session = req.getSession(true);
				session.setAttribute("employee_id", emp.getId());
				
				String nextPage = emp.isManager() ? "/api/manager" : "/api/employee";
				
				resp.sendRedirect(req.getContextPath() + nextPage);
			}else {
				RequestDispatcher redis = req.getRequestDispatcher("/error.html");
				redis.forward(req, resp);			
			}
		}else {
			resp.setStatus(405);
		}
	}
}
