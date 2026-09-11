package com.zenithsky.oparea.lab.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zenithsky.oparea.lab.data.AirplaneData;
import com.zenithsky.oparea.lab.domain.Airplane;

@Service 
public class AirplaneBusiness {

    private final AirplaneData airplaneData;

   
    public AirplaneBusiness(AirplaneData airplaneData){
        this.airplaneData = airplaneData;
    }

    public List<Airplane> getAirplaneByType(int typeId) {
        return airplaneData.findAirplanesByTypeId(typeId);
    }

}
