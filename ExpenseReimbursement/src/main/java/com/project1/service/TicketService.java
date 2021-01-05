package com.project1.service;

import java.util.ArrayList;
import java.util.List;

import com.project1.dao.ExpTicketDaoImp;
import com.project1.models.ExpTicket;

public class TicketService {
	
	ExpTicketDaoImp expDao = new ExpTicketDaoImp();
	
	public void insertTicket(ExpTicket t) {
		expDao.createTicket(t);
	}
	
	public List<ExpTicket> getTicketByEmployee(int id){
		ArrayList<ExpTicket> expList = (ArrayList<ExpTicket>) expDao.getAllTicketsByEmployeeId(id);
		
		return expList;
	}
	
	public List<ExpTicket> getAllTickets(){
		ArrayList<ExpTicket> expList = (ArrayList<ExpTicket>) expDao.getAllTickets();
		
		return expList;
	}
	
	public void approveTicketById(int id) {
		expDao.approveTicketById(id);
	}
	
	public void denyTicketById(int id) {
		expDao.denyTicketById(id);
	}

}
