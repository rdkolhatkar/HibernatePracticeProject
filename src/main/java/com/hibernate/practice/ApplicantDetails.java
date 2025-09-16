package com.hibernate.practice;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Cacheable // Enable second-level caching for this entity
public class ApplicantDetails {
    @Id
    private int applicantId;
    private String applicantName;
    private String applicantAddress;
    @ManyToMany
    @JoinTable(
            name = "applicant_jobs",
            joinColumns = @JoinColumn(name = "applicant_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private List<ApplicationsForJobs> appliedJobs;

    @Override
    public String toString() {
        return "ApplicantDetails{" +
                "applicantId=" + applicantId +
                ", applicantName='" + applicantName + '\'' +
                ", applicantAddress='" + applicantAddress + '\'' +
                ", appliedJobs=" + appliedJobs +
                '}';
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    public List<ApplicationsForJobs> getAppliedJobs() {
        return appliedJobs;
    }

    public void setAppliedJobs(List<ApplicationsForJobs> appliedJobs) {
        this.appliedJobs = appliedJobs;
    }
}
