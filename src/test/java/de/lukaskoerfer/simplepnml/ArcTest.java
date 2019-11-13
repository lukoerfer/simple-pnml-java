package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ArcTest {

    static Stream<String> ids() {
        return Stream.of(null, "", "   ", "test");
    }

    @ParameterizedTest
    @MethodSource("ids")
    void createAssignsValidId(String id) {
        Arc arc = new Arc(id);
        assertNotNull(arc.getId());
        assertTrue(arc.getId().length() > 0);
        assertTrue(arc.getId().trim().length() > 0);
    }

    @Test
    void canConnect() {
        Arc arc = new Arc();
        Connectable source = mock(Connectable.class);
        when(source.getId()).thenReturn("source");
        Connectable target = mock(Connectable.class);
        when(target.getId()).thenReturn("target");
        arc.connect(source, target);
        assertEquals("source", arc.getSource());
        assertEquals("target", arc.getTarget());
    }

    @Test
    void canSetSource() {
        Arc arc = new Arc();
        Connectable source = mock(Connectable.class);
        when(source.getId()).thenReturn("source");
        arc.setSource(source);
        assertEquals("source", arc.getSource());
    }

    @Test
    void canSetTarget() {
        Arc arc = new Arc();
        Connectable target = mock(Connectable.class);
        when(target.getId()).thenReturn("target");
        arc.setTarget(target);
        assertEquals("target", arc.getTarget());
    }

}