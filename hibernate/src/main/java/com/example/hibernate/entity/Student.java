package com.example.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "branch")
    private String branch;

    @Column(name = "cgpa")
    private double cgpa;

    // Default constructor (mandatory for Hibernate)
    public Student() {}

    public Student(String name, String branch, double cgpa) {
        this.name   = name;
        this.branch = branch;
        this.cgpa   = cgpa;
    }

    // Getters & Setters
    public int getId()                   { return id; }
    public void setId(int id)            { this.id = id; }

    public String getName()              { return name; }
    public void setName(String name)     { this.name = name; }

    public String getBranch()            { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public double getCgpa()              { return cgpa; }
    public void setCgpa(double cgpa)     { this.cgpa = cgpa; }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name
             + ", branch=" + branch + ", cgpa=" + cgpa + "]";
    }
}