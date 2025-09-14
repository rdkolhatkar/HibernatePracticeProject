package com.hibernate.practice;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ApplicantDetails {
    @Id
    private int ApplicantId;
    private String ApplicantName;
    private String ApplicantAddress;
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
                "ApplicantId=" + ApplicantId +
                ", ApplicantName='" + ApplicantName + '\'' +
                ", ApplicantAddress='" + ApplicantAddress + '\'' +
                ", appliedJobs=" + appliedJobs +
                '}';
    }

    public int getApplicantId() {
        return ApplicantId;
    }

    public void setApplicantId(int applicantId) {
        ApplicantId = applicantId;
    }

    public String getApplicantName() {
        return ApplicantName;
    }

    public void setApplicantName(String applicantName) {
        ApplicantName = applicantName;
    }

    public String getApplicantAddress() {
        return ApplicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        ApplicantAddress = applicantAddress;
    }

    public List<ApplicationsForJobs> getAppliedJobs() {
        return appliedJobs;
    }

    public void setAppliedJobs(List<ApplicationsForJobs> appliedJobs) {
        this.appliedJobs = appliedJobs;
    }
}
