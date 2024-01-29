package edu.au.cpsc.module3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Airport {
    // Instance variables
    public String ident;
    public String type;
    public String name;
    public Integer elevationFt;
    public String continent;
    public String country;
    public String region;
    public String municipality;
    public String gpsCode;
    public String iataCode;
    public String localCode;
    public Double coordinatesLongitude;
    public Double coordinatesLatitude;

    // Constructor
    public Airport() {
        ident = "";
        type = "";
        name = "";
        elevationFt = Integer.MIN_VALUE;
        continent = "";
        country = "";
        region = "";
        municipality = "";
        gpsCode = "";
        iataCode = "";
        localCode = "";
        coordinatesLongitude = Double.MIN_VALUE;
        coordinatesLatitude = Double.MIN_VALUE;
    }

    public Airport(String s) {
        initialize(s);
    }

    public void initialize(String s) throws IllegalArgumentException {
        String[] columns = s.split(",(?=[^\"] * \"[^\"] * \" * [^\"] * $)", -1);
        if (columns.length != 12) {
            for (String e : columns) {
                System.out.println(e);
            }
            throw new IllegalArgumentException("This file is not formatted correctly.");
        }

        setIdent(columns[0]);
        setType(columns[1]);
        setName(columns[2]);
        if (columns[3].isEmpty()) {
            setElevationFt(0);
        } else {
            setElevationFt(Integer.valueOf(columns[3]));
        }
        setContinent(columns[4]);
        setCountry(columns[5]);
        setRegion(columns[6]);
        setMunicipality(columns[7]);
        setGpsCode(columns[8]);
        setIataCode(columns[9]);
        setLocalCode(columns[10]);

        // Initiated to remove unwanted quotations from longitude and latitude coordinates
        columns[11] = columns[11].substring(1, columns[11].length() - 2);
        String[] coordinates = columns[11].split(",");
        setCoordinatesLongitude(Double.valueOf(coordinates[0]));
        setCoordinatesLatitude(Double.valueOf(coordinates[1]));
    }

    // Getters and setters
    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getElevationFt() {
        return elevationFt;
    }

    public void setElevationFt(Integer elevationFt) {
        this.elevationFt = elevationFt;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getGpsCode() {
        return gpsCode;
    }

    public void setGpsCode(String gpsCode) {
        this.gpsCode = gpsCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getLocalCode() {
        return localCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    public Double getCoordinatesLongitude() {
        return coordinatesLongitude;
    }

    public void setCoordinatesLongitude(Double coordinatesLongitude) {
        this.coordinatesLongitude = coordinatesLongitude;
    }

    public Double getCoordinatesLatitude() {
            return coordinatesLatitude;
    }

    public void setCoordinatesLatitude(Double coordinatesLatitude) {
        this.coordinatesLatitude = coordinatesLatitude;
    }

    public static List<Airport> readAll() throws IOException {
        List<Airport> airports = new ArrayList<>();
        try {
            File file = new File("/Users/adomanico/CPSC2710/module3/src/main/resources/edu/au/cpsc/module3/airport-codes.csv");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");
            scanner.nextLine();
            while (scanner.hasNext()) {
                String s = scanner.next();
                airports.add(new Airport(s));
            }
        }
        catch (IOException e) {
            System.out.println("Cannot find this file.");
        }
        return airports;
    }
}

