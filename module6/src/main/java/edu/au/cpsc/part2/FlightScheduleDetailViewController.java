/**
 * A program with the capability to modify airline flight information.
 * Module 6 Project - DetailView Controller file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 02/18/2024
 */

package edu.au.cpsc.part2;

import edu.au.cpsc.part2.uimodel.FlightDetailModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class FlightScheduleDetailViewController {

    @FXML
    private TextField flightDesignatorTextField, departureAirportTextField, arrivalAirportTextField;

    private Label validationErrorLabel;

    private FlightDetailModel model;

    public void initialize() {
        model = new FlightDetailModel();
        flightDesignatorTextField.textProperty().bindBidirectional(model.flightDesignatorProperty());
        departureAirportTextField.textProperty().bindBidirectional(model.departureAirportIdentProperty());
        arrivalAirportTextField.textProperty().bindBidirectional(model.arrivalAirportIdentProperty());
    }

    public FlightDetailModel getModel() {
        return model;
    }

    public void showFlight(ScheduledFlight flight) {
        if (flight == null) {
            model.setFlightDesignator("");
            model.setDepartureAirportIdent("");
            model.setArrivalAirportIdent("");
            model.setModified(false);
            model.setNew(true);
            return;
        }

        model.setFlightDesignator(flight.getFlightDesignator());
        model.setDepartureAirportIdent(flight.getDepartureAirportIdent());
        model.setArrivalAirportIdent(flight.getArrivalAirportIdent());
        model.setModified(false);
        model.setNew(false);
    }

    public boolean updateFlight(ScheduledFlight flight) {
        if (!validate()) return false;
        flight.setFlightDesignator(model.getFlightDesignator());
        flight.setDepartureAirportIdent(model.getDepartureAirportIdent());
        flight.setArrivalAirportIdent(model.getArrivalAirportIdent());
        return true;
    }

    public boolean validate() {
        boolean isValid = true;
        isValid = validateFieldNotEmpty(flightDesignatorTextField);
        isValid = validateFieldNotEmpty(departureAirportTextField) && isValid;
        isValid = validateFieldNotEmpty(arrivalAirportTextField) && isValid;
        if (isValid) {
            validationErrorLabel.getStyleClass().add("hidden");
        } else {
            validationErrorLabel.getStyleClass().remove("hidden");
        }
        return isValid;
    }

    public boolean validateFieldNotEmpty(TextField field) {
        if (field.getText().trim().length() == 0) {
            field.getStyleClass().add("error");
            return false;
        } else {
            field.getStyleClass().remove("error");
        }
        return true;
    }

    @FXML
    protected void flightDesignatorKeyTyped() {
        validateFieldNotEmpty(flightDesignatorTextField);
    }

    @FXML
    protected void departureAirportKeyTyped() {
        validateFieldNotEmpty(departureAirportTextField);
    }

    @FXML
    protected void arrivalAirportKeyTyped() {
        validateFieldNotEmpty(arrivalAirportTextField);
    }
}