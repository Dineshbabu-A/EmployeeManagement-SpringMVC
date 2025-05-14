package com.employee.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import com.employee.utility.EmployeeUtility;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public ModelAndView addEmployee(Employee employee) {

		int age = EmployeeUtility.calculateAge(employee.getDob());

		employee.setAge(age);

		if(employee.getisActive()) {
			employee.setStatus("Active");
		}else {
			employee.setStatus("Not Active");
		}


		employeeRepository.addEmployee(employee);

		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("index.jsp");

		return modelAndView;
	}



}
