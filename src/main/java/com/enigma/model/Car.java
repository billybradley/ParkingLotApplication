package com.enigma.model;

public class Car {
    private String licensePlate;
//    private String color;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Car() {
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }

    @Override
    public String toString() {
        return licensePlate ;
    }
}
