<<<<<<< HEAD

/**
 * A program for an airline reservation management system.
 * Module 1 - Assignment 1
 * 
 * @author - Addie Domanico - CPSC 2710 - AO1
 * @version - 01/12/2024
 */
=======
// @author: Addie Domanico - CPSC 2710 - AO1
// @version: 01/22/2024
// Module 2 Assignment

package edu.au.cpsc.demo;
>>>>>>> module2

import java.time.LocalDate;

public class SeatReservation {
    // Instance variables
    private String flightDesignator;
    private java.time.LocalDate flightDate;
    private String firstName;
    private String lastName;
<<<<<<< HEAD

    // Getters and setters
    public String getFlightDesignator() {
=======
    private int numberOfBags;
    private boolean flyingWithInfant;

    // Getters and setters
    public String getFlightDesignator() {

>>>>>>> module2
        return flightDesignator;
    }

    public void setFlightDesignator(String flightDesignator) {
        if (flightDesignator == null) {
<<<<<<< HEAD
            throw new IllegalArgumentException("flight designator cannot be null");
        }

        if (flightDesignator.length() < 4 || flightDesignator.length() > 6) {
            throw new IllegalArgumentException("Flight designator must be 4-6 characters");
        }

=======
            throw new IllegalArgumentException("Flight designator cannot be null");
        }
        if (flightDesignator.length() < 4 || flightDesignator.length() > 6) {
            throw new IllegalArgumentException("Flight designator must be 4-6 characters");
        }
>>>>>>> module2
        this.flightDesignator = flightDesignator;
    }

    public LocalDate getFlightDate() {
<<<<<<< HEAD
=======

>>>>>>> module2
        return flightDate;
    }

    public void setFlightDate(LocalDate date) {
<<<<<<< HEAD
=======

>>>>>>> module2
        this.flightDate = date;
    }

    public String getFirstName() {
<<<<<<< HEAD
=======

>>>>>>> module2
        return firstName;
    }

    public void setFirstName(String fn) {
<<<<<<< HEAD
=======

>>>>>>> module2
        this.firstName = fn;
    }

    public String getLastName() {
<<<<<<< HEAD
=======

>>>>>>> module2
        return lastName;
    }

    public void setLastName(String ln) {
<<<<<<< HEAD
        this.lastName = ln;
    }

    public String toString() {
        return String.format("SeatReservation{flightDesignator=%s, flightDate=%s, firstName=%s, lastName=%s}",
                flightDesignator, flightDate, firstName != null ? "\"" + firstName + "\"" : "null",
                lastName != null ? "\"" + lastName + "\"" : "null");
    }

}

    
=======

        this.lastName = ln;
    }

    public int getNumberOfBags() {

        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {

        this.numberOfBags = numberOfBags;
    }

    public boolean isFlyingWithInfant() {

        return flyingWithInfant;
    }

    public void makeFlyingWithInfant() {

        this.flyingWithInfant = true;
    }

    public void makeNotFlyingWithInfant() {

        this.flyingWithInfant = false;
    }

    public String toString() {
        return String.format("SeatReservation{flightDesignator=%s, flightDate=%s, firstName=%s, lastName=%s, numberOfBags=%d, flyingWithInfant=%b}",
                flightDesignator, flightDate, firstName != null ? "\"" + firstName + "\"" : "null",
                lastName != null ? "\"" + lastName + "\"" : "null", numberOfBags, flyingWithInfant);
    }
}

>>>>>>> module2
