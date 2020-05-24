package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class NodeGraphicsTest {

    @Test
    void canCreate() {
        NodeGraphics graphics = new NodeGraphics();
        assertTrue(graphics.isDefault());
        assertTrue(graphics.collect().count() > 1);
    }

    @Test
    void canCreateUsingBuilder() {
        NodeGraphics graphics = NodeGraphics.builder()
            .position(new Position(3.5, 2.3))
            .build();
        assertFalse(graphics.isDefault());
        assertTrue(graphics.collect().count() > 1);
    }

}