package com.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project1.models.Employee;
import com.project1.util.ConnectionFactory;

public class EmployeeDaoImp implements EmployeeDao{

	@Override
	public void addEmployee(Employee emp) {
		String sql = "insert into project1_employees (username, password, firstName, lastName, isManager)" 
					+ " values(?, ?, ?, ?, ?);";
		
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, emp.getUsername());
			ps.setString(2, emp.getPassword());
			ps.setString(3, emp.getFirstName());
			ps.setString(4, emp.getLastName());
			ps.setBoolean(5, emp.isManager());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Employee getEmployeeByCred(String username, String password) {
		String sql = "select * from project1_employees where username = ? and password = ?;";
		Employee emp = null;
		
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				emp = new Employee();
				emp.setUsername(rs.getString("username"));
				emp.setFirstName(rs.getString("firstName"));
				emp.setLastName(rs.getString("lastName"));
				emp.setManager(rs.getBoolean("isManager"));
				emp.setId(rs.getInt("employee_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public void deleteEmployeeByCred(String username, String password) {
		String sql = "delete from project1_employees where username = ? and password = ?";
		
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
