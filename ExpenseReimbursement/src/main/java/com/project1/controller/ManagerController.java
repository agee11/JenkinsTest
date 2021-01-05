package com.project1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.models.ExpTicket;
import com.project1.service.TicketService;

public class ManagerController {
	private static TicketService tService = new TicketService();
	
	public static void manager(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		RequestDispatcher redis = req.getRequestDispatcher("/managerMenu.html");
		redis.forward(req, resp);
	}
	
	public static void getAllTickets(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		resp.setContentType("application/json");
		
		List<ExpTicket> ticketList = tService.getAllTickets();
		
		ObjectMapper om = new ObjectMapper();
		resp.getWriter().write(om.writeValueAsString(ticketList));
		
	}

	public static void updateTicket(HttpServletRequest req, HttpServletResponse resp) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper om = new ObjectMapper();
		ExpTicket t = om.readValue(req.getReader(), com.project1.models.ExpTicket.class);
		
		if(t.getStatus().equals("APPROVED")) {
			tService.approveTicketById(t.getId());
		}else {
			tService.denyTicketById(t.getId());
		}
	}
}
