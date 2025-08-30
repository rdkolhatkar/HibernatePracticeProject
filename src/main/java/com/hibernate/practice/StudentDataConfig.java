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
        student.setRollNo(1);
        student.setName("John Doe");
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
        transaction.commit();

    }

}
