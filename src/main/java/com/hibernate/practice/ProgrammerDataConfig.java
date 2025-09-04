package com.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class ProgrammerDataConfig {
    @Test
    public void programmerDataSetUp(){

        // Laptop details
        ProgrammingLaptop programmingLaptop = new ProgrammingLaptop();
        programmingLaptop.setProcessor("Intel i7");
        programmingLaptop.setRAM("16GB");
        programmingLaptop.setStorage("1TB SSD");
        programmingLaptop.setDisplay("15.6 inch");
        // Programmer details
        ProgrammerDetails programmerDetails = new ProgrammerDetails();
        programmerDetails.setName("Sahil Yadav");
        programmerDetails.setExperience("5 years");
        programmerDetails.setProgrammerId(101);
        programmerDetails.setProgrammingLaptop(programmingLaptop);
        // Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.data.xml")
                .addAnnotatedClass(ProgrammerDetails.class)
                .buildSessionFactory();
        Session session = null;
        try {
            // Open session
            session = sessionFactory.openSession();
            // Update records in the database
            session.merge(programmerDetails);
            // .merge(object of Entity Class) -> This method is used for updating the existing record
            // Start transaction
            Transaction transaction = session.beginTransaction();
            // Fetching the data
            ProgrammerDetails programmerValues = session.find(ProgrammerDetails.class, 101);
            System.out.println("Fetched Programmer: " + programmerValues);
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
