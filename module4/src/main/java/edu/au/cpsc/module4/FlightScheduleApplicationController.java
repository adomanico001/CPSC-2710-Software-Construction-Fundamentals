/**
 * A program with the capability to edit airline flight information.
 * Module 4 Project - Application Controller file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 02/04/2024
 */

package edu.au.cpsc.module4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FlightScheduleApplicationController {
    @FXML
    private FlightScheduleTableViewController flightScheduleTableViewController;

    @FXML
    private FlightScheduleDetailViewController flightScheduleDetailViewController;

    @FXML
    private Button updateButton;

    private ScheduledFlight flightEdited;
    private boolean flightEditedIsNew;

    public void initialize() {
        flightScheduleTableViewController.showFlights(Db.getDatabase().getScheduledFlights());
        flightScheduleTableViewController.onFlightSelectionChanged(
                event -> showFlight(event.getSelectedFlight()));
        showFlight(null);
    }

    private void showFlight(ScheduledFlight flight) {
        flightScheduleDetailViewController.showFlight(flight);
        flightEdited = flight == null ? new ScheduledFlight() : flight;
        flightEditedIsNew = flight == null;
        String buttonLabel = flightEditedIsNew ? "Add" : "Update";
        updateButton.setText(buttonLabel);
    }

    @FXML
    protected void updateButtonAction() {
        flightScheduleDetailViewController.updateFlight(flightEdited);
        if (flightEditedIsNew) {
            Db.getDatabase().addScheduledFlight(flightEdited);
        } else {
            Db.getDatabase().updateScheduledFlight(flightEdited);
        }
        Db.saveDatabase();
        flightScheduleTableViewController.showFlights(Db.getDatabase().getScheduledFlights());
        flightScheduleTableViewController.select(flightEdited);
    }

    @FXML
    protected void newButtonAction() {
        flightScheduleTableViewController.select(null);
    }

    @FXML
    protected void deleteButtonAction() {
        if (flightEditedIsNew) {
            flightScheduleTableViewController.select(null);
        } else {
            Db.getDatabase().removeScheduledFlight(flightEdited);
            Db.saveDatabase();
            flightScheduleTableViewController.showFlights(Db.getDatabase().getScheduledFlights());
        }
    }
}