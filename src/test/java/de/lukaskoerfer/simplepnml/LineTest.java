package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    private Line line;

    @BeforeEach
    void setup() {
        line = new Line();
    }

    @Test
    void setColor_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            line.setColor(null);
        });
    }

    @Test
    void setShape_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            line.setShape(null);
        });
    }

    @Test
    void setStyle_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            line.setShape(null);
        });
    }

    @Test
    void collect_newInstance_containsOneElement() {
        var elements = line.collect();

        assertEquals(1, elements.count());
    }

    @Test
    void isDefault_newInstance_true() {
        assertTrue(line.isDefault());
    }

    @Test
    void isDefault_colorNotEmpty_false() {
        line.setColor("red");

        assertFalse(line.isDefault());
    }

    @Test
    void isDefault_widthNotZero_false() {
        line.setWidth(3.5);

        assertFalse(line.isDefault());
    }

    @Test
    void isDefault_shapeNotLine_false() {
        line.setShape(LineShape.CURVE);

        assertFalse(line.isDefault());
    }

    @Test
    void isDefault_styleNotSolid_false() {
        line.setStyle(LineStyle.DOT);

        assertFalse(line.isDefault());
    }

}
