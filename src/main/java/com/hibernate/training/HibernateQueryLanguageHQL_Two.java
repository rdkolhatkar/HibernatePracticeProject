package com.hibernate.training;

import com.hibernate.practice.ApplicantDetails;
import com.hibernate.practice.ApplicationsForJobs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HibernateQueryLanguageHQL_Two {
    // HQL (Hibernate Query Language) is an object-oriented query language similar to SQL but operates on entity objects and their properties rather than database tables and columns.
    @Test
    public void fetchDataFromApplicantDetails(){
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(ApplicantDetails.class)
                .addAnnotatedClass(ApplicationsForJobs.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        // HQL query to fetch all records from ApplicantDetails entity
        ApplicantDetails applicantDetails = session.get(ApplicantDetails.class, 301);
        System.out.println(applicantDetails);
        // HQL query to fetch all records from ApplicantDetails entity based on a condition
        // Here we want to fetch the record where applicantName is 'John Doe'
        // For SQL We write "SELECT * FROM applicant_details WHERE applicant_name = 'John Doe'"
        // For HQL We write "FROM ApplicantDetails WHERE applicantName = 'John Doe'"
        // Here Query is an interface provided by Hibernate to create and execute HQL queries. It is coming from org.hibernate.query package.

        Query query = session.createQuery("FROM ApplicantDetails WHERE applicantId = 301");
        List<ApplicantDetails> applicants = query.getResultList();
        // Normal for loop
        for(int i =0; i < applicants.size(); i++){
            System.out.println(applicants.get(i));
        }
        // Enhanced for loop
        for(ApplicantDetails applicant : applicants) {
            System.out.println("*************************"+applicant);
        }
        session.close();
        sessionFactory.close();

    }

}
