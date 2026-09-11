package com.zenithsky.oparea.lab.domain;

public class AirplaneType{

    private int typeId;
    private String identifier;
    private String description;

    public AirplaneType(){

    }

    public AirplaneType(int typeId, String identifier, String description) {
        this.typeId = typeId;
        this.identifier = identifier;
        this.description = description;
    }
    public int getTypeId() {
        return typeId;
    }
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}