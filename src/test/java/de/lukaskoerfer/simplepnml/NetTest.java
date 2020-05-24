package de.lukaskoerfer.simplepnml;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NetTest {

    @Test
    void canCreate() {
        Net net = new Net();
        assertNotNull(net.getId());
        assertFalse(net.getId().isEmpty());
        assertTrue(net.collect().count() > 1);
    }

    @Test
    void canCreateUsingBuilder() {
        String id = "my-net";
        Net net = Net.builder()
            .id(id)
            .build();
        assertEquals(id, net.getId());
        assertTrue(net.collect().count() > 1);
    }

}