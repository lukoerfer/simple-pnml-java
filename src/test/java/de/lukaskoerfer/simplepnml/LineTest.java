package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void canCreate() {
        Line line = new Line();
        assertTrue(line.isDefault());
        assertEquals(1, line.collect().count());
    }

    @Test
    void canCreateUsingBuilder() {
        String color = "red";
        Line line = Line.builder()
            .color("red")
            .build();
        assertEquals(color, line.getColor());
        assertFalse(line.isDefault());
        assertEquals(1, line.collect().count());
    }

}
