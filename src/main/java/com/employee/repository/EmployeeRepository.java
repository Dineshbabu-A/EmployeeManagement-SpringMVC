package com.employee.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import com.employee.entity.Employee;

@Repository
public class EmployeeRepository {
	
	public static EntityManager entityManager() {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("EmployeeCRUD-SpringMVC");
		EntityManager entityManager = emf.createEntityManager();
		
		return entityManager;
	}

	public void addEmployee(Employee employee) {
		
	EntityManager entityManager= EmployeeRepository.entityManager();
	EntityTransaction transaction = entityManager.getTransaction();
	
	transaction.begin();
	
	entityManager.persist(employee);
	
	transaction.commit();
	entityManager.close();
	}
	
	public List<Employee> viewEmployee(){
		
		EntityManager entityManager = EmployeeRepository.entityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		Query<Employee> employee = (Query<Employee>) entityManager.createQuery("FROM Employee");
		List<Employee> list = employee.list();
		
		transaction.commit();
		entityManager.close();
		
		return list;
		
	}

	public Employee fetchById(int employeeId) {
		
		EntityManager entityManager = EmployeeRepository.entityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		Employee employee = entityManager.find(Employee.class, employeeId);
		transaction.commit();
		entityManager.close();
		
		return employee;
		
	}

	public Employee saveUpdatedEmployee(Employee employee) {
		
		EntityManager entityManager= EmployeeRepository.entityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		entityManager.merge(employee);
		
		transaction.commit();
		entityManager.close();
		return employee;
		
		
	}

	public void removeById(int employeeId) {
		
		EntityManager entityManager= EmployeeRepository.entityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		Employee employee = entityManager.find(Employee.class, employeeId);	
		
		entityManager.remove(employee);
		
		transaction.commit();
		entityManager.close();
		
	}
}
