/**
 * A program with the capability to edit college course information.
 * Module 7 Project - DatabaseIO file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 03/01/2024
 */

package edu.au.cpsc.module7;

import java.io.*;

public class CourseDatabaseIO {
    // Saves the course database to the specified OutputStream
    public static void save(CourseDatabase database, OutputStream strm) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(strm);
        oos.writeObject(database);
    }

    // Loads the course database from the specified InputStream
    public static CourseDatabase load(InputStream strm) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(strm);
        return (CourseDatabase) ois.readObject();
    }
}
