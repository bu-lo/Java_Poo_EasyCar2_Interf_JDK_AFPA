package com.afpa;

import java.time.LocalDate;

public abstract class MotorizedVehicle extends Vehicle {
    public enum FuelType {
        ESSENCE, DIESEL, ELECTRIC
    };

    private FuelType fuelType;
    private int fuelConsumption;
    private boolean integratedGPS;

    // CONSTRUCTORS
    public MotorizedVehicle(String brand, String model, String color, LocalDate buyingDate, double pricePerDay,
            FuelType fuelType, int fuelConsumption, boolean integratedGPS) {
        super(brand, model, color, buyingDate, pricePerDay);
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.integratedGPS = integratedGPS;
    }

    // GETTERS & SETTERS

    //FUELTYPE
    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    //FUELCONSUMPTION
    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    //INTEGRATED GPS
    public boolean isIntegratedGPS() {
        return integratedGPS;
    }

    public void setIntegratedGPS(boolean integratedGPS) {
        this.integratedGPS = integratedGPS;
    }

}
