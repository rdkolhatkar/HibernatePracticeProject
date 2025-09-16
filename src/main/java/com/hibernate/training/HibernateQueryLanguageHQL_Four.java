package com.hibernate.training;

import com.hibernate.practice.ApplicantDetails;
import com.hibernate.practice.ApplicationsForJobs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class HibernateQueryLanguageHQL_Four {

    // Level 2 Hibernate Second-Level Cache using Ehcache.
    @Test
    public void fetchDataFromApplicantDetails(){
        // Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.conf.xml")
                .addAnnotatedClass(ApplicantDetails.class) //Added CustomerDetails class
                .addAnnotatedClass(ApplicationsForJobs.class) //Added CustomerAppliances class
                .buildSessionFactory();

            // Open session
            Session session = sessionFactory.openSession();
            ApplicantDetails A1 = session.get(ApplicantDetails.class, 102);
            System.out.println("Applicant ID: " + A1.getApplicantId());

            session.close();

            // Open new session
            Session session1 = sessionFactory.openSession();
            ApplicantDetails A2 = session1.load(ApplicantDetails.class, 102);
            System.out.println("Applicant Name: " + A2.getApplicantName());

            session1.close();


        }

    }

