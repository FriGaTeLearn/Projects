package com.ra.learn.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import scala.annotation.meta.getter;

import com.ra.learn.model.Employee;

/**
 * @author rath02
 *
 */
public class JdbcEmployeeDAOImpl implements JdbcEmployeeDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Employee employee) {

		String query = "insert into employee(id,name,age) values (?,?,?)";

		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(query,new Object[] { employee.getId(), employee.getName(),employee.getAge() });
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Employee findById(int id) {
		String query = "select * from employee where id = ?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		/**
		 * Using Simple Row mapper
		 */
		//Employee employee = jdbcTemplate.queryForObject(query, new Object[]{id}, new EmployeeMapper());
		
		/**
		 * Using Bean property Row mapper
		 * 
		 * The BeanPropertyRowMapper maps a row column value to a property of the object by matching their names.
		 */	
		Employee employee = jdbcTemplate.queryForObject(query, new Object[]{id}, new BeanPropertyRowMapper(Employee.class));
		return employee;
	}

	public List<Employee> findAll() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		String query  = "select * from employee";
		
		List<Employee> employees = new ArrayList<Employee>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		
		for (Map<String, Object> map : rows) {
			Employee employee = new Employee(Integer.parseInt(String.valueOf(map.get("id"))) , ((String) map.get("name")) , Integer.parseInt(String.valueOf(map.get("age"))));
			employees.add(employee);
		}
		return employees;
	}
}