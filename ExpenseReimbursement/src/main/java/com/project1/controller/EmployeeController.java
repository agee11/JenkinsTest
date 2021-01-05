package com.project1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.models.ExpTicket;
import com.project1.service.TicketService;

public class EmployeeController {
	//private static EmployeeService eService = new EmployeeService();
	private static TicketService tService = new TicketService();
	
	public static void employee(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		RequestDispatcher redis = req.getRequestDispatcher("/employeeMenu.html");
		redis.forward(req, resp);
	
	}
	
	public static void getEmployeeTickets(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		resp.setContentType("application/json");
		HttpSession session = req.getSession(false);
		if(session != null) {
			List<ExpTicket> tickets = tService.getTicketByEmployee((int) session.getAttribute("employee_id"));
			
			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(tickets));
		}
		
	}

	public static void createEmployeeTicket(HttpServletRequest req, HttpServletResponse resp) throws JsonParseException, JsonMappingException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			ObjectMapper om = new ObjectMapper();
			ExpTicket t = om.readValue(req.getReader(), com.project1.models.ExpTicket.class);
			t.setEmployeeId((int) session.getAttribute("employee_id"));
			tService.insertTicket(t);
		}
	}
}
