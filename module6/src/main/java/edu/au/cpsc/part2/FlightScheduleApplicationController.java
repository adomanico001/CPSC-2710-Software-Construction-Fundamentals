/**
 * A program with the capability to modify airline flight information.
 * Module 6 Project - Controller file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 02/18/2024
 */

package edu.au.cpsc.part2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    private ObservableList<ScheduledFlight> flightList = FXCollections.observableArrayList();


    public void initialize() {
        flightScheduleTableViewController.showFlights(Db.getDatabase().getScheduledFlights());
        flightScheduleTableViewController.onFlightSelectionChanged(
                event -> showFlight(event.getSelectedFlight()));
        FlightDetailModel uiModel = flightScheduleDetailViewController.getModel();
        bindButtonMenuEnable(uiModel);
        bindButtonMenuLabel(uiModel);
        showFlight(null);
    }

    private void bindButtonMenuLabel(FlightDetailModel uiModel) {
        StringBinding labelProperty = Bindings.when(uiModel.newProperty()).then("Add").otherwise("Update");
        updateButton.textProperty().bind(labelProperty);
        updateMenuItem.textProperty().bind(labelProperty);
    }

    private void bindButtonMenuEnable(FlightDetailModel uiModel) {
        updateButton.disableProperty().bind(uiModel.modifiedProperty().not());
        updateMenuItem.disableProperty().bind(uiModel.modifiedProperty().not());
        newButton.disableProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
        newMenuItem.disableProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
        deleteButton.disableProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
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
        ScheduledFlight flight = new ScheduledFlight("flightDesignator", "departureFlightIdent",
                "arrivalFlightIdent");
        if (!flightScheduleDetailViewController.updateFlight(flight)) {
            return;
        }

        // Add new flight to the list
        flightList.add(flight);

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

    @FXML
    protected void appearanceMenuAction() {
        ChoiceDialog<String> choiceDialog = new ChoiceDialog<>("Light", "Dark", "Light");
        choiceDialog.showAndWait().ifPresent(selection -> setTheme(selection));
    }

    private void setTheme(String selection) {
        String darkThemeUrl = getClass().getResource("/edu/au/cpsc/style/dark.css").toExternalForm();
        String lightThemeUrl = getClass().getResource("/edu/au/cpsc/style/light.css").toExternalForm();
        if (selection.equals("Dark")) {
            applicationRoot.getStylesheets().add(darkThemeUrl);
            applicationRoot.getStylesheets().remove(lightThemeUrl);
        } else {
            applicationRoot.getStylesheets().add(lightThemeUrl);
            applicationRoot.getStylesheets().remove(darkThemeUrl);
        }
    }

    public ScheduledFlight getScheduledFlightBeingEdited() {
        return flightScheduleTableViewController.getSelectedFlight();
    }
}