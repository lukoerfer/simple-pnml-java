package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SizeTest {

    @Test
    void canCreate() {
        Size size = new Size();
        assertEquals(0.0, size.getWidth());
        assertEquals(0.0, size.getHeight());
        assertTrue(size.isDefault());
        assertEquals(1, size.collect().count());
    }

    @Test
    void canCreateWithValues() {
        double width = 6.3, height = 4.4;
        Size size = new Size(width, height);
        assertEquals(width, size.getWidth());
        assertEquals(height, size.getHeight());
        assertFalse(size.isDefault());
        assertEquals(1, size.collect().count());
    }

}
