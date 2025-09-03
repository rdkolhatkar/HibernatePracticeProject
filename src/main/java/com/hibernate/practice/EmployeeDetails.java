package com.hibernate.practice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity(name = "employee_details_table")
public class EmployeeDetails {
    // This is our Model Class which is going to represent our Database Table
    // Here we are going to use Hibernate Annotations with which we can customize the Database Table details
    // Table Name we get from the Entity name & Entity name we get from the Class name by default
    @Id
    private int employeeId;
    @Column(name = "employee_name", length = 50, nullable = false)
    private String employeeName;
    private String employeeAddress;

    public String getTempData() {
        return tempData;
    }

    public void setTempData(String tempData) {
        this.tempData = tempData;
    }

    // Let's say we have oe more variable that we don't want to store in the database table then we can use @Transient annotation
    @Transient
    private String tempData; // This variable will not be stored in the database table

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", tempData='" + tempData + '\'' +
                '}';
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }


}
