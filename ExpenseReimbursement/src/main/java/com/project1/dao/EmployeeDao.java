package com.project1.dao;

import com.project1.models.Employee;

public interface EmployeeDao {
	
	//Create
	public void addEmployee(Employee e);
	
	//Read
	public Employee getEmployeeByCred(String username, String password);
	
	//Update

	
	//Delete
	public void deleteEmployeeByCred(String username, String password);

}
