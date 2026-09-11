package com.zenithsky.oparea.lab.business;

import org.springframework.stereotype.Service;
import com.zenithsky.oparea.lab.domain.AirplaneType;
import com.zenithsky.oparea.lab.data.AirplaneTypeData;
import java.util.List;


@Service
public class AirplaneTypeBusiness{

    private final AirplaneTypeData airplaneTypeData;

    public AirplaneTypeBusiness(AirplaneTypeData airplaneTypeData){
        this.airplaneTypeData = airplaneTypeData;
    }

    public List<AirplaneType> getAirplaneTypes(){
        return airplaneTypeData.findAll();
    }
}


