package com.afpa;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.io.Serializable; // SERIALIZABLE


public class Reservation implements Serializable {

    private static final long serialVersionUID = 42L; //Valid the Java version for SERIAZABLE

    private LocalDate startDate;
    private LocalDate endDate;
    private boolean paid;
    private Vehicle vehicle; //is about only one specific vehicle 
    
    //CONSTRUCTORS

    public Reservation(LocalDate startDate, LocalDate endDate, boolean paid, Vehicle vehicle) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.paid = paid;
        this.vehicle = vehicle;
    }


    //GETTERS & SETTERS

    //START DATE
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    //END DATE
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    //PAID
    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    //VEHICLE
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    //METHODS

    @Override
    public String toString() {
        return "Reservation [startDate=" + startDate + ", endDate=" + endDate + ", paid=" + paid + "]";
    }

   /**
    * TOTALPRICE() : DOUBLE -> total price of a reservation / period
    * @return locationDays*dayPrice
    */
    public double totalPrice(){
        long locationDays = ChronoUnit.DAYS.between(this.startDate, this.endDate);
        double dayPrice = this.vehicle.getPricePerDay();
        return locationDays * dayPrice;
    }

}
