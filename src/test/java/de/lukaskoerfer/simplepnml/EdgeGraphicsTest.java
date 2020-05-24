package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class EdgeGraphicsTest {

    @Test
    void canCreate() {
        EdgeGraphics graphics = new EdgeGraphics();
        assertTrue(graphics.isDefault());
        assertTrue(graphics.collect().count() > 1);
    }

    @Test
    void canCreateUsingBuilder() {
        EdgeGraphics graphics = EdgeGraphics.builder()
            .position(new Position(2.3, 5.1))
            .build();
        assertFalse(graphics.isDefault());
        assertTrue(graphics.collect().count() > 1);
    }

}
