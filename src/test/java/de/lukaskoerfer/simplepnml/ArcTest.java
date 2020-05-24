package de.lukaskoerfer.simplepnml;

import org.jeasy.random.EasyRandom;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ArcTest {

    @Test
    void canCreate() {
        Arc arc = new Arc();
        assertNotNull(arc.getId());
        assertFalse(arc.getId().isEmpty());
        assertTrue(arc.collect().count() > 1);
    }

    @Test
    void canCreateUsingBuilder() {
        String id = "my-arc";
        Arc arc = Arc.builder()
            .id(id)
            .build();
        assertEquals(id, arc.getId());
        assertTrue(arc.collect().count() > 1);
    }


}