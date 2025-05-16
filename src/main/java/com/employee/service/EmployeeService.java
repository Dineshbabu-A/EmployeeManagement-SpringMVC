package com.employee.service;

import org.springframework.web.servlet.ModelAndView;

import com.employee.entity.Employee;

public interface EmployeeService {

	public ModelAndView addEmployee(Employee employee);

	public ModelAndView viewEmployee();

	public ModelAndView fetchById(int employeeId);

	public ModelAndView saveUpdatedEmployee(Employee employee);

	public ModelAndView removeById(int id);
	
}
