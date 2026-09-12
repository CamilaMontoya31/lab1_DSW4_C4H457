package com.zenithsky.oparea.lab.data;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.transaction.annotation.Transactional;

import com.zenithsky.oparea.lab.domain.Airplane;

@SpringBootTest
public class AirplaneDataTest {

    @Autowired
    private AirplaneData airplaneData;

    @Test
    @DisplayName("Debe retornar la(s) aeronave(s) cuando el typeId existe en la base de datos")
    @Transactional
    @Sql(scripts = "/insert_airplanes_test.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    public void givenExistingTypeId_whenFindingAirplanesByTypeId_thenReturnsAirplanes() {
        // Arrange
        int typeId = 1;

        // Act
        List<Airplane> airplanes = airplaneData.findAirplanesByTypeId(typeId);

        // Assert
        assertNotNull(airplanes);
        assertFalse(peliculasIsEmpty(airplanes)); // O usar assertaciones directas
        
        assertTrue(airplanes.stream().allMatch(a -> a.getAirplaneType() != null && a.getAirplaneType().getTypeId() == typeId));
    }

    private boolean peliculasIsEmpty(List<Airplane> list) {
        return list.isEmpty();
    }
}