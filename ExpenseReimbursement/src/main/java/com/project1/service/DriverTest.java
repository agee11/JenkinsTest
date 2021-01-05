package com.project1.service;

import com.project1.dao.EmployeeDaoImp;

public class DriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDaoImp eDao = new EmployeeDaoImp();
		
		System.out.println(eDao.getEmployeeByCred("batman", "gotham"));
	}

}
