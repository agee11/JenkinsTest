package com.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project1.models.ExpTicket;
import com.project1.util.ConnectionFactory;

public class ExpTicketDaoImp implements ExpTicketDao {

	@Override
	public void createTicket(ExpTicket ticket) {
		// TODO Auto-generated method stub
		
		String sql = "insert into expense_tickets (status, type, description, amount, dateSubmitted, employee_id)"
					+ " values( ?, ?, ?, ?, CURRENT_TIMESTAMP, ?);";
		
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "OPEN");
			ps.setString(2, ticket.getType());
			ps.setString(3, ticket.getDescription());
			ps.setDouble(4, ticket.getAmount());
			ps.setInt(5, ticket.getEmployeeId());
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ExpTicket getTicketById(int id) {
		String sql = "select * from expense_tickets where id = ?;";
		ExpTicket ticket = null;
		
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ticket = new ExpTicket();
				ticket.setId(rs.getInt("id"));
				ticket.setType(rs.getString("type"));
				ticket.setDescription(rs.getString("description"));
				ticket.setStatus(rs.getString("status"));
				ticket.setAmount(rs.getDouble("amount"));
				ticket.setTimeStamp(rs.getTimestamp("dateSubmitted"));
				ticket.setEmployeeId(rs.getInt("employee_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticket;
	}

	@Override
	public List<ExpTicket> getAllTickets() {
		String sql = "select * from expense_tickets;";
		ArrayList<ExpTicket> ticketList = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ExpTicket ticket = null;
			while(rs.next()) {
				ticket = new ExpTicket();
				ticket.setId(rs.getInt("id"));
				ticket.setType(rs.getString("type"));
				ticket.setDescription(rs.getString("description"));
				ticket.setStatus(rs.getString("status"));
				ticket.setAmount(rs.getDouble("amount"));
				ticket.setTimeStamp(rs.getTimestamp("dateSubmitted"));
				ticket.setEmployeeId(rs.getInt("employee_id"));
				ticketList.add(ticket);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}

	@Override
	public List<ExpTicket> getAllTicketsByEmployeeId(int employeeId) {
		String sql = "select * from expense_tickets where employee_id = ?;";
		ArrayList<ExpTicket> ticketList = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			
			ExpTicket ticket = null;
			while(rs.next()) {
				ticket = new ExpTicket();
				ticket.setId(rs.getInt("id"));
				ticket.setType(rs.getString("type"));
				ticket.setDescription(rs.getString("description"));
				ticket.setStatus(rs.getString("status"));
				ticket.setAmount(rs.getDouble("amount"));
				ticket.setTimeStamp(rs.getTimestamp("dateSubmitted"));
				ticket.setEmployeeId(rs.getInt("employee_id"));
				ticketList.add(ticket);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;

	}

	@Override
	public List<ExpTicket> getAllOpenTickets() {
		String sql = "select * from expense_tickets where status = 'OPEN';";
		ArrayList<ExpTicket> ticketList = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			ExpTicket ticket = null;
			while(rs.next()) {
				ticket = new ExpTicket();
				ticket.setId(rs.getInt("id"));
				ticket.setType(rs.getString("type"));
				ticket.setDescription(rs.getString("description"));
				ticket.setStatus(rs.getString("status"));
				ticket.setAmount(rs.getDouble("amount"));
				ticket.setTimeStamp(rs.getTimestamp("dateSubmitted"));
				ticket.setEmployeeId(rs.getInt("employee_id"));
				ticketList.add(ticket);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}

	@Override
	public List<ExpTicket> getAllClosedTickets() {
		String sql = "select * from expense_tickets where status in ('APPROVED', 'DENIED');";
		ArrayList<ExpTicket> ticketList = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			ExpTicket ticket = null;
			while(rs.next()) {
				ticket = new ExpTicket();
				ticket.setId(rs.getInt("id"));
				ticket.setType(rs.getString("type"));
				ticket.setDescription(rs.getString("description"));
				ticket.setStatus(rs.getString("status"));
				ticket.setAmount(rs.getDouble("amount"));
				ticket.setTimeStamp(rs.getTimestamp("dateSubmitted"));
				ticket.setEmployeeId(rs.getInt("employee_id"));
				ticketList.add(ticket);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}

	@Override
	public void approveTicketById(int ticketId) {
		String sql = "update expense_tickets set status = 'APPROVED' where id = ?;";
		
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ticketId);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void denyTicketById(int ticketId) {
		String sql = "update expense_tickets set status = 'DENIED' where id = ?;";
		
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ticketId);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteTicketById(int ticketId) {
		// TODO Auto-generated method stub
		String sql = "delete from expense_tickets where id = ?";
		
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ticketId);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
