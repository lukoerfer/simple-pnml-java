package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TransitionTest {

    @Test
    void canCreate() {
        Transition transition = new Transition();
        assertNotNull(transition.getId());
        assertFalse(transition.getId().isEmpty());
        assertNotNull(transition.getName());
        assertNotNull(transition.getGraphics());
        assertNotNull(transition.getToolSpecifics());
        assertTrue(transition.collect().count() > 1);
    }

    @Test
    void canCreateUsingBuilder() {
        String id = "123";
        Transition transition = Transition.builder()
            .id(id)
            .build();
        assertEquals(id, transition.getId());
    }

}