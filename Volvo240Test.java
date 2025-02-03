import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    @Test
    void speedTest() {
        Volvo240 v = new Volvo240();
        v.gas(1);
        assertEquals(1.25, v.getCurrentSpeed());
        assertThrows(IllegalArgumentException.class, () -> v.gas(2));
        v.brake(1);
        assertEquals(0, v.getCurrentSpeed());
    }
    @Test
    void positionTest() {
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
    void testCurrentSpeed() {
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
}