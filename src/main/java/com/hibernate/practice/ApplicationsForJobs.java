package com.hibernate.practice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class ApplicationsForJobs {
    @Id
    private int jobId;
    private String jobLocation;
    private String jobType;
    @ManyToMany(mappedBy = "appliedJobs")
    private List<ApplicantDetails> applicants;

    @Override
    public String toString() {
        return "ApplicationsForJobs{" +
                "jobId=" + jobId +
                ", jobLocation='" + jobLocation + '\'' +
                ", jobType='" + jobType + '\'' +
                ", applicants=" + applicants +
                '}';
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public List<ApplicantDetails> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<ApplicantDetails> applicants) {
        this.applicants = applicants;
    }
}
