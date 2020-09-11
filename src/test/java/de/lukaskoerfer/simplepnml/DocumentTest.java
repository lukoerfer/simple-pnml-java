package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentTest {

    private Document document;

    @BeforeEach
    void setup() {
        document = new Document();
    }

    @Test
    void setNets_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            document.setNets(null);
        });
    }

    @Test
    void collect_newInstance_containsOneElement() {
        var elements = document.collect();

        assertEquals(1, elements.count());
    }
}