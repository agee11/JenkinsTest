package com.project1.models;

import java.sql.Timestamp;

public class ExpTicket {
	private int id;
	private String status;
	private String type;
	private String description;
	private double amount;
	private int employeeId;
	private Timestamp timeStamp;
	
	
	public ExpTicket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExpTicket(String status, String type, String description, double amount) {
		super();
		this.status = status;
		this.type = type;
		this.description = description;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "ExpTicket [id=" + id + ", status=" + status + ", type=" + type + ", description=" + description
				+ ", amount=" + amount + ", employeeId=" + employeeId + ", timeStamp=" + timeStamp + "]";
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
