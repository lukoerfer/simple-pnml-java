package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    private Position position;

    @BeforeEach
    void setup() {
        position = new Position();
    }

    @Test
    void isDefault_newInstance_true() {
        assertTrue(position.isDefault());
    }

    @Test
    void isDefault_xNotZero_false() {
        position.setX(2.1);

        assertFalse(position.isDefault());
    }

    @Test
    void isDefault_yNotZero_false() {
        position.setY(1.2);

        assertFalse(position.isDefault());
    }

}