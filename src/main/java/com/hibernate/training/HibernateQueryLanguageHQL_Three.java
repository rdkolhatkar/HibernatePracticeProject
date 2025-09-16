package com.hibernate.training;

import com.hibernate.practice.ApplicantDetails;
import com.hibernate.practice.ApplicationsForJobs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HibernateQueryLanguageHQL_Three {
    // Hibernate GET VS LOAD
    @Test
    public void fetchDataFromApplicantDetails(){
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(ApplicantDetails.class)
                .addAnnotatedClass(ApplicationsForJobs.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        // Using GET method
        ApplicantDetails applicantDetails = session.get(ApplicantDetails.class, 101);
        System.out.println(applicantDetails);
        // Using LOAD method
        ApplicantDetails applicantDetails1 = session.load(ApplicantDetails.class, 102);
        System.out.println(applicantDetails1);
        // But LOAD method returns a proxy object and it will hit the database only when we try to access any property of the object.
        // So, if we don't access any property of the object, it will not hit the database.
        // Here, we are accessing the property of the object, so it will hit the database.
        System.out.println("Applicant Name: " + applicantDetails1.getApplicantName());
        // If we try to load a record which is not present in the database, it will throw an ObjectNotFoundException.
        // ApplicantDetails applicantDetails2 = session.load(ApplicantDetails.class, 999); // This will throw an exception
        // Load method is deprecated in Hibernate 5 and removed in Hibernate 6.
        // Alternatively, we can use session.byId(Class).load(id) method to achieve the same functionality as load method.
        ApplicantDetails applicantDetails2 = session.byId(ApplicantDetails.class).load(303);
        System.out.println("Applicant Name: " + applicantDetails2.getApplicantName());


        session.close();
        sessionFactory.close();

    }

}
