/**
 * A program with the capability to edit college course information.
 * Module 7 Project - TableView Controller file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 03/01/2024
 */

package edu.au.cpsc.module7;

import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class CourseScheduleTableViewController {
    @FXML
    private TableView<ScheduledCourse> courseTableView;

    @FXML
    private TableColumn<ScheduledCourse, String> courseCodeColumn, courseNameColumn,
            courseStartTimeColumn, daysOfWeekColumn;

    public void initialize() {
        courseCodeColumn.setCellValueFactory(new PropertyValueFactory<ScheduledCourse, String>("courseCode"));
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<ScheduledCourse, String>("courseName"));
        courseStartTimeColumn.setCellValueFactory(new PropertyValueFactory<ScheduledCourse, String>("courseStartTime"));
        daysOfWeekColumn.setCellValueFactory(new PropertyValueFactory<ScheduledCourse, String>("formatDaysOfWeek"));

        courseTableView.getSelectionModel().selectedItemProperty().addListener(event -> tableSelectionChanged());
    }


    public void showCourses(List<ScheduledCourse> courses) {
        SortedList<ScheduledCourse> sortedList = new SortedList<>(FXCollections.observableList(courses));
        courseTableView.setItems(sortedList);
        sortedList.comparatorProperty().bind(courseTableView.comparatorProperty());
        courseTableView.refresh();
    }

    public void onCourseSelectionChanged(EventHandler<CourseTableEvent> handler) {
        courseTableView.addEventHandler(CourseTableEvent.COURSE_SELECTED, handler);
    }


    public void tableSelectionChanged() {
        ScheduledCourse selectedCourse = courseTableView.getSelectionModel().getSelectedItem();
        CourseTableEvent event = new CourseTableEvent(CourseTableEvent.COURSE_SELECTED,
                selectedCourse);
        courseTableView.fireEvent(event);
    }

    public ScheduledCourse getSelectedCourse() {
        return courseTableView.getSelectionModel().getSelectedItem();
    }

    public void select(ScheduledCourse course) {
        courseTableView.getSelectionModel().select(course);
    }

    public Scene getScene() {
        return null;
    }

    public static class CourseTableEvent extends Event {
        public static final EventType<CourseTableEvent> ANY = new EventType<>(Event.ANY, "ANY");
        public static final EventType<CourseTableEvent> COURSE_SELECTED = new EventType<>(ANY, "COURSE_SELECTED");

        public ScheduledCourse selectedCourse;

        public CourseTableEvent(EventType<? extends Event> eventType, ScheduledCourse selectedCourse) {
            super(eventType);
            this.selectedCourse = selectedCourse;
        }

        public ScheduledCourse getSelectedCourse() {
            return selectedCourse;
        }
    }
}
