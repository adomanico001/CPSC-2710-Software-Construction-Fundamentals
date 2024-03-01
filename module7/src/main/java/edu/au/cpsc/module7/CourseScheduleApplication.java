/**
 * A program with the capability to edit college course information.
 * Module 7 Project - Application file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 03/01/2024
 */

package edu.au.cpsc.module7;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;


public class CourseScheduleApplication extends Application {
    // Initializes the application window and sets up the user interface
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CourseScheduleApplication.class.getResource("course-schedule-application.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Course Registration Portal");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}