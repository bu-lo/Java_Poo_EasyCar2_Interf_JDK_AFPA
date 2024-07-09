package com.afpa;

import java.time.LocalDate;
import com.afpa.MotorizedVehicle.FuelType;

public class App 
{
    public static void main( String[] args )
    {
        //INSTANTIATION VEHICLES
        Vehicle car = new Car("BMW","vroum","blue",LocalDate.of(2022,07,03),300,FuelType.ESSENCE,10,true,5);
        Vehicle truck = new Truck("BMW","vroum","red",LocalDate.of(2014,12,24),700, FuelType.DIESEL,10,false,2);
        Vehicle bike = new Bike("SuperBike","ride","pink",LocalDate.of(2022,07,14),20,'S');

        //INSTANTIATION CUSTOMERS
        Customer a = new Customer("Alain", "Clavières", "All. de Pierras", "Auziellecity", "31650");
        Customer b = new Customer("Valérie", "Clavières","All. de Pierras", "Auziellecity", "31650");

        //INTANTIATION RESERVATIONS + LINK VEHICLE-RESERVATION
        Reservation r1 = new Reservation(LocalDate.of(2024,07,03), LocalDate.of(2024,07,22), false, car);
        Reservation r2 = new Reservation(LocalDate.of(2024,07,03), LocalDate.of(2024,07,15), false, truck);
        Reservation r3 = new Reservation(LocalDate.of(2024,07,03), LocalDate.of(2024,07,12), false, bike);

        //LINK BETWEEN CLIENTS-RESERVATION
        a.addReservation(r1);
        a.addReservation(r2);
        b.addReservation(r3);

        System.out.println("-------------------------------------------------------------");

        //TEST TOTALMONEYSPENT
        a.totalMoneySpent();
        b.totalMoneySpent();

        System.out.println("-------------------------------------------------------------");

        //REMOVE RESERVATION r2 FOR CUSTOMER a
        a.removeReservation(r2);

        System.out.println("-------------------------------------------------------------");

        //TEST TOTALMONEYSPENT
        a.totalMoneySpent();
        b.totalMoneySpent();

        System.out.println("-------------------------------------------------------------");

    }
}
