package com.zenithsky.oparea.lab.domain;

public class Airline{

    private int airlineId;
    private String iata;
    private String airlineName;
    private String baseAirport; // aquí en el futuro se puede cambiar a un objeto de tipo Airport

    Airline(){

    }

    public Airline(int airlineId, String iata, String airlineName, String baseAirport) {
        this.airlineId = airlineId;
        this.iata = iata;
        this.airlineName = airlineName;
        this.baseAirport = baseAirport;

    }
    public int getAirlineId() {
        return airlineId;
    }
    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }
    public String getIata() {
        return iata;
    }
    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getAirlineName() {
        return airlineName;
    }
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

     public String getBaseAirport() {
        return baseAirport;
    }
    public void setBaseAirport(String baseAirport) {
        this.baseAirport = baseAirport;
    }
}