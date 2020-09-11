package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FillTest {

    private Fill fill;

    @BeforeEach
    void setup() {
        fill = new Fill();
    }

    @Test
    void setColor_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            fill.setColor(null);
        });
    }

    @Test
    void setGradientColor_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            fill.setGradientColor(null);
        });
    }

    @Test
    void setGradientRotation_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            fill.setGradientRotation(null);
        });
    }

    @Test
    void setImage_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            fill.setImage(null);
        });
    }

    @Test
    void collect_newInstance_containsOneElement() {
        var elements = fill.collect();

        assertEquals(1, elements.count());
    }

    @Test
    void isDefault_newInstance_true() {
        assertTrue(fill.isDefault());
    }

    @Test
    void isDefault_colorNotEmpty_false() {
        fill.setColor("red");

        assertFalse(fill.isDefault());
    }

    @Test
    void isDefault_gradientColorNotEmpty_false() {
        fill.setGradientColor("green");

        assertFalse(fill.isDefault());
    }

    @Test
    void isDefault_gradientRotationNotNone_false() {
        fill.setGradientRotation(GradientRotation.DIAGONAL);

        assertFalse(fill.isDefault());
    }

    @Test
    void isDefault_imageNotEmpty_false() {
        fill.setImage("http://example.com/image.png");

        assertFalse(fill.isDefault());
    }

}
