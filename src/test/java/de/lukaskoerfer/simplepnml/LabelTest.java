package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LabelTest {

    @Test
    void canCreate() {
        Label label = new Label();
        assertTrue(label.isDefault());
        assertTrue(label.collect().count() > 1);
    }

    @Test
    void canCreateUsingBuilder() {
        String text = "MyLabel";
        Label label = Label.builder()
            .text(text)
            .build();
        assertEquals(text, label.getText());
        assertFalse(label.isDefault());
        assertTrue(label.collect().count() > 1);
    }

}