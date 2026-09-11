package com.zenithsky.oparea.lab.business;


import com.zenithsky.oparea.lab.domain.AirplaneType;

import java.util.List;

import com.zenithsky.oparea.lab.data.AirplaneTypeData;

public class AirplaneTypeBusiness{

    private final AirplaneTypeData airplaneTypeData;

    public AirplaneTypeBusiness(AirplaneTypeData airplaneTypeData){
        this.airplaneTypeData = airplaneTypeData;
    }

    public List<AirplaneType> getAirplaneTypes(int typeId){
        return airplaneTypeData.findAirplanesByTypeId(typeId);
    }
}


