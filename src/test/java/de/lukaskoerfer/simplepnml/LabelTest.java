package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LabelTest {

    private Label label;

    @BeforeEach
    void setup() {
        label = new Label();
    }

    @Test
    void setText_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            label.setText(null);
        });
    }

    @Test
    void setGraphics_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            label.setGraphics(null);
        });
    }

    @Test
    void collect_newInstance_containsMoreThanOneElement() {
        var elements = label.collect();

        assertTrue(elements.count() > 1);
    }

    @Test
    void isDefault_newInstance_true() {
        assertTrue(label.isDefault());
    }

    @Test
    void isDefault_textNotEmpty_false() {
        label.setText("Lorem ipsum");

        assertFalse(label.isDefault());
    }

    @Test
    void isDefault_graphicsNotDefault_false() {
        label.setGraphics(AnnotationGraphics.builder().offset(new Offset(1.1, 2.3)).build());

        assertFalse(label.isDefault());
    }
}