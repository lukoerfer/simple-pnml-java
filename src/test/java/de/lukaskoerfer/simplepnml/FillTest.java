package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class FillTest {

    @Test
    void canCreate() {
        Fill fill = new Fill();
        assertTrue(fill.isDefault());
        assertEquals(1, fill.collect().count());
    }

    @Test
    void canCreateUsingBuilder() {
        String color = "red";
        Fill fill = Fill.builder()
            .color(color)
            .build();
        assertEquals(color, fill.getColor());
        assertFalse(fill.isDefault());
        assertEquals(1, fill.collect().count());
    }

}
