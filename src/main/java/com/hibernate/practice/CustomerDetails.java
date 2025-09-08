package com.hibernate.practice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class CustomerDetails {
    @Id
    private int CustomerId;
    private String CustomerName;
    private String CustomerAddress;
    @OneToMany(mappedBy = "customerDetails")
    private List<CustomerAppliances> AppliancesPurchased;


    @Override
    public String toString() {
        return "CustomerDetails{" +
                "CustomerId=" + CustomerId +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerAddress='" + CustomerAddress + '\'' +
                ", AppliancesPurchased=" + AppliancesPurchased +
                '}';
    }

    public List<CustomerAppliances> getAppliancesPurchased() {
        return AppliancesPurchased;
    }

    public void setAppliancesPurchased(List<CustomerAppliances> appliancesPurchased) {
        AppliancesPurchased = appliancesPurchased;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

}
