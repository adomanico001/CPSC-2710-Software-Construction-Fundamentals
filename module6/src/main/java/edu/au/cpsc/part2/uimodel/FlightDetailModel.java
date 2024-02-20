/**
 * A program with the capability to modify airline flight information.
 * Module 6 Project - UI Model file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 02/18/2024
 */

package edu.au.cpsc.part2.uimodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FlightDetailModel {

    private final StringProperty flightDesignatorProperty;
    private final StringProperty departureAirportIdentProperty;
    private final StringProperty arrivalAirportIdentProperty;
    private final BooleanProperty modifiedProperty;
    private final BooleanProperty newProperty;

    public FlightDetailModel() {
        flightDesignatorProperty = new SimpleStringProperty();
        departureAirportIdentProperty = new SimpleStringProperty();
        arrivalAirportIdentProperty = new SimpleStringProperty();
        modifiedProperty = new SimpleBooleanProperty();
        newProperty = new SimpleBooleanProperty();
        flightDesignatorProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
        departureAirportIdentProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
        arrivalAirportIdentProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
    }

    public StringProperty flightDesignatorProperty() {
        return flightDesignatorProperty;
    }

    public StringProperty departureAirportIdentProperty() {
        return departureAirportIdentProperty;
    }

    public StringProperty arrivalAirportIdentProperty() {
        return arrivalAirportIdentProperty;
    }

    public BooleanProperty modifiedProperty() {
        return modifiedProperty;
    }

    public BooleanProperty newProperty() {
        return newProperty;
    }

    public String getFlightDesignator() {
        return flightDesignatorProperty.get();
    }

    public void setFlightDesignator(String flightDesignator) {
        flightDesignatorProperty.set(flightDesignator);
    }

    public String getDepartureAirportIdent() {
        return departureAirportIdentProperty.get();
    }

    public void setDepartureAirportIdent(String departureAirportIdent) {
        departureAirportIdentProperty.set(departureAirportIdent);
    }

    public String getArrivalAirportIdent() {
        return arrivalAirportIdentProperty.get();
    }

    public void setArrivalAirportIdent(String arrivalAirportIdent) {
        arrivalAirportIdentProperty.set(arrivalAirportIdent);
    }

    public boolean isModified() {
        return modifiedProperty.get();
    }

    public void setModified(boolean m) {
        modifiedProperty.set(m);
    }

    public boolean isNew() {
        return newProperty.get();
    }

    public void setNew(boolean n) {
        newProperty.set(n);
    }
}
