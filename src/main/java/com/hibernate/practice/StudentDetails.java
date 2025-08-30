package com.hibernate.practice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentDetails {
    // POJO class - Plain Old Java Object
    @Id
    private int rollNo;
    private String name;
    private String age;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
