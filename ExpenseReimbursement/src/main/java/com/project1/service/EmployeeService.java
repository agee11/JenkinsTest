package com.project1.service;

import com.project1.dao.EmployeeDaoImp;
import com.project1.models.Employee;

public class EmployeeService {
	
	private EmployeeDaoImp empDao = new EmployeeDaoImp();
	
	public boolean validCredentials(String username, String password) {
		if(empDao.getEmployeeByCred(username, password) != null) {
			return true;
		}
		return false;
	}
	
	public boolean logout() {
		//Confirm logout
		return false;
	}
	
	public Employee getEmployeeByCred(String username, String password) {
		return empDao.getEmployeeByCred(username, password);
	}
	
}
