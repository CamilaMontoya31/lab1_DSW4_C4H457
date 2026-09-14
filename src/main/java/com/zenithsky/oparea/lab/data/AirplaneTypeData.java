package com.zenithsky.oparea.lab.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.zenithsky.oparea.lab.domain.AirplaneType;

@Repository
public class AirplaneTypeData {

    private final JdbcTemplate jdbcTemplate;

   AirplaneTypeData(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }

   public List<AirplaneType> findAll(){
        String sqlSelect = """
               SELECT a.type_id, a.identifier, a.description FROM airplane_type a
                """;
                
            //esto es para pasarle el id y el identifier que es el nombre
               return jdbcTemplate.query(sqlSelect, 
            new BeanPropertyRowMapper<>(AirplaneType.class));

    }
}


//TO DO fix this
class AirplaneTypeExtractor implements ResultSetExtractor<List<AirplaneType>> {

    @Override
    public List<AirplaneType> extractData(ResultSet rs) throws SQLException, DataAccessException {
        // este metodo es implementado
        Map<Integer,AirplaneType> map = new HashMap<>();
        AirplaneType airlineType = null;

        while(rs.next()){ //le pregunta al ResultSet si tiene registros por recorrer

           int typeId = rs.getInt("type_id");
           airlineType = map.get(typeId);

           if (airlineType == null) {

            airlineType = new AirplaneType();
            airlineType.setTypeId(typeId);
            airlineType.setIdentifier(rs.getString("identifier"));
            airlineType.setDescription(rs.getString("description"));

           
            map.put(typeId,airlineType);

           } 
           }//while
        
        return new ArrayList<AirplaneType>(map.values());
    }


   
    
}


