package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

class ArcTest {

    @Test
    void testCreate() {
        Arc arc = Arc.create(null, null, null, null);
        assertNotNull(arc.getId());
    }

    @Test
    void correctSourceOnConnect() {
        Arc arc = new Arc();

    }

}