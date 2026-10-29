/*
Program: Chapter 11 Inheritance and Polymorphism Practice
Programmer: Iniya Rathinakumar
Date: October 27, 2026
Purpose: Working with Flight and Itinerary class using Inheritance and Polymorphism
*/


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
* Stores information about a flight.
* @author Iniya Rathinakumar
*/
public class Flight {
    private String flightNo;
    private GregorianCalendar departureTime;
    private GregorianCalendar arrivalTime;

    /**
    * Creates a flight with the specified information.
    * @param flightNo the flight number
    * @param departureTime the departure time
    * @param arrivalTime the arrival time
    */
    public Flight(String flightNo, GregorianCalendar departureTime,
                  GregorianCalendar arrivalTime) {
        this.flightNo = flightNo;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    /**
    * Returns the flight number.
    * @return the flight number
    */
    public String getFlightNo() {
        return flightNo;
    }

    /**
    * Returns the departure time.
    * @return the departure time
    */
    public GregorianCalendar getDepartureTime() {
        return departureTime;
    }

    /**
    * Sets the departure time.
    * @param departureTime the new departure time
    */
    public void setDepartureTime(GregorianCalendar departureTime) {
        this.departureTime = departureTime;
    }

    /**
    * Returns the arrival time.
    * @return the arrival time
    */
    public GregorianCalendar getArrivalTime() {
        return arrivalTime;
    }

    /**
    * Sets the arrival time.
    * @param arrivalTime the new arrival time
    */
    public void setArrivalTime(GregorianCalendar arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
    * Returns the flight time in minutes.
    * @return the flight time in minutes
    */
    public int getFlightTime() {
        long departure = departureTime.getTimeInMillis();
        long arrival = arrivalTime.getTimeInMillis();

        return (int) ((arrival - departure) / 60000);
    }

    /**
    * Tests the Flight and Itinerary classes.
    * @param args command-line arguments
    */
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight("US230",
                new GregorianCalendar(2014, 4, 5, 5, 5, 0),
                new GregorianCalendar(2014, 4, 5, 6, 15, 0)));

        flights.add(new Flight("US235",
                new GregorianCalendar(2014, 4, 5, 6, 55, 0),
                new GregorianCalendar(2014, 4, 5, 7, 45, 0)));

        flights.add(new Flight("US237",
                new GregorianCalendar(2014, 4, 5, 9, 35, 0),
                new GregorianCalendar(2014, 4, 5, 12, 55, 0)));

        Itinerary itinerary = new Itinerary(flights);

        System.out.println(itinerary.getTotalTravelTime());
        System.out.println(itinerary.getTotalFlightTime());
    }
}

/**
* Stores the flights in an itinerary.
*/
class Itinerary {
    private List<Flight> flights;

    /**
    * Creates an itinerary with the specified flights.
    * @param flights the list of flights
    */
    public Itinerary(List<Flight> flights) {
        this.flights = flights;
    }

    /**
    * Returns the total travel time in minutes, including the time between flights.
    * @return the total travel time in minutes
    */
    public int getTotalTravelTime() {
        Flight firstFlight = flights.get(0);
        Flight lastFlight = flights.get(flights.size() - 1);

        long departure =
                firstFlight.getDepartureTime().getTimeInMillis();
        long arrival =
                lastFlight.getArrivalTime().getTimeInMillis();

        return (int) ((arrival - departure) / 60000);
    }

    /**
    * Returns the total time spent flying in minutes.
    * @return the total flight time in minutes
    */
    public int getTotalFlightTime() {
        int total = 0;

        for (int i = 0; i < flights.size(); i++) {
            total += flights.get(i).getFlightTime();
        }

        return total;
    }
}
