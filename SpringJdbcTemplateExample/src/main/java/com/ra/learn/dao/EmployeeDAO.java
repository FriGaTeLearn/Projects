package com.ra.learn.dao;

import com.ra.learn.model.Employee;

public interface EmployeeDAO {
	
	public void insert(Employee employee);

	public Employee findById(int id);
}