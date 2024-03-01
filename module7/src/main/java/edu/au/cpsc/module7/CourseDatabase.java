/**
 * A program with the capability to edit college course information.
 * Module 7 Project - Class Database file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 03/01/2024
 */

package edu.au.cpsc.module7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseDatabase implements Serializable {
    private List<ScheduledCourse> scheduledCourses;

    public CourseDatabase() {
        scheduledCourses =  new ArrayList<>();
    }

    public List<ScheduledCourse> getScheduledCourses() {
        return scheduledCourses;
    }

    public void addScheduledCourse(ScheduledCourse sc) {
        scheduledCourses.add(sc);
    }

    public void removeScheduledCourse(ScheduledCourse sc) {
        scheduledCourses.remove(sc);
    }

    public void updateScheduledCourse(ScheduledCourse sc) {
        // Nothing to do
        // We already reference the updated object
        // If a relational database, we would execute a SQL UPDATE
    }
}
