import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.function.*;
public class TestCars {
    //File that combines VolvoTest and SaabTest (Tests for Volvo ends with V and Saab with SB)
    @Test
    void speedTestV() {
        Volvo240 v = new Volvo240();
        v.gas(1);
        assertEquals(1.25, v.getCurrentSpeed());
        assertThrows(IllegalArgumentException.class, () -> v.gas(2));
        v.brake(1);
        assertEquals(0, v.getCurrentSpeed());
    }
    @Test
    void positionTestV() {
        Volvo240 v = new Volvo240();
        v.move();
        assertEquals(0, v.x);
        assertEquals(0, v.y);
        v.gas(1);
        v.move();
        assertEquals(0, v.x);
        assertEquals(1.25, v.y);
        v.turnRight();
        v.move();
        assertEquals(1.25, v.x);
        assertEquals(1.25, v.y);
        v.turnRight();
        v.move();
        assertEquals(1.25, v.x);
        assertEquals(0, v.y);
    }
    @Test
    void testCurrentSpeedV() {
        // Checks that speed can't go beyond the car's engine power
        // and that using Car.gas won't decrease the speed
        Volvo240 v = new Volvo240();
        double tempSpeed = v.getCurrentSpeed();
        for (int n = 0; n < 1000; n++) {
            v.gas(1);
        }
        assertTrue(tempSpeed <= v.getCurrentSpeed());
        assertTrue(v.getCurrentSpeed() <= v.getEnginePower());
    }
    //--------------------Saab95Test fr.o.m nu--------------------------------
    @org.junit.jupiter.api.Test
    void speedTestSB() {
        Saab95 s = new Saab95();
        s.gas(1);
        assertEquals(1.25, s.getCurrentSpeed());
        assertThrows(IllegalArgumentException.class, () -> s.gas(2));
        s.brake(1);
        assertEquals(0, s.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void positionTestSB() {
        Saab95 s = new Saab95();
        s.move();
        assertEquals(0, s.x);
        assertEquals(0, s.y);
        s.gas(1);
        s.move();
        assertEquals(0, s.x);
        assertEquals(1.25, s.y);
        s.turnRight();
        s.move();
        assertEquals(1.25, s.x);
        assertEquals(1.25, s.y);
        s.turnRight();
        s.move();
        assertEquals(1.25, s.x);
        assertEquals(0, s.y);
    }

    @org.junit.jupiter.api.Test
    void testCurrentSpeedSB() {
        // Checks that speed can't go beyond the car's engine power
        // and that using Car.gas won't decrease the speed
        Saab95 s = new Saab95();
        double tempSpeed = s.getCurrentSpeed();
        for (int n = 0; n < 1000; n++) {
            s.gas(1);
        }
        assertTrue(tempSpeed <= s.getCurrentSpeed());
        assertTrue(s.getCurrentSpeed() <= s.getEnginePower());
    }
    //---------------ScaniaTests fr.o.m nu----------------------------
    @org.junit.jupiter.api.Test
    void testAngleSC() {
        Scania s = new Scania();
        double tempAngle = s.getFlatbedAngle();
        s.tiltFlatbed(-1);
        assertEquals(tempAngle, s.getFlatbedAngle());
        s.tiltFlatbed(91);
        assertEquals(tempAngle, s.getFlatbedAngle());
        s.tiltFlatbed(45);
        assertEquals(45,s.getFlatbedAngle());
    }
    @org.junit.jupiter.api.Test
    void testNoTiltMovingSC() {
        Scania s = new Scania();
        s.startEngine();
        s.gas(1);

        assertThrows(InternalError.class, () -> s.tiltFlatbed(45));

        s.stopEngine();
        s.tiltFlatbed(45);
        assertThrows(InternalError.class, () -> s.startEngine());
        s.tiltFlatbed(0);
        s.startEngine();
        s.gas(1);
        s.stopEngine();
        double tempAngle= s.getFlatbedAngle();
        s.tiltFlatbed(45);
        assertNotEquals(tempAngle, s.getFlatbedAngle());
    }
    //---------------CarTransportTest fr.o.m nu-------------------------
    @org.junit.jupiter.api.Test
    void testLoadCTonCT() {
        CarTransportTruck CT = new CarTransportTruck();


    }
}
