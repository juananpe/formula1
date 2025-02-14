package eus.ehu.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PilotTest {

    @Test
    void testPilotConstructor() {
        Pilot pilot = new Pilot("Max Verstappen", "Dutch", 395);
        assertEquals("Max Verstappen (Dutch) - 395 points", pilot.toString());
    }

    @Test
    void testPilotConstructorWithoutPoints() {
        Pilot pilot = new Pilot("Lewis Hamilton", "British");
        assertEquals("Lewis Hamilton (British) - 0 points", pilot.toString());
    }

    @Test
    void testPilotConstructorWithOnlyName() {
        Pilot pilot = new Pilot("Charles Leclerc");
        assertEquals("Charles Leclerc (unknown) - 0 points", pilot.toString());
    }

    @Test
    void testAddPoints() {
        Pilot pilot = new Pilot("Sergio Perez", "Mexican", 200);
        pilot.addPoints(25);
        assertEquals("Sergio Perez (Mexican) - 225 points", pilot.toString());
    }
} 