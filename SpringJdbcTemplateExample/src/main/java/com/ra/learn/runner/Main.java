package com.ra.learn.runner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ra.learn.dao.EmployeeDAO;
import com.ra.learn.model.Employee;

/**
 * @author rath02
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		Employee employee = new Employee(11, "Rahul", 20);
		employeeDAO.insert(employee);
		Employee employee2 = employeeDAO.findById(11);
		System.out.println(employee2);
		context.close();
	}
}