package com.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class UserDataConfig {
    @Test
    public void userConfigDataForDevice() {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(1);
        userDetails.setUserName("John Doe");
        userDetails.setTechnology("Java");

        UserDeviceDetails userDeviceDetails = new UserDeviceDetails();
        userDeviceDetails.setDeviceId(101);
        userDeviceDetails.setDeviceName("Dell XPS 15");
        userDeviceDetails.setDeviceType("Laptop");

        // Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.user.xml")
                .addAnnotatedClass(UserDetails.class) //Added UserDetails class
                .addAnnotatedClass(UserDeviceDetails.class) //Added UserDeviceDetails class
                .buildSessionFactory();
        Session session = null;
        try {
            // Open session
            session = sessionFactory.openSession();
            // Update records in the database
            session.merge(userDetails); // Merging UserDetails
            session.merge(userDeviceDetails);// Merging UserDeviceDetails
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
