package com.hibernate.training;

import com.hibernate.practice.ApplicantDetails;
import com.hibernate.practice.ApplicationsForJobs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HibernateQueryLanguageHQL_One {
    // HQL (Hibernate Query Language) is an object-oriented query language similar to SQL but operates on entity objects and their properties rather than database tables and columns.
    @Test
    public void fetchDataFromApplicantDetails(){
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(ApplicantDetails.class)
                .addAnnotatedClass(ApplicationsForJobs.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        String name = "John Doe";

        Query<ApplicantDetails> query = session.createQuery(
                "FROM ApplicantDetails WHERE applicantName like ?1",
                ApplicantDetails.class
        );
        query.setParameter(1, "%" + name + "%");

        List<ApplicantDetails> applicants = query.getResultList();

        if (applicants.isEmpty()) {
            System.out.println("No applicants found for name: " + name);
        } else {
            for (ApplicantDetails applicant : applicants) {
                System.out.println(applicant);
            }
        }

        session.close();
        sessionFactory.close();

    }

}
