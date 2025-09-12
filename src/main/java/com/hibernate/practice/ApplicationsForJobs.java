package com.hibernate.practice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class ApplicationsForJobs {
    @Id
    private int JobId;
    private String JobLocation;
    private String JobType;
    @ManyToMany(mappedBy = "appliedJobs")
    private List<ApplicantDetails> applicants;

    @Override
    public String toString() {
        return "ApplicationsForJobs{" +
                "JobId=" + JobId +
                ", JobLocation='" + JobLocation + '\'' +
                ", JobType='" + JobType + '\'' +
                ", applicants=" + applicants +
                '}';
    }

    public int getJobId() {
        return JobId;
    }

    public void setJobId(int jobId) {
        JobId = jobId;
    }

    public String getJobLocation() {
        return JobLocation;
    }

    public void setJobLocation(String jobLocation) {
        JobLocation = jobLocation;
    }

    public String getJobType() {
        return JobType;
    }

    public void setJobType(String jobType) {
        JobType = jobType;
    }

    public List<ApplicantDetails> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<ApplicantDetails> applicants) {
        this.applicants = applicants;
    }
}
