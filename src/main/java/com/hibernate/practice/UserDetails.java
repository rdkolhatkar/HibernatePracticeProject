package com.hibernate.practice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class UserDetails {
    @Id
    private int userId;
    private String userName;

    private String technology;

    @OneToOne
    private UserDeviceDetails userDeviceDetails;

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", technology='" + technology + '\'' +
                ", userDeviceDetails=" + userDeviceDetails +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public UserDeviceDetails getUserDeviceDetails() {
        return userDeviceDetails;
    }

    public void setUserDeviceDetails(UserDeviceDetails userDeviceDetails) {
        this.userDeviceDetails = userDeviceDetails;
    }
}
