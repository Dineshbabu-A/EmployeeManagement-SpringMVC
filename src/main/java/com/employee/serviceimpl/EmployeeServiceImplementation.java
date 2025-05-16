package com.employee.serviceimpl;

import java.util.List;

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

	@Override
	public ModelAndView viewEmployee() {
		
		List<Employee> employees = employeeRepository.viewEmployee();
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("displayEmployees.jsp");
		modelAndView.addObject("employees", employees);
		
		return modelAndView;
	}

	@Override
	public ModelAndView fetchById(int employeeId) {
		
		Employee employee = employeeRepository.fetchById(employeeId);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("saveUpdatedEmployee.jsp");
		modelAndView.addObject("employee", employee);
		
		return modelAndView;
	}

	@Override
	public ModelAndView saveUpdatedEmployee(Employee employee) {
		
		int age = EmployeeUtility.calculateAge(employee.getDob());

		employee.setAge(age);

		if(employee.getisActive()) {
			employee.setStatus("Active");
		}else {
			employee.setStatus("Not Active");
		}

		Employee employees=employeeRepository.saveUpdatedEmployee(employee);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("viewEmp");
		
		return modelAndView;
	
	}

	@Override
	public ModelAndView removeById(int id) {
		
		employeeRepository.removeById(id);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("viewEmp");
		
		return modelAndView;
	
	}

}
