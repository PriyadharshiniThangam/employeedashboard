package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.model.Employee;
import com.springboot.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	 private EmployeeServiceImpl employeeService;
	 
	 /**
	 * @return
	 */
	@GetMapping("/list")
	public String index(ModelMap modelMap) {
		List<Employee> employee = employeeService.getAllEmployees();
		modelMap.addAttribute("employee_list", employee);
		return "../employee_list";
	}
	 
	 
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public String editEmployee(@PathVariable int id) {
	  
	  
	  return "employee_form.jsp";
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public String addEmployee(Model model) {
	  
	  
	  
	 return "employee_form.jsp";
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public String saveOrUpdate(@ModelAttribute("employeeForm") Employee employee) {
	  if(employee.getId() != null) {
	   employeeService.updateEmployee(employee);
	  } else {
	   employeeService.addEmployee(employee);
	  }
	  
	  return ("redirect:/employee/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public String deleteEmployee(@PathVariable("id") int id) {
	  employeeService.deleteEmployee(id);
	  
	  return ("redirect:/employee/list");
	 }
}
