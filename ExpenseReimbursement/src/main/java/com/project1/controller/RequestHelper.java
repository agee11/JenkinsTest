package com.project1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestHelper {
	
	public static void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String url = req.getRequestURI();
		//System.out.println(url);
		switch(url) {
			case "/ExpenseReimbursement/api/login":
				LoginController.login(req, resp);
				break;
			case "/ExpenseReimbursement/api/logout":
				HttpSession session = req.getSession(false);
				session.invalidate();
				DefaultController.landing(req, resp);
				break;
			case "/ExpenseReimbursement/api/employee":
				EmployeeController.employee(req, resp);
				break;
			case "/ExpenseReimbursement/api/employee/tickets":
				switch(req.getMethod()) {
					case "GET":
						EmployeeController.getEmployeeTickets(req, resp);
						break;
					case "POST":
						EmployeeController.createEmployeeTicket(req, resp);
						break;
				}
				break;
			case "/ExpenseReimbursement/api/manager":
				ManagerController.manager(req, resp);
				break;
			case "/ExpenseReimbursement/api/manager/tickets":
				switch(req.getMethod()) {
				case "GET":
					ManagerController.getAllTickets(req, resp);
					break;
				case "POST":
					ManagerController.updateTicket(req, resp);
					break;
				}
				break;
			case "/ExpenseReimbursement/api/":
				//System.out.println("Fake Default");
				DefaultController.landing(req, resp);
				break;
			default:
				//System.out.println("Default");
//				RequestDispatcher redis = req.getRequestDispatcher("/ExpenseReimbursement/api");
//				redis.forward(req, resp);
				resp.sendRedirect("http://localhost:8080/ExpenseReimbursement/api/");
				break;
		}
	}

}
