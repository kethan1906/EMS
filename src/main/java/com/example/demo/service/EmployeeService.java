package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(EmployeeDTO emp);
	public Employee getEmployee(int empId);
	public Employee updateEmployee(Employee updatedEmp);
	public String deleteEmployee(int empId);
	public List<Employee> getAllEmployees();
	public  List<Employee> findBySalaryGreaterThan(int sal);
}
