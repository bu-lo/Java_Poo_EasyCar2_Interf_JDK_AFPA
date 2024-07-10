package com.afpa;

import java.util.ArrayList;
import java.io.Serializable; // SERIALIZABLE

public class Customer implements Comparable<Customer>, Serializable{  // IMPLEMENTS COMPARABLE + SERIALIZABLE
   
    private static final long serialVersionUID = 42L; //Valid the Java version for SERIAZABLE
    
   
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String postalCode;
    private transient ArrayList<Reservation> reservations = new ArrayList<Reservation>();
   
    //CONSTRUCTORS
    public Customer(String firstName, String lastName, String address, String city, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
    }

    //GETTERS & SETTERS
    //FIRSTNAME
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //LASTNAME
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //ADDRESS
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //CITY
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //POSTAL CODE
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    //METHODS
    @Override
    public String toString() {
        return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
                + ", postalCode=" + postalCode + "]";
    }
  
    /**
     * totalMoneySpent()
     * by a Customer
     * @return total
     */
    
    public double totalMoneySpent(){
        double total = 0.0;
        for (Reservation reservation : reservations){
            total += reservation.totalPrice();
        }
        System.out.println(this.firstName + " " + this.lastName + " spent " + total + "euros.");
        return total;
    }

    /**
     * addReservation()
     * if not contains + reservation
     * @param reservation
     */

    public void addReservation (Reservation reservation){
        if (!reservations.contains(reservation)){     //CONTAINS()
            reservations.add(reservation);
            System.out.println("The reservation : " + reservation + " has been added for the customer :" + this.firstName + " " + this.lastName + ".");
        } else {
            System.out.println("The reservation : " + reservation + " already exits for the customer :" + this.firstName + " " + this.lastName + ".");
        }
    }

    /**
     * removeReservation()
     * -> the reservation exists ?
     * -> if yes it removes it
     * @param reservation
     * @return true/false
     */
    public boolean removeReservation (Reservation reservation){
        //Verification: does the reservation exist ?
        if (reservations.contains(reservation)){     //CONTAINS()
            System.out.println("The reservation : " + reservation + " has been deleted for the customer :" + this.firstName + " " + this.lastName + ".");
            reservations.remove(reservation);
            return true;
        } else {
            System.out.println("The reservation : " + reservation + " was not found for the customer :" + this.firstName + " " + this.lastName + ".");
            return false;
        }
    }

    /**
     * Compare .totalMoneySpent() // All customers
     * @param other
     * @return double .totalMoneySpent()
     */
    @Override
    public int compareTo(Customer other){
        return Double.compare(this.totalMoneySpent(),other.totalMoneySpent());
    }

}