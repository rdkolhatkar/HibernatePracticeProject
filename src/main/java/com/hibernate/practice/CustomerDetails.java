package com.hibernate.practice;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class CustomerDetails {
    @Id
    private int CustomerId;
    private String CustomerName;
    private String CustomerAddress;
    @OneToMany(fetch = FetchType.EAGER)// EAGER Fetching means whenever we will fetch CustomerDetails entity it will also fetch all the AppliancesPurchased entities related to that particular CustomerDetails entity
    private List<CustomerAppliances> AppliancesPurchased; // Whenever we have to use collection in Entity class Hibernate will by default use Lazy Loading / Lazy Fetching

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
