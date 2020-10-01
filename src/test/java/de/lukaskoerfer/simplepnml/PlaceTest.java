package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaceTest {

    private Place place;

    @BeforeEach
    void setup() {
        place = new Place();
    }

    @Test
    void getId_newInstance_notNullOrEmpty() {
        String id = place.getId();

        assertNotNull(id);
        assertFalse(id.isEmpty());
    }

    @Test
    void setId_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            place.setId(null);
        });
    }

    @Test
    void setName_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            place.setName(null);
        });
    }

    @Test
    void setGraphics_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            place.setGraphics(null);
        });
    }

    @Test
    void setInitialMarking_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            place.setInitialMarking(null);
        });
    }

    @Test
    void setToolSpecifics_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            place.setToolSpecifics(null);
        });
    }

}