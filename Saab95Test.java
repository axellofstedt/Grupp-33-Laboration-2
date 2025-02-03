import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    @org.junit.jupiter.api.Test
    void testSpeeds() {
        Saab95 s = new Saab95();
        s.gas(1);
        assertEquals(1.25, s.getCurrentSpeed());
        assertThrows(IllegalArgumentException.class, () -> s.gas(2));
        s.brake(1);
        assertEquals(0, s.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void positionTest() {
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
    void testCurrentSpeed() {
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
}