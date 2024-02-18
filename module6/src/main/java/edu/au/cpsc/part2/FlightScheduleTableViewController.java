/**
 * A program with the capability to edit airline flight information.
 * Module 4 Project - TableView Controller file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 02/04/2024
 */

package edu.au.cpsc.part2;

import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class FlightScheduleTableViewController {
    @FXML
    private TableView<ScheduledFlight> flightTableView;

    @FXML
    private TableColumn<ScheduledFlight, String> flightDesignatorColumn, departureAirportColumn,
            arrivalAirportColumn, daysOfWeekColumn;

    public void initialize() {
        flightDesignatorColumn.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("flightDesignator"));
        departureAirportColumn.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("departureAirportIdent"));
        arrivalAirportColumn.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("arrivalAirportIdent"));
        daysOfWeekColumn.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("formatDaysOfWeek"));

        flightTableView.getSelectionModel().selectedItemProperty().addListener(event -> tableSelectionChanged());
    }

    public void showFlights(List<ScheduledFlight> flights) {
        SortedList<ScheduledFlight> sortedList = new SortedList<>(FXCollections.observableList(flights));
        flightTableView.setItems(sortedList);
        sortedList.comparatorProperty().bind(flightTableView.comparatorProperty());
        flightTableView.refresh();
    }

    public void onFlightSelectionChanged(EventHandler<FlightTableEvent> handler) {
        flightTableView.addEventHandler(FlightTableEvent.FLIGHT_SELECTED, handler);
    }

    public void tableSelectionChanged() {
        ScheduledFlight selectedFlight = flightTableView.getSelectionModel().getSelectedItem();
        FlightTableEvent event = new FlightTableEvent(FlightTableEvent.FLIGHT_SELECTED,
                selectedFlight);
        flightTableView.fireEvent(event);
    }

    public void select(ScheduledFlight flight) {

        flightTableView.getSelectionModel().select(flight);
    }

    public static class FlightTableEvent extends Event {
        public static final EventType<FlightTableEvent> ANY = new EventType<>(Event.ANY, "ANY");
        public static final EventType<FlightTableEvent> FLIGHT_SELECTED = new EventType<>(ANY, "FLIGHT_SELECTED");

        public ScheduledFlight selectedFlight;

        public FlightTableEvent(EventType<? extends Event> eventType, ScheduledFlight selectedFlight) {
            super(eventType);
            this.selectedFlight = selectedFlight;
        }

        public ScheduledFlight getSelectedFlight() {
            return selectedFlight;
        }
    }
}
