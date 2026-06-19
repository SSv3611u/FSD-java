package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;



@Service
public class EmployeeService {
	  	@Autowired
	    private EmployeeRepository repo;

	    // CREATE
	    public Employee save(Employee e) {
	        return repo.save(e);
	    }

	    // READ ALL
	    public List<Employee> getAll() {
	        return repo.findAll();
	    }

	    // READ BY ID
	    public Employee getById(int id) {
	        return repo.findById(id).orElse(null);
	    }

	    // UPDATE
	    public Employee update(int id, double newSal) {
	        Employee e = repo.findById(id).orElse(null);
	        if (e != null) {
	            e.setSalary(newSal);
	            return repo.save(e);
	        }
	        return null;
	    }

	    // DELETE
	    public void delete(int id) {
	        repo.deleteById(id);
	    }
}
