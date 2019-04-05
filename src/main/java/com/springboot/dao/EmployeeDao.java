package com.springboot.dao;

import java.util.List;

import com.springboot.model.Employee;

public interface EmployeeDao {
public List<Employee> getAllEmployees();
public Employee findEmployeeById(int id);
public void addEmployee(Employee employee);
public void deleteEmployee(int id);
public void updateEmployee(Employee employee);

}
