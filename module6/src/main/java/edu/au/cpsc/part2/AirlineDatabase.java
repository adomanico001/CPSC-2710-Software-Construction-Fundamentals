/**
 * A program with the capability to modify airline flight information.
 * Module 6 Project - Airline Database file
 * @author - Addie Domanico - CPSC2710 - AO1
 * @version - 02/18/2024
 */

package edu.au.cpsc.part2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AirlineDatabase implements Serializable {
    private List<ScheduledFlight> scheduledFlights;

    public AirlineDatabase() {
        scheduledFlights =  new ArrayList<>();
    }

    public List<ScheduledFlight> getScheduledFlights() {
        return scheduledFlights;
    }

    public void addScheduledFlight(ScheduledFlight sf) {
        scheduledFlights.add(sf);
    }

    public void removeScheduledFlight(ScheduledFlight sf) {
        scheduledFlights.remove(sf);
    }

    public void updateScheduledFlight(ScheduledFlight sf) {
        // Nothing to do
        // We already reference the updated object
        // If a relational database, we would execute a SQL UPDATE
    }
}
