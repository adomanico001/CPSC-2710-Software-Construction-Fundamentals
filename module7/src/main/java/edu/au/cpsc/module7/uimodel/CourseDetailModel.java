/**
 * A program with the capability to modify college course information.
 * Module 7 Project - UI Model file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 03/01/2024
 */

package edu.au.cpsc.module7.uimodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CourseDetailModel {

    private final StringProperty courseCodeProperty;
    private final StringProperty courseNameProperty;
    private final BooleanProperty modifiedProperty;
    private final BooleanProperty newProperty;

    public CourseDetailModel() {
        courseCodeProperty = new SimpleStringProperty();
        courseNameProperty = new SimpleStringProperty();
        // arrivalAirportIdentProperty = new SimpleStringProperty();
        modifiedProperty = new SimpleBooleanProperty();
        newProperty = new SimpleBooleanProperty();
        courseCodeProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
        courseNameProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
    }

    public StringProperty courseCodeProperty() {
        return courseCodeProperty;
    }

    public StringProperty courseNameProperty() {
        return courseNameProperty;
    }

    public BooleanProperty modifiedProperty() {
        return modifiedProperty;
    }

    public BooleanProperty newProperty() {
        return newProperty;
    }

    public String getCourseCode() {
        return courseCodeProperty.get();
    }

    public void setCourseCode(String courseCode) {
        courseCodeProperty.set(courseCode);
    }

    public String getCourseName() {
        return courseNameProperty.get();
    }

    public void setCourseName(String courseName) {
        courseNameProperty.set(courseName);
    }

    public boolean isModified() {
        return modifiedProperty.get();
    }

    public void setModified(boolean m) {
        modifiedProperty.set(m);
    }

    public boolean isNew() {
        return newProperty.get();
    }

    public void setNew(boolean n) {
        newProperty.set(n);
    }
}
