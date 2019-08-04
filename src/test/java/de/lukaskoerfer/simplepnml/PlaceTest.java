package de.lukaskoerfer.simplepnml;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PlaceTest {

    @Test
    void equalsAfterSerialization() throws Exception {
        EasyRandom random = new EasyRandom();
        Place input = random.nextObject(Place.class);
        Persister persister = new Persister();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        persister.write(input, out);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        Place output = persister.read(Place.class, in);
        assertEquals(input, output);
    }

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