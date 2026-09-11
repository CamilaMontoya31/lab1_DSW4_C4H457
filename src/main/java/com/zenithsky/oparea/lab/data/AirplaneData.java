/*Debe incluir el método que reciba un typeId (int) y retorne la
 colección de objetos Airplane asociados a dicho tipo con todos sus
  datos.  Es obligagorio utilizar la clase JdbcTemplate y 
  ResultSetExtractor. */
  
package com.zenithsky.oparea.lab.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.zenithsky.oparea.lab.domain.Airline;
import com.zenithsky.oparea.lab.domain.Airplane;
import com.zenithsky.oparea.lab.domain.AirplaneType;

public class AirplaneData{

    private final JdbcTemplate jdbcTemplate;

    AirplaneData(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
    }

    public List<Airplane> findAirplanesByTypeId(int typeId){
        String sqlSelect = """
                    SELECT
                    a.airplane_id,
                    a.capacity,
                    a.type_id,
                    t.identifier,
                    t.description,
                    a.airline_id,
                    al.iata,
                    al.airlinename,
                    al.base_airport
                FROM airplane a
                INNER JOIN airplane_type t
                    ON a.type_id = t.type_id
                LEFT JOIN airline al
                    ON a.airline_id = al.airline_id
                WHERE a.type_id = ?
                """;
                typeId = typeId == 0 ? 1 : typeId; //esto es para pasarle el id y el identifier que es el nombre
                return jdbcTemplate.query(sqlSelect,new AirplaneExtractor(), typeId);

    }
}


class AirplaneExtractor implements ResultSetExtractor<List<Airplane>> {

    @Override
    public List<Airplane> extractData(ResultSet rs) throws SQLException, DataAccessException {
        // este metodo es implementado
        Map<Integer,Airplane> map = new HashMap<>();
        Airplane airplane = null;

        while(rs.next()){ //le pregunta al ResultSet si tiene registros por recorrer
           int airplaneId = rs.getInt("airplane_id");
           airplane = map.get(airplaneId);

           if (airplane == null) {
            airplane = new Airplane();

            airplane.setAirplaneId(airplaneId);
            airplane.setCapacity(rs.getInt("capacity"));
            airplane.setAirlineId(rs.getString("airline_id"));

            //pasar este a Airline
            if(rs.getString("airline_id") != null) {
                Airline airline = new Airline();
                airline.setAirlineId(rs.getInt("airline_id"));
                airline.setIata(rs.getString("iata"));
                airline.setAirlineName(rs.getString("airlinename"));
                airline.setBaseAirport(rs.getString("base_airport"));
                airplane.setAirline(airline);
            }

 
            
            //pasar este a AirplaneType
            if(rs.getString("type_id") != null) {
                AirplaneType airplaneType = new AirplaneType();
                airplaneType.setTypeId(rs.getInt("type_id"));
                airplaneType.setIdentifier(rs.getString("identifier"));
                airplaneType.setDescription(rs.getString("description"));
                airplane.setAirplaneType(airplaneType);
            }
           
            map.put(airplaneId,airplane);

           } //if
           
           
       
        }//while
        return new ArrayList<Airplane>(map.values());
    }
    
}