package com.employee.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}


	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee( @ModelAttribute("employee") Employee employee) {
		
		return employeeService.addEmployee(employee);
		
	}
	
	@RequestMapping(value = "/viewEmp")
	public ModelAndView viewEmployee() {
		
		return employeeService.viewEmployee();
	}
	
	@RequestMapping(value = "/editEmployee",method = RequestMethod.GET)
	public ModelAndView editByID(@RequestParam int id) {
		
		return employeeService.fetchById(id);
		
	}
	
	@RequestMapping(value = "/saveUpdatedEmployee",method = RequestMethod.POST)
	public ModelAndView saveUpdatedEmployee(Employee employee) {
		return employeeService.saveUpdatedEmployee(employee);
	}
	
	@RequestMapping(value = "/removeEmployee",method = RequestMethod.GET)
	public ModelAndView removeByID(@RequestParam int id) {
		
		return employeeService.removeById(id);
		
	}
	
}
