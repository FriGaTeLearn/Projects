package com.ra.learn.runner;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ra.learn.dao.EmployeeDAO;
import com.ra.learn.dao.JdbcEmployeeDAO;
import com.ra.learn.model.Employee;

/**
 * @author rath02
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main1(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		Employee employee = new Employee(11, "Rahul", 20);
		employeeDAO.insert(employee);
		Employee employee2 = employeeDAO.findById(11);
		System.out.println(employee2);
		context.close();
	}
	
	public static void main2(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcEmployeeDAO jdbcEmployeeDAO = (JdbcEmployeeDAO) context.getBean("jdbcEmployeeDAO");
		
		Employee employee = new Employee(12, "Harsh", 22);
		jdbcEmployeeDAO.insert(employee);
		
		Employee employee2 = jdbcEmployeeDAO.findById(11);
		System.out.println(employee2);
		
		context.close();
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcEmployeeDAO jdbcEmployeeDAO = (JdbcEmployeeDAO) context.getBean("jdbcEmployeeDAO");
		List<Employee> employees = jdbcEmployeeDAO.findAll();
		System.out.println(employees);
	}
}