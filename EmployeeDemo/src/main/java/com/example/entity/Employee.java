package com.example.entity;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	private String name;
	
	private String dept;
	
	private double salary;
	
	private Date joining_Date;

	public Employee() {
	}

	public Employee(String name, String dept, double salary, Date joining_Date) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.joining_Date = joining_Date;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getJoining_Date() {
		return joining_Date;
	}

	public void setJoining_Date(Date joining_Date) {
		this.joining_Date = joining_Date;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + ", joining_Date="
				+ joining_Date + "]";
	}
}