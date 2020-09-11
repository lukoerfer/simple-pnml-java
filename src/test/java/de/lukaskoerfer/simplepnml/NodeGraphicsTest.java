package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeGraphicsTest {

    private NodeGraphics graphics;

    @BeforeEach
    void setup() {
        graphics = new NodeGraphics();
    }

    @Test
    void setPosition_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            graphics.setPosition(null);
        });
    }

    @Test
    void setSize_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            graphics.setSize(null);
        });
    }

    @Test
    void setFill_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            graphics.setFill(null);
        });
    }

    @Test
    void setLine_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            graphics.setLine(null);
        });
    }

    @Test
    void collect_newInstance_containsMoreThanOneElement() {
        var elements = graphics.collect();

        assertTrue(elements.count() > 1);
    }

    @Test
    void isDefault_newInstance_true() {
        assertTrue(graphics.isDefault());
    }

    @Test
    void isDefault_positionNotDefault_false() {
        graphics.setPosition(new Position(1.5, 3.5));

        assertFalse(graphics.isDefault());
    }

    @Test
    void isDefault_sizeNotDefault_false() {
        graphics.setSize(new Size(10.0, 20.0));

        assertFalse(graphics.isDefault());
    }

    @Test
    void isDefault_fillNotDefault_false() {
        graphics.getFill().setColor("red");

        assertFalse(graphics.isDefault());
    }

    @Test
    void isDefault_lineNotDefault_false() {
        graphics.getLine().setColor("green");

        assertFalse(graphics.isDefault());
    }
}