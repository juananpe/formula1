package eus.ehu.businesslogic;

import eus.ehu.domain.Pilot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BusinessLogicTest {

    private BlInterface businessLogic;

    @BeforeEach
    void setUp() {
        businessLogic = new BusinessLogic();
    }

    @Test
    void testStorePilotAndGetPilots() {
        // Store a test pilot
        String testName = "Test Pilot";
        String testNationality = "Test Nation";
        int testPoints = 100;
        
        businessLogic.storePilot(testName, testNationality, testPoints);
        
        // Get all pilots and verify the test pilot is present
        List<Pilot> pilots = businessLogic.getPilots();
        boolean found = pilots.stream()
                .anyMatch(p -> p.toString().contains(testName) && 
                             p.toString().contains(testNationality) && 
                             p.toString().contains(String.valueOf(testPoints)));
        
        assertTrue(found, "The stored pilot should be found in the pilots list");
        
        // Clean up
        pilots.stream()
                .filter(p -> p.toString().contains(testName))
                .findFirst()
                .ifPresent(businessLogic::deletePilot);
    }

    @Test
    void testDeletePilot() {
        // Store a pilot to delete
        String testName = "Pilot To Delete";
        businessLogic.storePilot(testName, "Test Nation", 0);
        
        // Get the pilot and delete it
        List<Pilot> pilots = businessLogic.getPilots();
        Pilot pilotToDelete = pilots.stream()
                .filter(p -> p.toString().contains(testName))
                .findFirst()
                .orElse(null);
        
        assertNotNull(pilotToDelete, "Pilot should be found before deletion");
        
        businessLogic.deletePilot(pilotToDelete);
        
        // Verify deletion
        pilots = businessLogic.getPilots();
        boolean stillExists = pilots.stream()
                .anyMatch(p -> p.toString().contains(testName));
        
        assertFalse(stillExists, "Pilot should not exist after deletion");
    }
} 