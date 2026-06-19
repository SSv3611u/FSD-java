package com.example.hibernate.service;

import com.example.hibernate.entity.Student;
import com.example.hibernate.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    // CREATE
    public Student save(Student s) {
        return repo.save(s);
    }

    // READ ALL
    public List<Student> getAll() {
        return repo.findAll();
    }

    // READ BY ID
    public Student getById(int id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE
    public Student update(int id, double newCgpa) {
        Student s = repo.findById(id).orElse(null);
        if (s != null) {
            s.setCgpa(newCgpa);
            return repo.save(s);
        }
        return null;
    }

    // DELETE
    public void delete(int id) {
        repo.deleteById(id);
    }
}