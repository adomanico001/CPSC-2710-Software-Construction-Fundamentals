/**
 * A program with the capability to edit airline flight information.
 * Module 4 Project - Dat file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 02/04/2024
 */

package edu.au.cpsc.part2;

import java.io.*;

public class Db {
    public static final File DEFAULT_FILE = new File("flights.dat");
    private static AirlineDatabase airlineDatabase = null;

    public static AirlineDatabase getDatabase() {
        if (airlineDatabase == null)
            airlineDatabase = loadDatabase();
        return airlineDatabase;
    }

    private static AirlineDatabase loadDatabase() {
        try (InputStream is = new FileInputStream(DEFAULT_FILE)) {
            return AirlineDatabaseIO.load(is);
        } catch (IOException|ClassNotFoundException ex) {
            return new AirlineDatabase();
        }
    }

    public static void saveDatabase() {
        try (OutputStream os = new FileOutputStream(DEFAULT_FILE)) {
            AirlineDatabaseIO.save(getDatabase(), os);
        } catch (IOException ex) {
            System.err.println("Error saving database: " + DEFAULT_FILE);
            ex.printStackTrace();
            System.exit(-1);
        }
    }
}
