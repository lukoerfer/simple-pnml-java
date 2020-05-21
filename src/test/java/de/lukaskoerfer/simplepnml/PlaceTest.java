package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PlaceTest {

    @Test
    void canCreate() {
        Place place = new Place();
        assertNotNull(place.getId());
        assertFalse(place.getId().isEmpty());
        assertNotNull(place.getName());
        assertNotNull(place.getGraphics());
        assertNotNull(place.getInitialMarking());
        assertNotNull(place.getToolSpecifics());
        assertTrue(place.collect().count() > 1);
    }

    @Test
    void canCreateUsingBuilder() {
        String id = "123";
        Place place = Place.builder()
            .id(id)
            .build();
        assertEquals(id, place.getId());
    }

}