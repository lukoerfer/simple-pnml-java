package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FontTest {

    @Test
    void canCreate() {
        Font font = new Font();
        assertTrue(font.isDefault());
        assertEquals(1, font.collect().count());
    }

    @Test
    void canCreateUsingBuilder() {
        Font font = Font.builder()
            .family("serif")
            .decoration(FontDecoration.UNDERLINE)
            .build();
        assertFalse(font.isDefault());
        assertEquals(1, font.collect().count());
    }

}
