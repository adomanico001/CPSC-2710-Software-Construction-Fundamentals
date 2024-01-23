/**
 * A program for an airline reservation management system.
 * Module 2 Assignment
 *
 * @author - Addie Domanico - CPSC 2710 - AO1
 * @version - 01/22/2024
 */

package edu.au.cpsc.module2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class SeatReservation extends Application {
    private SeatReservation seatReservation;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Seat Reservation Editor");

        // Creating controls for instance variables
        TextField flightDesignatorTextField = new TextField();
        DatePicker flightDatePicker = new DatePicker();
        TextField firstNameTextField = new TextField();
        TextField lastNameTextField = new TextField();
        TextField numberOfBagsTextField = new TextField();
        CheckBox flyingWithInfantCheckBox = new CheckBox();
        TextField numberOfPassengersTextField = new TextField();
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

        cancelButton.setOnAction(e -> stage.close());
        saveButton.setOnAction(e -> stage.close());

        Scene scene = new Scene(gridPane, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}




   /*     gridPane.add(flyingWithInfantCheckBox

        seatReservation = new SeatReservation();
        seatReservation.setFlightDesignator("ABC123");
        seatReservation.setFirstName("Betty");
        seatReservation.setLastName("White");
        seatReservation.setFlightDate("2024-01-22");
        seatReservation.setFlyingWithInfant(false);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(createGridPane());
        borderPane.setBottom(createButtonBox());

        Scene scene = new Scene(borderPane, 400, 300);
        stage.setScene(scene);
        stage.show();
        updateUI();
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(new Label("Flight designator:"), 0, 0);
        gridPane.add(new Label("Flight date:"), 0, 1);
        gridPane.add(new Label("First name:"), 0, 2);
        gridPane.add(new Label("Last name:"), 0, 3);
        gridPane.add(new Label("Number of bags:"), 0, 4);
        gridPane.add(new Label("Flying with infant?"), 0, 5);
        gridPane.add(new Label("Number of passengers:"), 0, 6);

        // Instance variables for controls
        flightDesignatorField = new TextField();
        flightDateField = new DatePicker();
        firstNameField = new TextField();
        lastNameField = new TextField();
        numberOfBagsField = new TextField("0");
        flyingWithInfantCheckBox = new CheckBox();
        numberOfPassengersField = new TextField(String.valueOf(1));
        numberOfPassengersField.setEditable(false);

        gridPane.add(flightDesignatorField, 1, 0);
        gridPane.add(flightDateField, 1, 1);
        gridPane.add(firstNameField, 1, 2);
        gridPane.add(lastNameField, 1, 3);
        gridPane.add(flyingWithInfantCheckBox, 1, 4);
        gridPane.add(numberOfPassengersField, 1, 5);

        flyingWithInfantCheckBox.setOnAction(event -> {
            if (flyingWithInfantCheckBox.isSelected()) {
                numberOfPassengersField.setText("2");
            } else {
                numberOfPassengersField.setText("1");
            }
        });
        return gridPane;
    }

    private HBox createButtonBox() {
        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setAlignment(Pos.TOP_RIGHT);

        Button cancelButton = new Button("Cancel");
        Button saveButton = new Button("Save");

        cancelButton.setOnAction(event -> {
            System.out.println("Cancel clicked");
            Platform.exit();
        });

        saveButton.setOnAction(event -> {
            try {
                seatReservation.setFlightDesignator(flightDesignatorField.getText());
                seatReservation.setFlightDate(flightDateField.getValue());
                seatReservation.setFirstName(firstNameField.getText());
                seatReservation.setLastName(lastNameField.getText());
                seatReservation.setFlyingWithInfant(flyingWithInfantCheckBox.isSelected());

                System.out.println(seatReservation);

                Platform.exit();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        });

        buttonBox.getChildren().addAll(cancelButton, saveButton);
        return buttonBox;
    }

    private void updateUI() {
        flightDesignatorField.setText(seatReservation.getFlightDesignator());
        flightDateField.setValue(seatReservation.getFlightDate());
        firstNameField.setText(seatReservation.getFirstName());
        lastNameField.setText(seatReservation.getLastName());
        flyingWithInfantCheckBox.setSelected(seatReservation.isFlyingWithInfant());
        numberOfPassengersField.setText("1");
    }

    */

