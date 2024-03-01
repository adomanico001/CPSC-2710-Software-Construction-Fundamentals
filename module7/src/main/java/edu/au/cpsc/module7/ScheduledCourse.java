/**
 * A program with the capability to edit college course information.
 * Module 7 Project
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 03/01/2024
 */

package edu.au.cpsc.module7;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;

public class ScheduledCourse implements Serializable {
    // Instance variables
    private String courseCode;
    private String courseName;
    private LocalTime courseStartTime;
    private java.time.LocalTime courseEndTime;
    private HashSet<DayOfWeek> daysOfWeek;
    private String formatDaysOfWeek;

    // Constructor
    public ScheduledCourse() {
        courseCode = "";
        courseName = "";
        courseStartTime = LocalTime.now();
        courseEndTime = LocalTime.now();
        daysOfWeek = new HashSet<DayOfWeek>();
        formatDaysOfWeek = "";
    }

    // Getters and setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        if (courseCode == null) {
            throw new IllegalArgumentException("The course code is null.");
        }
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null) {
            throw new IllegalArgumentException("The course name is null.");
        }
        this.courseName = courseName;
    }

    public LocalTime getCourseStartTime() {
        return courseStartTime;
    }

    public void setCourseStartTime(LocalTime courseStartTime) {
        if (courseStartTime == null) {
            throw new IllegalArgumentException("The start time for this course is null.");
        }
        this.courseStartTime = courseStartTime;
    }

    public LocalTime getCourseEndTime() {
        return courseEndTime;
    }

    public void setCourseEndTime(LocalTime courseEndTime) {
        if (courseEndTime == null) {
            throw new IllegalArgumentException("The end time for this course is null.");
        }
        this.courseEndTime = courseEndTime;
    }

    public void setDaysOfWeek(HashSet<DayOfWeek> daysOfWeek) {
        if (daysOfWeek == null) {
            throw new IllegalArgumentException("Days of Week HashSet is null.");
        }
        this.daysOfWeek = daysOfWeek;
        updateFormatDaysOfWeek();
    }

    public HashSet<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    /**
     * Returns a string representation of the ScheduledClass object.
     * @return A string representation of the Scheduled Class
     */
    @Override
    public String toString() {
        return "Scheduled Classes{" + "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseStartTime=" + courseStartTime +
                // ", arrivalAirportIdent='" + arrivalAirportIdent + '\'' +
                ", courseEndTime=" + courseEndTime + ", daysOfWeeks=" + daysOfWeek + '}';
    }

    public String getFormatDaysOfWeek() {
        return formatDaysOfWeek;
    }

    private void updateFormatDaysOfWeek() {
        formatDaysOfWeek = "";
        if (daysOfWeek.contains(DayOfWeek.SUNDAY)) formatDaysOfWeek += "U";
        if (daysOfWeek.contains(DayOfWeek.MONDAY)) formatDaysOfWeek += "M";
        if (daysOfWeek.contains(DayOfWeek.TUESDAY)) formatDaysOfWeek += "T";
        if (daysOfWeek.contains(DayOfWeek.WEDNESDAY)) formatDaysOfWeek += "W";
        if (daysOfWeek.contains(DayOfWeek.THURSDAY)) formatDaysOfWeek += "R";
        if (daysOfWeek.contains(DayOfWeek.FRIDAY)) formatDaysOfWeek += "F";
        if (daysOfWeek.contains(DayOfWeek.SATURDAY)) formatDaysOfWeek += "S";
    }

    /**
     * Checks if current object is equal to another object.
     * @param o - the object to be compared for equality
     * @return - true if objects are determined equal, false if otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ScheduledCourse scheduledCourse)) {
            return false;
        }

        if(!Objects.equals(courseCode, scheduledCourse.courseCode)) {
            return false;
        }

        if(!Objects.equals(courseName, scheduledCourse.courseName)) {
            return false;
        }

        if(!Objects.equals(courseStartTime, scheduledCourse.courseStartTime)) {
            return false;
        }

        if(!Objects.equals(courseEndTime, scheduledCourse.courseEndTime)) {
            return false;
        }

        return !Objects.equals(daysOfWeek, scheduledCourse.daysOfWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode, courseName, courseStartTime, courseEndTime, daysOfWeek);
    }

}

