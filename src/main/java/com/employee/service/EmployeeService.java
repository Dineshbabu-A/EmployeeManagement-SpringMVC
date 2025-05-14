package com.employee.service;

import org.springframework.web.servlet.ModelAndView;

import com.employee.entity.Employee;

public interface EmployeeService {

	public ModelAndView addEmployee(Employee employee);
}
