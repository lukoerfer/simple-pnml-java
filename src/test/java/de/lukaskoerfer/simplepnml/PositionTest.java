package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void canCreate() {
        Position position = new Position();
        assertEquals(0.0, position.getX());
        assertEquals(0.0, position.getY());
        assertTrue(position.isDefault());
        assertEquals(1, position.collect().count());
    }

    @Test
    void canCreateWithValues() {
        double x = 3.5, y = 5.2;
        Position position = new Position(x, y);
        assertEquals(x, position.getX());
        assertEquals(y, position.getY());
        assertFalse(position.isDefault());
        assertEquals(1, position.collect().count());
    }

}