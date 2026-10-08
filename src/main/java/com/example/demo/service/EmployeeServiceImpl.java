package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.jdbcCrud.EmployeeRepo;

import jakarta.transaction.Transactional;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo repo;

	@Override
	public Employee addEmployee(EmployeeDTO empDto) {
	
		Employee emp = new Employee();
		emp.setName(empDto.getFullName());
		emp.setAge(empDto.getAge());
		emp.setSalary(empDto.getSalary());
		
		return repo.save(emp);
	}

	@Override

	public Employee getEmployee(int empId) {
		// TODO Auto-generated method stub
		//return repo.findById(empId).get();
		return testLevel1Cache();
	}

	@Override
	public Employee updateEmployee(Employee updatedEmp) {
		// TODO Auto-generated method stub
		return repo.save(updatedEmp);
	}

	@Override
	public String deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		repo.deleteById(empId);
		return "deleted sucessfully";
	}

	@Async
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) repo.findAll();
	}

	@Override
	public List<Employee> findBySalaryGreaterThan(int sal) {
		
		return repo.findBySalaryGreaterThan(sal);
	}
	
	@Transactional
	public Employee testLevel1Cache()
	{
		System.out.println(" FIRST DB Call");
		Employee emp1 =repo.findById(1).orElseThrow();
		System.out.println(emp1.getName());
		
		System.out.println(" Second DB Call");
		Employee emp2 =repo.findById(1).orElseThrow();
		System.out.println(emp2.getName());	
		return emp2;
	}

}
