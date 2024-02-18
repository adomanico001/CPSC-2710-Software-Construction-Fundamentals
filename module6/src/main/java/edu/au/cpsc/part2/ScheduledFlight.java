/**
 * A program with the capability to edit airline flight information.
 * Module 4 Project
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 02/04/2024
 */

package edu.au.cpsc.part2;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;

public class ScheduledFlight implements Serializable {
    // Instance variables
    private String flightDesignator;
    private String departureAirportIdent;
    private java.time.LocalTime departureTime;
    private String arrivalAirportIdent;
    private java.time.LocalTime arrivalTime;
    private HashSet<DayOfWeek> daysOfWeek;
    private String formatDaysOfWeek;

    /**
    // Utility method for testing purposes - generates list of demo ScheduledFlight objects
    public static List<ScheduledFlight> demoScheduledFlights() {
        HashSet<String> daysOfWeekDemoSet = new HashSet<>() {{ add("M"); add("T"); add("W"); }};
        return List.of(new ScheduledFlight("DL2222", "ATL", LocalTime.NOON,
                "PHL", LocalTime.of(2, 30), daysOfWeekDemoSet));
    }
     */

    // Constructor
    public ScheduledFlight() {
        flightDesignator = "";
        departureAirportIdent = "";
        departureTime = java.time.LocalTime.now();
        arrivalAirportIdent = "";
        arrivalTime = java.time.LocalTime.now();
        daysOfWeek = new HashSet<DayOfWeek>();
        formatDaysOfWeek = "";
    }

    // Getters and setters
    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDesignator(String flightDesignator) {
        if (flightDesignator == null) {
            throw new IllegalArgumentException("The flight designator is null.");
        }
        this.flightDesignator = flightDesignator;
    }

    public String getDepartureAirportIdent() {
        return departureAirportIdent;
    }

    public void setDepartureAirportIdent(String departureAirportIdent) {
        if (departureAirportIdent == null) {
            throw new IllegalArgumentException("The departure airport identity is null.");
        }
        this.departureAirportIdent = departureAirportIdent;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        if (departureTime == null) {
            throw new IllegalArgumentException("The departure time is null.");
        }
        this.departureTime = departureTime;
    }

    public String getArrivalAirportIdent() {
        return arrivalAirportIdent;
    }

    public void setArrivalAirportIdent(String arrivalAirportIdent) {
        if (arrivalAirportIdent == null) {
            throw new IllegalArgumentException("The arrival airport identity is null.");
        }
        this.arrivalAirportIdent = arrivalAirportIdent;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        if (arrivalTime == null) {
            throw new IllegalArgumentException("The arrival time is null.");
        }
        this.arrivalTime = arrivalTime;
    }

    public void setDaysOfWeek(HashSet<DayOfWeek> daysOfWeek) {
        if (daysOfWeek == null) {
            throw new IllegalArgumentException("Days of Week HashSet is null.");
        }
        this.daysOfWeek = daysOfWeek;
        updateFormatDaysOfWeek();
    }

    public HashSet<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    /**
     * Returns a string representation of the ScheduledFlight object.
     * @return A string representation of the Scheduled Flight
     */
    @Override
    public String toString() {
        return "Scheduled Flight{" + "flightDesignator='" + flightDesignator + '\'' +
                ", departureAirportIdent='" + departureAirportIdent + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalAirportIdent='" + arrivalAirportIdent + '\'' +
                ", arrivalTime=" + arrivalTime + ", daysOfWeeks=" + daysOfWeek + '}';
    }

    public String getFormatDaysOfWeek() {
        return formatDaysOfWeek;
    }

    private void updateFormatDaysOfWeek() {
        formatDaysOfWeek = "";
        if (daysOfWeek.contains(DayOfWeek.SUNDAY)) formatDaysOfWeek += "U";
        if (daysOfWeek.contains(DayOfWeek.MONDAY)) formatDaysOfWeek += "M";
        if (daysOfWeek.contains(DayOfWeek.TUESDAY)) formatDaysOfWeek += "T";
        if (daysOfWeek.contains(DayOfWeek.WEDNESDAY)) formatDaysOfWeek += "W";
        if (daysOfWeek.contains(DayOfWeek.THURSDAY)) formatDaysOfWeek += "R";
        if (daysOfWeek.contains(DayOfWeek.FRIDAY)) formatDaysOfWeek += "F";
        if (daysOfWeek.contains(DayOfWeek.SATURDAY)) formatDaysOfWeek += "S";
    }

    /**
     * Checks if current object is equal to another object.
     * @param o - the object to be compared for equality
     * @return - true if objects are determined equal, false if otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ScheduledFlight scheduledFlight)) {
            return false;
        }

        if(!Objects.equals(flightDesignator, scheduledFlight.flightDesignator)) {
            return false;
        }

        if(!Objects.equals(departureAirportIdent, scheduledFlight.departureAirportIdent)) {
            return false;
        }

        if(!Objects.equals(departureTime, scheduledFlight.departureTime)) {
            return false;
        }

        if(!Objects.equals(arrivalAirportIdent, scheduledFlight.arrivalAirportIdent)) {
            return false;
        }
        if(!Objects.equals(arrivalTime, scheduledFlight.arrivalTime)) {
            return false;
        }

        return !Objects.equals(daysOfWeek, scheduledFlight.daysOfWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightDesignator, departureAirportIdent, departureTime, arrivalAirportIdent, arrivalTime, daysOfWeek);
    }
}

