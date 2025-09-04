package com.hibernate.practice;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProgrammingLaptop {
    // In this case we don't want to create new table in the database for ProgrammingLaptop details
    // So we are not using @Entity annotation here, because @Entity annotation is used to create new table in the database
    // We will use this class as a component in the ProgrammerDetails class
    // We want to embed this class in the ProgrammerDetails Table in the database
    // We want programming laptop details to be part of the programmer details table in the form of different fields
    // @Embeddable annotation is used to embed this class in the ProgrammerDetails class
    private String Processor;
    private String RAM;
    private String Storage;
    private String Display;

    @Override
    public String toString() {
        return "ProgrammingLaptop{" +
                "Processor='" + Processor + '\'' +
                ", RAM='" + RAM + '\'' +
                ", Storage='" + Storage + '\'' +
                ", Display='" + Display + '\'' +
                '}';
    }

    public String getProcessor() {
        return Processor;
    }

    public void setProcessor(String processor) {
        Processor = processor;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getStorage() {
        return Storage;
    }

    public void setStorage(String storage) {
        Storage = storage;
    }

    public String getDisplay() {
        return Display;
    }

    public void setDisplay(String display) {
        Display = display;
    }
}
