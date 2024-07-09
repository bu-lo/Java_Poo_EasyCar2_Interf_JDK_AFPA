package com.afpa;

import java.time.LocalDate;

public class Car extends MotorizedVehicle {
    private int seats;

    //CONSTRUCTORS
    public Car(String brand, String model, String color, LocalDate buyingDate, double pricePerDay,
    FuelType fuelType, int fuelConsumption, boolean integratedGPS, int seats){
        super(brand, model, color, buyingDate, pricePerDay, fuelType, fuelConsumption, integratedGPS);
        this.seats = seats;
    }

    //GETTERS & SETTERS

    //SEATS
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Car [Seats=" + seats + ", GetBrand()=" + getBrand() + ", GetModel()="
                + getModel() + ", GetFuelType()=" + getFuelType() + ", GetColor()=" + getColor()
                + ", GetFuelConsumption()=" + getFuelConsumption() + ", GetBuyingDate()=" + getBuyingDate()
                + ", IsIntegratedGPS()=" + isIntegratedGPS() + ", GetPricePerDay()=" + getPricePerDay()
                + "]";
    }
}
