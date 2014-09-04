/**
 * 
 */
package com.ra.learn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ra.learn.model.Employee;

/**
 * @author rath02
 *
 */
@SuppressWarnings("rawtypes")
public class EmployeeMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee(rs.getInt("id"), rs.getString("name"),
				rs.getInt("age"));
		return employee;
	}
}