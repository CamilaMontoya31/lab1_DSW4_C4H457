package com.zenithsky.oparea.lab.domain;


public class Airplane{

    private int airplaneId;
    private int capacity;
    private String airlineId;
    private Airline airlineOwner;
    private AirplaneType airplaneType;

    public Airplane(){
        this.airlineOwner = new Airline();
        this.airplaneType = new AirplaneType();

    }

    public Airplane(int airplaneId, int capacity, String airlineId, Airline airlineOwner,AirplaneType airplaneType ) {
        this.airplaneId = airplaneId;
        this.capacity = capacity;
        this.airlineId = airlineId;
        this.airlineOwner = airlineOwner;
        this.airplaneType = airplaneType;
    }
    public int getAirplaneId() {
        return airplaneId;
    }
    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(String airlineId) {
        this.airlineId = airlineId;
    }

    public Airline getAirline() {
        return airlineOwner;
    }
    
    public void setAirline(Airline airlineOwner) {
        this.airlineOwner = airlineOwner;
    }

    public AirplaneType getAirplaneType() {
        return airplaneType;
    }
    public void setAirplaneType(AirplaneType airplaneType) {
        this.airplaneType = airplaneType;
    }

  
}