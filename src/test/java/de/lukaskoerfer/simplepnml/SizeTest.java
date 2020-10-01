package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SizeTest {

    private Size size;

    @BeforeEach
    void setup() {
        size = new Size();
    }

    @Test
    void isDefault_newInstance_true() {
        assertTrue(size.isDefault());
    }

    @Test
    void isDefault_widthNotZero_false() {
        size.setWidth(12.5);

        assertFalse(size.isDefault());
    }

    @Test
    void isDefault_heightNotZero_false() {
        size.setHeight(25);

        assertFalse(size.isDefault());
    }

}
