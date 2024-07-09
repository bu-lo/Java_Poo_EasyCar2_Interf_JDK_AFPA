package com.afpa;

import java.time.LocalDate;

public class Bike extends Vehicle {
    private char size;


    //CONSTRUCTORS
    public Bike(String brand, String model, String color, LocalDate buyingDate, double pricePerDay, char size){
        super(brand, model, color, buyingDate, pricePerDay);
        this.size = size;
    }


    //GETTERS & SETTERS

    //SIZE
    public char getSize() {
        return size;
    }


    public void setSize(char size) {
        this.size = size;
    }


    @Override
    public String toString() {
        return "Bike [size=" + size + ", getBrand()=" + getBrand() + ", getModel()=" + getModel() + ", getColor()="
                + getColor() + ", getBuyingDate()=" + getBuyingDate() + ", getPricePerDay()=" + getPricePerDay() + "]";
    }
}
