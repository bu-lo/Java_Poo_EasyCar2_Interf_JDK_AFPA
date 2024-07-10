package com.afpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections; // COLLECTIONS - SORTING ALGO
import java.util.Scanner; //SCANNER


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
        Customer c = new Customer("Lucas","Clavieres","Rue El A.", "Bordeaux", "33000");

        //INTANTIATION RESERVATIONS + LINK VEHICLE-RESERVATION
        Reservation r1 = new Reservation(LocalDate.of(2024,07,03), LocalDate.of(2024,07,22), false, car);
        Reservation r2 = new Reservation(LocalDate.of(2024,07,03), LocalDate.of(2024,07,12), false, truck);
        Reservation r3 = new Reservation(LocalDate.of(2024,07,03), LocalDate.of(2024,07,12), false, bike);
        Reservation r4 = new Reservation(LocalDate.of(2024,07,14), LocalDate.of(2024,07,22), true, truck );

        //LINK BETWEEN CLIENTS-RESERVATION
        a.addReservation(r1);
        a.addReservation(r2);
        b.addReservation(r3);
        c.addReservation(r4);

        System.out.println("-------------------------------------------------------------");

        //TEST TOTALMONEYSPENT
        a.totalMoneySpent();
        b.totalMoneySpent();
        c.totalMoneySpent();

        System.out.println("-------------------------------------------------------------");

        //REMOVE RESERVATION r2 FOR CUSTOMER a
        a.removeReservation(r2);

        System.out.println("-------------------------------------------------------------");

        //TEST TOTALMONEYSPENT
        ArrayList<Customer> customers = new ArrayList();
        customers.add(a);
        customers.add(b);
        customers.add(c);

        Collections.sort(customers); //COLLECTION - SORTING ALGO

        for (Customer customer : customers){
            System.out.println(customer + " - Total Money Spent : \n" + customer.totalMoneySpent());
        }

        System.out.println("-------------------------------------------------------------");

    
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Would you like to use informations about Customers with a saving file ?/n");
        System.out.println("- 1 | Serialization/n");
        System.out.println("- 2 | Deserialization/n");
        System.out.println("- 3 | Esc/n");
        System.out.println("Tap 1, 2 or 3 ?/n");
        int answerSerialization = sc.nextInt();

        sc.close();

        if (answerSerialization == 1){
            //SERIALIZATION
            Serialization.serializationFct(customers);
        }else if(answerSerialization == 2){
            //DESERIALIZATION
            Deserialization.deserializationFct();
        }else{ //answer is 3 or something else
            System.out.println("No actions liked to Serialization selected.");
        }
    }
}
