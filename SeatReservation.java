<<<<<<< HEAD
/**
 * A program for an airline reservation management system.
 * Module 1 - Assignment 1, part 1
=======

/**
 * A program for an airline reservation management system.
 * Module 1 - Assignment 1
>>>>>>> 03e57147f642965c0e74606d100f7cd96e4bb51b
 * 
 * @author - Addie Domanico - CPSC 2710 - AO1
 * @version - 01/12/2024
 */

<<<<<<< HEAD
 import java.time.LocalDate;

public class SeatReservation {
    private String flightDesignator;
    private LocalDate flightDate;
    private String firstName;
    private String lastName;

=======
import java.time.LocalDate;

public class SeatReservation {
    // Instance variables
    private String flightDesignator;
    private java.time.LocalDate flightDate;
    private String firstName;
    private String lastName;

    // Getters and setters
>>>>>>> 03e57147f642965c0e74606d100f7cd96e4bb51b
    public String getFlightDesignator() {
        return flightDesignator;
    }

<<<<<<< HEAD
    public void setFlightDesignator(String fd) {
        this.flightDesignator = fd;
=======
    public void setFlightDesignator(String flightDesignator) {
        if (flightDesignator == null) {
            throw new IllegalArgumentException("flight designator cannot be null");
        }

        if (flightDesignator.length() < 4 || flightDesignator.length() > 6) {
            throw new IllegalArgumentException("Flight designator must be 4-6 characters");
        }

        this.flightDesignator = flightDesignator;
>>>>>>> 03e57147f642965c0e74606d100f7cd96e4bb51b
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

    public String toString() {
<<<<<<< HEAD
        return "SeatReservation{" + "flightDesignator=" + flightDesignator + ", flightDate=" +
            flightDate + ", firstName=" + (firstName != null ? "\"" + firstName + "\"" : "null") +
            ", lastName=" + (lastName != null ? "\"" + lastName + "\"" : "null") + '}';
    }
}
=======
        return String.format("SeatReservation{flightDesignator=%s, flightDate=%s, firstName=%s, lastName=%s}",
                flightDesignator, flightDate, firstName != null ? "\"" + firstName + "\"" : "null",
                lastName != null ? "\"" + lastName + "\"" : "null");
    }

 }

    
>>>>>>> 03e57147f642965c0e74606d100f7cd96e4bb51b
