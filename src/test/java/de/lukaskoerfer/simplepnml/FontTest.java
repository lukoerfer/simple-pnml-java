package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FontTest {

    private Font font;

    @BeforeEach
    void setup() {
        font = new Font();
    }

    @Test
    void setFamily_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            font.setFamily(null);
        });
    }

    @Test
    void setStyle_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
           font.setStyle(null);
        });
    }

    @Test
    void setWeight_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            font.setWeight(null);
        });
    }

    @Test
    void setSize_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            font.setSize(null);
        });
    }

    @Test
    void setDecoration_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            font.setDecoration(null);
        });
    }

    @Test
    void setAlign_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            font.setAlign(null);
        });
    }

    @Test
    void collect_newInstance_containsOneElement() {
        var elements = font.collect();

        assertEquals(1, elements.count());
    }

    @Test
    void isDefault_newInstance_true() {
        assertTrue(font.isDefault());
    }

    @Test
    void isDefault_familyNotEmpty_false() {
        font.setFamily("sans-serif");

        assertFalse(font.isDefault());
    }

    @Test
    void isDefault_styleNotEmpty_false() {
        font.setStyle("italic");

        assertFalse(font.isDefault());
    }

    @Test
    void isDefault_weightNotEmpty_false() {
        font.setWeight("bold");

        assertFalse(font.isDefault());
    }

    @Test
    void isDefault_sizeNotEmpty_false() {
        font.setSize("large");

        assertFalse(font.isDefault());
    }

    @Test
    void isDefault_decorationNotNone_false() {
        font.setDecoration(FontDecoration.OVERLINE);

        assertFalse(font.isDefault());
    }

    @Test
    void isDefault_alignNotLeft_false() {
        font.setAlign(FontAlign.CENTER);

        assertFalse(font.isDefault());
    }

    @Test
    void isDefault_rotationNotZero_false() {
        font.setRotation(90.0);

        assertFalse(font.isDefault());
    }

}
