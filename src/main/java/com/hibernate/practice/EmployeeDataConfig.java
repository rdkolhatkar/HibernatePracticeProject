package com.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class EmployeeDataConfig {
    @Test
    public void hibernateEmployeeDataTableModifications(){
        System.out.println("Update the existing table from the employee_details schema from MySQL DB");
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setEmployeeId(1);
        employeeDetails.setEmployeeName("Alice Johnson");
        employeeDetails.setEmployeeAddress("456 Oak St, Springfield");
        // Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.dev.xml")
                .addAnnotatedClass(EmployeeDetails.class)
                .buildSessionFactory();
        Session session = null;
        try {
            // Open session
            session = sessionFactory.openSession();
            // Update records in the database
            session.merge(employeeDetails);
            // .merge(object of Entity Class) -> This method is used for updating the existing record
            // Start transaction
            Transaction transaction = session.beginTransaction();
            // Commit transaction
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
        }
    }
}
