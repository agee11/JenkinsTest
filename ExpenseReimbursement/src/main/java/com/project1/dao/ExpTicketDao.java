package com.project1.dao;

import java.util.List;

import com.project1.models.ExpTicket;

public interface ExpTicketDao {
	//Create
	public void createTicket(ExpTicket ticket);
	
	//Read
	public ExpTicket getTicketById(int id);
	public List<ExpTicket> getAllTickets();
	public List<ExpTicket> getAllTicketsByEmployeeId(int employeeId);
	public List<ExpTicket> getAllOpenTickets();
	public List<ExpTicket> getAllClosedTickets();
	
	//Update
	public void approveTicketById(int ticketId);
	public void denyTicketById(int ticketId);
	
	//Delete
	public void deleteTicketById(int ticketId);
}
