package com.example.hibernate;

import com.example.hibernate.entity.Student;
import com.example.hibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

    @Autowired
    private StudentService service;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // 1. Save students
        service.save(new Student("Chenna", "CSE", 8.9));
        service.save(new Student("Ravi",   "ECE", 7.5));
        service.save(new Student("Anjali", "IT",  9.1));
        System.out.println("\n✅ Students Saved!");

        // 2. Get all
        System.out.println("\n--- All Students ---");
        service.getAll().forEach(System.out::println);

        // 3. Update
        service.update(1, 9.5);
        System.out.println("\n✅ Updated Student 1 CGPA to 9.5");

        // 4. Get by ID
        System.out.println("\n--- Student with ID 1 ---");
        System.out.println(service.getById(1));

        // 5. Delete
        service.delete(2);
        System.out.println("\n✅ Deleted Student with ID 2");

        // 6. Final list
        System.out.println("\n--- Final Student List ---");
        service.getAll().forEach(System.out::println);
    }
}