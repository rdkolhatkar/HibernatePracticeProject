package com.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ApplicantDataConfig {
    @Test
    public void JobApplicantDataTest(){
        // Creating objects for applicant details
        ApplicantDetails applicantDetails = new ApplicantDetails();
        ApplicantDetails applicantDetails1 = new ApplicantDetails();
        ApplicantDetails applicantDetails2 = new ApplicantDetails();

        // Creating objects for job applications
        ApplicationsForJobs applicationsForJobs = new ApplicationsForJobs();
        ApplicationsForJobs applicationsForJobs1 = new ApplicationsForJobs();
        ApplicationsForJobs applicationsForJobs2 = new ApplicationsForJobs();

        // Creating multiple applicant details (List of applicants)
        applicantDetails.setApplicantId(101);
        applicantDetails.setApplicantName("John Doe");
        applicantDetails.setApplicantAddress("456 Elm St, Metropolis");

        applicantDetails1.setApplicantId(102);
        applicantDetails1.setApplicantName("Jane Smith");
        applicantDetails1.setApplicantAddress("789 Oak St, Gotham");

        applicantDetails2.setApplicantId(103);
        applicantDetails2.setApplicantName("Alice Johnson");
        applicantDetails2.setApplicantAddress("321 Pine St, Star City");

        // Setting the applied jobs for each applicant
        applicantDetails.setAppliedJobs(Arrays.asList(applicationsForJobs, applicationsForJobs1, applicationsForJobs2));
        applicantDetails1.setAppliedJobs(Arrays.asList(applicationsForJobs, applicationsForJobs1));
        applicantDetails2.setAppliedJobs(Arrays.asList(applicationsForJobs));

        // Creating Multiple job applications (List of jobs)
        applicationsForJobs.setJobId(301);
        applicationsForJobs.setJobLocation("New York");
        applicationsForJobs.setJobType("Software Engineer");

        applicationsForJobs1.setJobId(302);
        applicationsForJobs1.setJobLocation("San Francisco");
        applicationsForJobs1.setJobType("Data Scientist");

        applicationsForJobs2.setJobId(303);
        applicationsForJobs2.setJobLocation("Chicago");
        applicationsForJobs2.setJobType("Product Manager");

        // Setting the applicants for each job
        applicationsForJobs.setApplicants(Arrays.asList(applicantDetails, applicantDetails1, applicantDetails2));
        applicationsForJobs1.setApplicants(Arrays.asList(applicantDetails, applicantDetails1));
        applicationsForJobs2.setApplicants(Arrays.asList(applicantDetails));


        // Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.conf.xml")
                .addAnnotatedClass(ApplicantDetails.class) //Added CustomerDetails class
                .addAnnotatedClass(ApplicationsForJobs.class) //Added CustomerAppliances class
                .buildSessionFactory();
        Session session = null;
        try {
            // Open session
            session = sessionFactory.openSession();
            // .persist(object of Entity Class) -> This method is used for saving a new record
            // .merge(object of Entity Class) -> This method is used for updating the existing record
            // Start transaction
            Transaction transaction = session.beginTransaction();
            // Persisting the applicant details
            session.persist(applicantDetails);
            session.persist(applicantDetails1);
            session.persist(applicantDetails2);
            // persisting the job applications
            session.persist(applicationsForJobs);//The .persist() method is used to save a new object into the database.
            session.persist(applicationsForJobs1);
            session.persist(applicationsForJobs2);
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
