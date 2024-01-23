// @author: Addie Domanico - CPSC 2710 - AO1
// @version: 01/22/2024
// Module 2 Assignment

package edu.au.cpsc.demo;

import java.time.LocalDate;

public class SeatReservation {
    // Instance variables
    private String flightDesignator;
    private java.time.LocalDate flightDate;
    private String firstName;
    private String lastName;
    private int numberOfBags;
    private boolean flyingWithInfant;

    // Getters and setters
    public String getFlightDesignator() {

        return flightDesignator;
    }

    public void setFlightDesignator(String flightDesignator) {
        if (flightDesignator == null) {
            throw new IllegalArgumentException("Flight designator cannot be null");
        }
        if (flightDesignator.length() < 4 || flightDesignator.length() > 6) {
            throw new IllegalArgumentException("Flight designator must be 4-6 characters");
        }
        this.flightDesignator = flightDesignator;
    }

    public LocalDate getFlightDate() {

        return flightDate;
    }

    public void setFlightDate(LocalDate date) {

        this.flightDate = date;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String fn) {

        this.firstName = fn;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String ln) {

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

