/**
 * A program with the capability to modify airline flight information.
 * Module 6 Project - Controller file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 02/18/2024
 */

package edu.au.cpsc.part2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import edu.au.cpsc.part2.uimodel.FlightDetailModel;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.MenuItem;

public class FlightScheduleApplicationController {

    @FXML
    private Parent applicationRoot;

    @FXML
    private FlightScheduleTableViewController flightScheduleTableViewController;

    @FXML
    private FlightScheduleDetailViewController flightScheduleDetailViewController;

    @FXML
    private Button updateButton, newButton, deleteButton;

    @FXML
    private MenuItem updateMenuItem, newMenuItem, deleteMenuItem;

    public void initialize() {
        flightScheduleTableViewController.showFlights(Db.getDatabase().getScheduledFlights());
        flightScheduleTableViewController.onFlightSelectionChanged(
                event -> showFlight(event.getSelectedFlight()));
        FlightDetailModel uiModel = flightScheduleDetailViewController.getModel();
        bindButtonMenuEnable(uiModel);
        bindButtonMenuLabel(uiModel);
        showFlight(null);
    }
    private void bindButtonMenuEnable(FlightDetailModel uiModel) {
        updateButton.disabledProperty().bind(uiModel.modifiedProperty().not());
        updateMenuItem.disableProperty().bind(uiModel.modifiedProperty().not());
        newButton.disabledProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
        newMenuItem.disableProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
        deleteButton.disabledProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
    }

    private void showFlight(ScheduledFlight flight) {
        flightScheduleDetailViewController.showFlight(flight);
    }

    @FXML
    protected void updateButtonAction() {
        if (flightScheduleDetailViewController.getModel().isNew()) {
            addScheduledFlight();
        } else {
            updateScheduledFlight();
        }
    }

    private void addScheduledFlight() {
        ScheduledFlight flight = new ScheduledFlight("", "", "");
        if (!flightScheduleDetailViewController.updateFlight(flight)) {
            return;
        }
        Db.getDatabase().addScheduledFlight(flight);
        saveDatabaseAndUpdateTable(flight);
    }

    private void updateScheduledFlight() {
        ScheduledFlight flight = getScheduledFlightBeingEdited();
        if (!flightScheduleDetailViewController.updateFlight(flight)) {
            return;
        }
        Db.getDatabase().updateScheduledFlight(flight);
        saveDatabaseAndUpdateTable(flight);
    }

    private void saveDatabaseAndUpdateTable(ScheduledFlight flight) {
        Db.saveDatabase();
        flightScheduleTableViewController.showFlights(Db.getDatabase().getScheduledFlights());
        flightScheduleTableViewController.select(flight);
    }

    @FXML
    protected void newButtonAction() {
        flightScheduleTableViewController.select(null);
    }

    @FXML
    protected void deleteButtonAction() {
        if (flightScheduleDetailViewController.getModel().isNew()) {
            flightScheduleTableViewController.select(null);
        } else {
            Db.getDatabase().removeScheduledFlight(getScheduledFlightBeingEdited());
            Db.saveDatabase();
            flightScheduleTableViewController.showFlights(Db.getDatabase().getScheduledFlights());
        }
    }

    @FXML
    protected void updateMenuAction() {
        updateButtonAction();
    }

    @FXML
    protected void newMenuAction() {
        newButtonAction();
    }

    @FXML
    protected void deleteMenuAction() {
        deleteButtonAction();
    }

    @FXML
    protected void closeMenuAction() {
        Platform.exit();
    }

    public ScheduledFlight getScheduledFlightBeingEdited() {
        return flightScheduleTableViewController.getSelectedFlight();
    }
}