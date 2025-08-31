package com.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;


public class StudentDataConfig {
    @Test
    public void testHibernateSessionConfiguration() {
        System.out.println("Test method executed");

        StudentDetails student = new StudentDetails();
        student.setRollNo(3);
        student.setName("Trion Tesla");
        student.setAge("20");

        System.out.println("Student Roll No: " + student.getRollNo());
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());

        // Now we have to create a table in the database to store this data using Hibernate
        Configuration configuration = new Configuration(); // This is a Hibernate class which is required for session factory and it is common for all the databases
        // Now we have to add the Entity Class or Annotated Class before configuring the DB
        configuration.addAnnotatedClass(StudentDetails.class);
        // Now we have to load the Database Configurations using XML format
        configuration.configure(); // Here we have to pass the "hibernate.cfg.xml" We can customize the name of the XML file as per our requirements.

        // Now we have to create a session factory to get the session object
        SessionFactory sessionFactory = null; // This is an interface from Hibernate framework
        // Now we have to configure the configuration object with the session factory
        sessionFactory = configuration.buildSessionFactory();
        Session session = null; // This is an interface from Hibernate framework
        // To open a session we need to call the openSession() method of the session factory interface which returns the session object
        session = sessionFactory.openSession();
        // SessionFactory is an heavy object so we need to create it only once in the application
        // Now we have to commit data for saving the data into DB
        Transaction transaction = session.beginTransaction(); // This code will initialize the data transaction
        session.persist(student); // .persist() method is used for saving the data into DB
        transaction.commit();
        session.close(); // Closing the session
        sessionFactory.close(); // Closing the session factory
        System.out.println(student);

    }
    @Test
    public void hibernateSessionConfiguration() {
        System.out.println("Test method executed");

        StudentDetails student = new StudentDetails();
        student.setRollNo(3);
        student.setName("Trion Tesla");
        student.setAge("20");

        System.out.println("Student Roll No: " + student.getRollNo());
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
        /*
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(StudentDetails.class);
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
        */
        // Optimizing the Above code by chaining of objects
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(StudentDetails.class).configure().buildSessionFactory();

        Session session = null;
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(student);
        transaction.commit();
        session.close();
        sessionFactory.close();
        System.out.println(student);
    }

    @Test
    public void fetchTheDataFromMySqlDatabase(){
        System.out.println("Reading Test Data from Database and Extracting the Student details");
        // Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentDetails.class)
                .buildSessionFactory();
        Session session = null;
        try {
            // Open session
            session = sessionFactory.openSession();
            // Start transaction
            Transaction transaction = session.beginTransaction();
            // Fetch data (make sure ID=3 exists in DB)
            StudentDetails studentValues = session.find(StudentDetails.class, 3);
            // Commit transaction
            transaction.commit();
            // Print result
            if (studentValues != null) {
                System.out.println("Fetched Student: " + studentValues);
            } else {
                System.out.println("No student found with ID = 3");
            }
            if (studentValues != null) {
                System.out.println("Student Record Found:");
                System.out.println("ID       : " + studentValues.getRollNo());
                System.out.println("Name     : " + studentValues.getName());
                System.out.println("Age   : " + studentValues.getAge());
            } else {
                System.out.println("No student found with ID = 3");
            }
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
