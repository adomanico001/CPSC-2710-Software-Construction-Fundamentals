/**
 * A program with the capability to modify airline flight information.
 * Module 6 Project - DatabaseIO file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 02/18/2024
 */

package edu.au.cpsc.part2;

import java.io.*;

public class AirlineDatabaseIO {
    // Saves the airline database to the specified OutputStream
    public static void save(AirlineDatabase database, OutputStream strm) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(strm);
        oos.writeObject(database);
    }

    // Loads the airline database from the specified InputStream
    public static AirlineDatabase load(InputStream strm) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(strm);
        return (AirlineDatabase) ois.readObject();
    }
}
