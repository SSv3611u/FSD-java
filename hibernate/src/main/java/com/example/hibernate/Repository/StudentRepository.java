package com.example.hibernate.Repository;

import com.example.hibernate.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // JpaRepository gives you CRUD for free!
    // save(), findAll(), findById(), deleteById() — all built in
}