package com.hibernate.practice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CustomerAppliances {
    @Id
    private int ApplianceId;
    private String ApplianceName;
    private String ApplianceType;
    private double AppliancePrice;
    @ManyToOne
    private CustomerDetails customerDetails;

    @Override
    public String toString() {
        return "CustomerAppliances{" +
                "ApplianceId=" + ApplianceId +
                ", ApplianceName='" + ApplianceName + '\'' +
                ", ApplianceType='" + ApplianceType + '\'' +
                ", AppliancePrice=" + AppliancePrice +
                '}';
    }

    public int getApplianceId() {
        return ApplianceId;
    }

    public void setApplianceId(int applianceId) {
        ApplianceId = applianceId;
    }

    public String getApplianceName() {
        return ApplianceName;
    }

    public void setApplianceName(String applianceName) {
        ApplianceName = applianceName;
    }

    public String getApplianceType() {
        return ApplianceType;
    }

    public void setApplianceType(String applianceType) {
        ApplianceType = applianceType;
    }

    public double getAppliancePrice() {
        return AppliancePrice;
    }

    public void setAppliancePrice(double appliancePrice) {
        AppliancePrice = appliancePrice;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }
}
