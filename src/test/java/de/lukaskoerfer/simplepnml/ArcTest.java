package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArcTest {

    private Arc arc;

    @BeforeEach
    void setup() {
        arc = new Arc();
    }

    @Test
    void getId_newInstance_notNull() {
        String id = arc.getId();

        assertNotNull(id);
    }

    @Test
    void setId_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
           arc.setId(null);
        });
    }

    @Test
    void setSource_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            arc.setSource(null);
        });
    }

    @Test
    void setTarget_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            arc.setTarget(null);
        });
    }

    @Test
    void setGraphics_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            arc.setGraphics(null);
        });
    }

    @Test
    void setInscription_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            arc.setInscription(null);
        });
    }

    @Test
    void setToolSpecifics_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            arc.setToolSpecifics(null);
        });
    }

}