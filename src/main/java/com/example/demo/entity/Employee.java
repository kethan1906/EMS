package com.example.demo.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity(name="emp_table")
@Cacheable // Standard JPA annotation to mark entity for L2 caching
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE) 
public class Employee 
{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int empId;
	//@Column(name = "full_name", nullable = false, length = 50)
	private String fullName;
	private int age;
	private int salary;
	@Transient
	private int bonusRating;
	
	public int getEmpid() {
		return empId;
	}
	public void setEmpid(int empid) {
		this.empId = empid;
	}
	public String getName() {
		return fullName;
	}
	public void setName(String name) {
		this.fullName = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empId + ", name=" + fullName + ", age=" + age + ", salary=" + salary + "]";
	}
	public Employee(int empid, String name, int age, int salary) {
		super();
		this.empId = empid;
		this.fullName = name;
		this.age = age;
		this.salary = salary;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	


}
