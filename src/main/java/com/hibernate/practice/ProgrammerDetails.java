package com.hibernate.practice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProgrammerDetails {

    private String name;
    private String experience;
    @Id
    private int programmerId;
    private ProgrammingLaptop programmingLaptop;

    @Override
    public String toString() {
        return "ProgrammerDetails{" +
                "name='" + name + '\'' +
                ", experience='" + experience + '\'' +
                ", programmerId=" + programmerId +
                ", programmingLaptop=" + programmingLaptop +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getProgrammerId() {
        return programmerId;
    }

    public void setProgrammerId(int programmerId) {
        this.programmerId = programmerId;
    }

    public ProgrammingLaptop getProgrammingLaptop() {
        return programmingLaptop;
    }

    public void setProgrammingLaptop(ProgrammingLaptop programmingLaptop) {
        this.programmingLaptop = programmingLaptop;
    }
}
