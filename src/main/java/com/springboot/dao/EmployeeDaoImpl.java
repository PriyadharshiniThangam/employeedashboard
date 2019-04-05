package com.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.model.Employee;
import com.springboot.model.EmployeeMapper;
@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
@Autowired
JdbcTemplate jdbcTemplate;
@Override
public List<Employee> getAllEmployees() {
	  String query = "select * from employees";
	  RowMapper<Employee> rowMapper = new EmployeeMapper();
	  List<Employee> list = jdbcTemplate.query(query, rowMapper);
	  return list;
}


@Override
public Employee findEmployeeById(int id) {
	// TODO Auto-generated method stub
	String query = "select * from employees where employee_id = ?";
	  RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
	  Employee employee = jdbcTemplate.queryForObject(query, rowMapper, id);
	return employee;
}
@Override
public void addEmployee(Employee employee) {
	// TODO Auto-generated method stub
	String query = "insert into employees(employee_id, first_name, last_name, email, phone, job_title) values(?, ?, ?)";
	  jdbcTemplate.update(query,employee.getName(),employee.getEmail(), employee.getRole());
}
@Override
public void deleteEmployee(int id) {
	// TODO Auto-generated method stub
	String query="delete from employees where id=?";
	jdbcTemplate.update(query,id);
}
@Override
public void updateEmployee(Employee employee) {
	// TODO Auto-generated method stub
		  String query = "update employees SET first_name=?, last_name=?, email=?, phone=?, job_title=? where employee_id=?";
		  jdbcTemplate.update(query, employee.getName(),employee.getEmail(),employee.getRole(), employee.getId());
		  
		 }


}