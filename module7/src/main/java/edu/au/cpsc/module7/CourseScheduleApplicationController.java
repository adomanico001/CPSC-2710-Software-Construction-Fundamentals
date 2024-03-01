/**
 * A program with the capability to edit college course information.
 * Module 7 Project - Application Controller file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 03/01/2024
 */

package edu.au.cpsc.module7;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class CourseScheduleApplicationController {

    @FXML
    private Parent applicationRoot;

    @FXML
    private CourseScheduleTableViewController courseScheduleTableViewController;

    @FXML
    private CourseScheduleDetailViewController courseScheduleDetailViewController;

    @FXML
    private Button updateButton;

    private ScheduledCourse courseEdited;
    private boolean courseEditedIsNew;

    public void initialize() {
        courseScheduleTableViewController.showCourses(Db.getDatabase().getScheduledCourses());
        courseScheduleTableViewController.onCourseSelectionChanged(
                event -> showCourse(event.getSelectedCourse()));
        showCourse(null);
    }

    private void showCourse(ScheduledCourse course) {
        courseScheduleDetailViewController.showCourse(course);
        courseEdited = course == null ? new ScheduledCourse() : course;
        courseEditedIsNew = course == null;
        String buttonLabel = courseEditedIsNew ? "Add" : "Update";
        updateButton.setText(buttonLabel);
    }

    @FXML
    protected void updateButtonAction() {
        courseScheduleDetailViewController.updateCourse(courseEdited);
        if (courseEditedIsNew) {
            Db.getDatabase().addScheduledCourse(courseEdited);
        } else {
            Db.getDatabase().updateScheduledCourse(courseEdited);
        }
        Db.saveDatabase();
        courseScheduleTableViewController.showCourses(Db.getDatabase().getScheduledCourses());
        courseScheduleTableViewController.select(courseEdited);

        openNewWindow();
    }

    private void openNewWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("course-schedule-new-window.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Course Registration Update");
            stage.setScene(new Scene(root));

            CourseScheduleNewWindowController newWindowController= loader.getController();
            newWindowController.setMessage("You have successfully added a new course!");

            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void newButtonAction() {
        courseScheduleTableViewController.select(null);
    }

    @FXML
    protected void deleteButtonAction() {
        if (courseEditedIsNew) {
            courseScheduleTableViewController.select(null);
        } else {
            Db.getDatabase().removeScheduledCourse(courseEdited);
            Db.saveDatabase();
            courseScheduleTableViewController.showCourses(Db.getDatabase().getScheduledCourses());
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
        ChoiceDialog<String> choiceDialog = new ChoiceDialog<>("Light - Auburn Theme", "Dark", "Light - Auburn Theme");
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

    public ScheduledCourse getScheduledCourseBeingEdited() {
        return courseScheduleTableViewController.getSelectedCourse();
    }
}