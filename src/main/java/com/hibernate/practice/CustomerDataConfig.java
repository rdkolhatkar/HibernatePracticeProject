package com.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CustomerDataConfig {
    @Test
    public void customerDataAppliancesTest(){
        CustomerDetails customerDetails = new CustomerDetails();
        CustomerAppliances customerAppliances = new CustomerAppliances();
        CustomerAppliances customerAppliances1 = new CustomerAppliances();
        CustomerAppliances customerAppliances2 = new CustomerAppliances();

        // Creating multiple appliances (List of appliances)
        customerAppliances.setApplianceId(201);
        customerAppliances.setApplianceName("Samsung Refrigerator");
        customerAppliances.setApplianceType("Refrigerator");
        customerAppliances.setAppliancePrice(1200.00);
        customerAppliances.setCustomerDetails(customerDetails); // Setting the customer details for the appliance

        customerAppliances1.setApplianceId(202);
        customerAppliances1.setApplianceName("LG Washing Machine");
        customerAppliances1.setApplianceType("Washing Machine");
        customerAppliances1.setAppliancePrice(800.00);
        customerAppliances1.setCustomerDetails(customerDetails); // Setting the customer details for the appliance

        customerAppliances2.setApplianceId(203);
        customerAppliances2.setApplianceName("Sony LED TV");
        customerAppliances2.setApplianceType("Television");
        customerAppliances2.setAppliancePrice(1500.00);
        customerAppliances2.setCustomerDetails(customerDetails); // Setting the customer details for the appliance

        // Creating customer details
        customerDetails.setCustomerId(1);
        customerDetails.setCustomerName("Alice Smith");
        customerDetails.setCustomerAddress("123 Main St, Springfield");
        customerDetails.setAppliancesPurchased(Arrays.asList(customerAppliances, customerAppliances1, customerAppliances2));

        // Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.app.xml")
                .addAnnotatedClass(CustomerDetails.class) //Added CustomerDetails class
                .addAnnotatedClass(CustomerAppliances.class) //Added CustomerAppliances class
                .buildSessionFactory();
        Session session = null;
        try {
            // Open session
            session = sessionFactory.openSession();
            // .persist(object of Entity Class) -> This method is used for saving a new record
            // .merge(object of Entity Class) -> This method is used for updating the existing record
            // Start transaction
            Transaction transaction = session.beginTransaction();
            // Persisting the appliances
            session.persist(customerDetails);
            session.persist(customerAppliances);//The .persist() method is used to save a new object into the database.
            session.persist(customerAppliances1);
            session.persist(customerAppliances2);
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
