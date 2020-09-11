package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnnotationGraphicsTest {

    private AnnotationGraphics graphics;

    @BeforeEach
    void setup() {
        graphics = new AnnotationGraphics();
    }

    @Test
    void setOffset_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            graphics.setOffset(null);
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
    void setFont_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            graphics.setFont(null);
        });
    }

    @Test
    void isDefault_newInstance_true() {
        assertTrue(graphics.isDefault());
    }

    @Test
    void isDefault_offsetNotDefault_false() {
        graphics.setOffset(new Offset(1.2, 4.2));

        assertFalse(graphics.isDefault());
    }


}
