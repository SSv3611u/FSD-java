package com.example;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.List;

@SpringBootApplication
public class EmployeeApp implements CommandLineRunner {

    @Autowired
    private EmployeeService service;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // SAVE
        service.save(new Employee("Chenna",  "CSE",     75000.00, Date.valueOf("2024-01-15")));
        service.save(new Employee("Ravi",    "ECE",     65000.00, Date.valueOf("2023-06-10")));
        service.save(new Employee("Anjali",  "HR",      55000.00, Date.valueOf("2022-03-20")));
        service.save(new Employee("Kiran",   "Finance", 80000.00, Date.valueOf("2021-11-05")));
        service.save(new Employee("Meera",   "IT",      90000.00, Date.valueOf("2020-08-25")));
        System.out.println("All employees saved!");

        // GET ALL
        List<Employee> list = service.getAll();
        list.forEach(System.out::println);

        // GET BY ID
        System.out.println(service.getById(1));

        // UPDATE
        service.update(1, 95000.00);
        System.out.println("✅ Updated salary of ID 1 to 95000");

        // AFTER UPDATE
        System.out.println(service.getById(1));

        // DELETE
        service.delete(2);
        System.out.println("Deleted employee with ID 2");

        // FINAL LIST
        service.getAll().forEach(System.out::println);
    }
}