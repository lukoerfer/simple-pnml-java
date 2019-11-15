package de.lukaskoerfer.simplepnml;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ArcTest {

    static EasyRandom random = new EasyRandom();

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
        String sourceId = random.nextObject(String.class),
            targetId = random.nextObject(String.class);
        Arc arc = new Arc();
        Connectable source = mock(Connectable.class);
        when(source.getId()).thenReturn(sourceId);
        Connectable target = mock(Connectable.class);
        when(target.getId()).thenReturn(targetId);
        arc.connect(source, target);
        assertEquals(sourceId, arc.getSource());
        assertEquals(targetId, arc.getTarget());
    }

    @Test
    void canSetSource() {
        String sourceId = random.nextObject(String.class);
        Arc arc = new Arc();
        Connectable source = mock(Connectable.class);
        when(source.getId()).thenReturn(sourceId);
        arc.setSource(source);
        assertEquals(sourceId, arc.getSource());
    }

    @Test
    void canSetTarget() {
        String targetId = random.nextObject(String.class);
        Arc arc = new Arc();
        Connectable target = mock(Connectable.class);
        when(target.getId()).thenReturn(targetId);
        arc.setTarget(target);
        assertEquals(targetId, arc.getTarget());
    }

}