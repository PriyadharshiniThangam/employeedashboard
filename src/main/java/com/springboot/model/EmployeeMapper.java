package com.springboot.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee>{
	 public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

Employee employee=new Employee();
employee.setId(rs.getInt("id"));
employee.setName(rs.getString("name"));
employee.setRole(rs.getString("role"));
employee.setEmail(rs.getString("email"));
return employee;
}
}