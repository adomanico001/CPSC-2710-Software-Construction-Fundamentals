<<<<<<< HEAD
package edu.au.cpsc.module2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
=======
// @author: Addie Domanico - CPSC 2710 - AO1
// @version: 01/22/2024
// Module 2 Assignment

package edu.au.cpsc.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.time.LocalDate;

public class SeatReservationApplication extends Application {
    private SeatReservation seatReservation;
    private TextField numberOfPassengersTextField = new TextField();
    private TextField flightDesignatorTextField;
    private DatePicker flightDatePicker;
    private TextField firstNameTextField;
    private TextField lastNameTextField;
    private CheckBox flyingWithInfantCheckBox;

    public static void main(String[] args) {
        launch(args);
    }

    private static void handle(ActionEvent e) {
        System.out.println("Cancel clicked");
        Platform.exit();
    }

    @Override
    public void start(Stage stage) {
        seatReservation = new SeatReservation();

        stage.setTitle("Seat Reservation Editor");

        // Creating controls for instance variables
        flightDesignatorTextField = new TextField();
        flightDatePicker = new DatePicker();
        firstNameTextField = new TextField();
        lastNameTextField = new TextField();
        TextField numberOfBagsTextField = new TextField();
       flyingWithInfantCheckBox = new CheckBox();
        TextField numberOfPassengersTextField = new TextField("1");
        numberOfPassengersTextField.setEditable(false);

        Button cancelButton = new Button("Cancel");
        Button saveButton = new Button("Save");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        gridPane.add(new Label("Flight designator:"), 0, 0);
        gridPane.add(flightDesignatorTextField, 1, 0);
        gridPane.add(new Label("Flight date:"), 0, 1);
        gridPane.add(flightDatePicker, 1, 1);
        gridPane.add(new Label("First name:"), 0, 2);
        gridPane.add(firstNameTextField, 1, 2);
        gridPane.add(new Label("Last name:"), 0, 3);
        gridPane.add(lastNameTextField, 1, 3);
        gridPane.add(new Label("Bags:"), 0, 4);
        gridPane.add(numberOfBagsTextField, 1, 4);
        gridPane.add(new Label("Flying with infant?"), 0, 5);
        gridPane.add(flyingWithInfantCheckBox, 1, 5);
        gridPane.add(new Label("Number of passengers:"), 0, 6);
        gridPane.add(numberOfPassengersTextField, 1, 6);
        gridPane.add(cancelButton, 0, 7);
        gridPane.add(saveButton, 0, 8);

        flyingWithInfantCheckBox.setOnAction(e -> handleFlyingWithInfantCheck(flyingWithInfantCheckBox));

        cancelButton.setOnAction(SeatReservationApplication::handle);

        saveButton.setOnAction(e -> {
            try {
                seatReservation.setFlightDesignator(flightDesignatorTextField.getText());
                seatReservation.setFlightDate(flightDatePicker.getValue());
                seatReservation.setFirstName(firstNameTextField.getText());
                seatReservation.setLastName(lastNameTextField.getText());

                System.out.println(seatReservation);

                Platform.exit();
            } catch (IllegalArgumentException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        });

        updateUI();

        Scene scene = new Scene(gridPane, 345, 310);
>>>>>>> module2
        stage.setScene(scene);
        stage.show();
    }

<<<<<<< HEAD
    public static void main(String[] args) {
        launch();
    }
=======
    private void updateUI() {
        flightDesignatorTextField.setText(seatReservation.getFlightDesignator());
        flightDatePicker.setValue(seatReservation.getFlightDate());
        firstNameTextField.setText(seatReservation.getFirstName());
        lastNameTextField.setText(seatReservation.getLastName());
        flyingWithInfantCheckBox.setSelected(seatReservation.isFlyingWithInfant());
    }

    private void handleFlyingWithInfantCheck(CheckBox flyingWithInfantCheckBox) {
        if (flyingWithInfantCheckBox.isSelected()) {
            this.numberOfPassengersTextField.setText("2");
        } else {
            this.numberOfPassengersTextField.setText("1");
        }
    }

        Button cancelButton = new Button("Cancel");
        Button saveButton = new Button("Save");
>>>>>>> module2
}