package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.EmployeeDao;
import com.springboot.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	 @Autowired EmployeeDao employeeDao;
	 public List<Employee> getAllEmployees()
	 {
		  return employeeDao.getAllEmployees();

	 }
	
	 public Employee findEmployeeById(int id) {
		  return employeeDao.findEmployeeById(id);

	 }
	
	 public void addEmployee(Employee employee){
		  employeeDao.addEmployee(employee);

	 }
	 
	 public void updateEmployee(Employee employee){
		  employeeDao.updateEmployee(employee);

	 }
	 
	 public void deleteEmployee(int id)
	 {
		  employeeDao.deleteEmployee(id);

	 }

}
