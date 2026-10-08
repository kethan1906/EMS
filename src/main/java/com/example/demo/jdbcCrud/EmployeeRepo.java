package com.example.demo.jdbcCrud;

import java.util.List;

import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee,Integer>
{
   List<Employee> findBySalaryGreaterThan(int sal);
   
//   @Query("Select e from employee e where 1.salary > ?1 and e.age = ?2")
//   List<Employee> complexQuery1(int sal,int age);
   
//   @NativeQuery(value="Select * from employee  where salary > ?1 and age = ?2")
//   List<Employee> complexQuery2(int sal,int age);
	
}
