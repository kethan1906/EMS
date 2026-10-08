package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController// @Controller+@ResponseBody
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	EmployeeService service;
	
	@PostMapping("/add")
	public ResponseEntity addEmployee(@RequestBody EmployeeDTO	 emp)
	{
		Employee res=service.addEmployee(emp);
		return new ResponseEntity<Employee>(res,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{empid}")
	public ResponseEntity getEmployee(@PathVariable int empid)
	{
		System.out.println(empid);
		Employee res=service.getEmployee(empid);
		return new ResponseEntity(res,HttpStatus.OK);
	}
	
	@GetMapping("/getBySalGt/{sal}")
	public ResponseEntity getBySalGt(@PathVariable int sal)
	{
		System.out.println(sal);
		List<Employee> res=service.findBySalaryGreaterThan(sal);
		return new ResponseEntity(res,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity updateEmployee(@RequestBody Employee updatedEmp)
	{
		Employee res=service.updateEmployee(updatedEmp);
		return new ResponseEntity(res,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity deleteEmployee(@RequestParam("empid") int empid) {
		
		service.deleteEmployee(empid);
		return new ResponseEntity(HttpStatus.OK);
		
	}
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		
		return new ResponseEntity(service.getAllEmployees(),HttpStatus.OK);
	}

}
