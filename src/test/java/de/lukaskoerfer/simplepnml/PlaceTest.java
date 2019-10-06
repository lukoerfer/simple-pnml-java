package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlaceTest {

    static Stream<String> ids() {
        return Stream.of(null, "", "   ", "test");
    }

    @ParameterizedTest
    @MethodSource("ids")
    void createAssignsValidId(String id) {
        Place place = Place.create(id);
        assertNotNull(place.getId());
        assertTrue(place.getId().length() > 0);
        assertTrue(place.getId().trim().length() > 0);
    }

}