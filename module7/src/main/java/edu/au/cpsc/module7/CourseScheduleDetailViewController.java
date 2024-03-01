/**
 * A program with the capability to edit college course information.
 * Module 7 Project - DetailView Controller file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 03/01/2024
 */

package edu.au.cpsc.module7;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import java.time.DayOfWeek;
import java.util.HashSet;

public class CourseScheduleDetailViewController {
    @FXML
    private GridPane courseScheduledDetailView;

    @FXML
    private TextField courseCodeTextField, courseNameTextField, courseStartTimeTextField;

    @FXML
    private ChoiceBox courseStartTimeChoiceBox;

    @FXML
    private ToggleButton sundayButton, mondayButton, tuesdayButton, wednesdayButton, thursdayButton,
            fridayButton, saturdayButton;

    public void showCourse(ScheduledCourse course) {
        if (course == null) {
            courseCodeTextField.clear();
            courseNameTextField.clear();
            // courseStartTimeTextField.clear();
            clearDayButtons();
            return;
        }

        courseCodeTextField.setText(course.getCourseCode());
        courseNameTextField.setText(course.getCourseName());
        HashSet<DayOfWeek> daysOfWeek = course.getDaysOfWeek();
        sundayButton.setSelected(daysOfWeek.contains(DayOfWeek.SUNDAY));
        mondayButton.setSelected(daysOfWeek.contains(DayOfWeek.MONDAY));
        tuesdayButton.setSelected(daysOfWeek.contains(DayOfWeek.TUESDAY));
        wednesdayButton.setSelected(daysOfWeek.contains(DayOfWeek.WEDNESDAY));
        thursdayButton.setSelected(daysOfWeek.contains(DayOfWeek.THURSDAY));
        fridayButton.setSelected(daysOfWeek.contains(DayOfWeek.FRIDAY));
        saturdayButton.setSelected(daysOfWeek.contains(DayOfWeek.SATURDAY));
    }

    public void updateCourse(ScheduledCourse course) {
        course.setCourseCode(courseCodeTextField.getText());
        course.setCourseName(courseNameTextField.getText());
        HashSet<DayOfWeek> daysOfWeek = new HashSet<>();

        if (sundayButton.isSelected()) {
            daysOfWeek.add(DayOfWeek.SUNDAY);
        }

        if (mondayButton.isSelected()) {
            daysOfWeek.add(DayOfWeek.MONDAY);
        }

        if (tuesdayButton.isSelected()) {
            daysOfWeek.add(DayOfWeek.TUESDAY);
        }

        if (wednesdayButton.isSelected()) {
            daysOfWeek.add(DayOfWeek.WEDNESDAY);
        }

        if (thursdayButton.isSelected()) {
            daysOfWeek.add(DayOfWeek.THURSDAY);
        }

        if (fridayButton.isSelected()) {
            daysOfWeek.add(DayOfWeek.FRIDAY);
        }

        if (saturdayButton.isSelected()) {
            daysOfWeek.add(DayOfWeek.SATURDAY);
        }

        course.setDaysOfWeek(daysOfWeek);
    }

    public void clearDayButtons() {
        sundayButton.setSelected(false);
        mondayButton.setSelected(false);
        tuesdayButton.setSelected(false);
        wednesdayButton.setSelected(false);
        thursdayButton.setSelected(false);
        fridayButton.setSelected(false);
        saturdayButton.setSelected(false);
    }
}
