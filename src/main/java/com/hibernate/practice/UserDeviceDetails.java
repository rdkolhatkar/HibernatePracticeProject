package com.hibernate.practice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserDeviceDetails {
    @Id
    private int deviceId;
    private String deviceName;
    private String deviceType;

    @Override
    public String toString() {
        return "UserDeviceDetails{" +
                "deviceId=" + deviceId +
                ", deviceName='" + deviceName + '\'' +
                ", deviceType='" + deviceType + '\'' +
                '}';
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
