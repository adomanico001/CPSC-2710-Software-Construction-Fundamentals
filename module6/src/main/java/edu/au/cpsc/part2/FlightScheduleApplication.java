/**
 * A program with the capability to edit airline flight information.
 * Module 4 Project - Application file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 02/04/2024
 */

package edu.au.cpsc.part2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class FlightScheduleApplication extends Application {
    // Initializes the application window and sets up the user interface
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FlightScheduleApplication.class.getResource("flight-schedule-application.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Flight Schedule Information Editor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}