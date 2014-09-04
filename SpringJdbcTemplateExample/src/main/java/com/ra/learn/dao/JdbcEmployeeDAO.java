package com.ra.learn.dao;

import java.util.List;

import com.ra.learn.model.Employee;

/**
 * @author rath02
 *
 */
public interface JdbcEmployeeDAO {
	
	public void insert(Employee employee);
	public Employee findById(int id);
	public List<Employee> findAll();
}