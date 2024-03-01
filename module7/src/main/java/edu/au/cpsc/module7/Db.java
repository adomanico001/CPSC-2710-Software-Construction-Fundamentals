/**
 * A program with the capability to edit college course information.
 * Module 7 Project - Dat file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 03/01/2024
 */

package edu.au.cpsc.module7;

import java.io.*;

public class Db {
    public static final File DEFAULT_FILE = new File("courses.dat");
    private static CourseDatabase courseDatabase = null;

    public static CourseDatabase getDatabase() {
        if (courseDatabase == null)
            courseDatabase = loadDatabase();
        return courseDatabase;
    }

    private static CourseDatabase loadDatabase() {
        try (InputStream is = new FileInputStream(DEFAULT_FILE)) {
            return CourseDatabaseIO.load(is);
        } catch (IOException|ClassNotFoundException ex) {
            return new CourseDatabase();
        }
    }

    public static void saveDatabase() {
        try (OutputStream os = new FileOutputStream(DEFAULT_FILE)) {
            CourseDatabaseIO.save(getDatabase(), os);
        } catch (IOException ex) {
            System.err.println("Error saving database: " + DEFAULT_FILE);
            ex.printStackTrace();
            System.exit(-1);
        }
    }
}
