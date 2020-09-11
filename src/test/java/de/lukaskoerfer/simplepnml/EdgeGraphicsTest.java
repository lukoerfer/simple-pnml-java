package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EdgeGraphicsTest {

    private EdgeGraphics graphics;

    @BeforeEach
    void setup() {
        graphics = new EdgeGraphics();
    }

    @Test
    void setPositions_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
           graphics.setPositions(null);
        });
    }

    @Test
    void setLine_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            graphics.setLine(null);
        });
    }

    @Test
    void isDefault_newInstance_true() {
        assertTrue(graphics.isDefault());
    }

    @Test
    void isDefault_positionsNotEmpty_false() {
        graphics.getPositions().add(new Position(1.2, 2.3));

        assertFalse(graphics.isDefault());
    }

    @Test
    void isDefault_lineNotDefault_false() {
        graphics.getLine().setColor("green");

        assertFalse(graphics.isDefault());
    }

}
