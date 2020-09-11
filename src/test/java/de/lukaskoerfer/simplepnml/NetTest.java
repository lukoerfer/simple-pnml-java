package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetTest {

    private Net net;

    @BeforeEach
    void setup() {
        net = new Net();
    }

    @Test
    void getId_newInstance_notNullOrEmpty() {
        var id = net.getId();

        assertNotNull(id);
        assertFalse(id.isEmpty());
    }

    @Test
    void getType_newInstance_notNullOrEmpty() {
        var type = net.getType();

        assertNotNull(type);
        assertFalse(type.isEmpty());
    }

    @Test
    void setId_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            net.setId(null);
        });
    }

    @Test
    void setType_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            net.setType(null);
        });
    }

    @Test
    void setName_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            net.setName(null);
        });
    }

    @Test
    void setPages_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            net.setPages(null);
        });
    }

    @Test
    void setToolSpecifics_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            net.setToolSpecifics(null);
        });
    }

    @Test
    void collect_newInstance_containsMoreThanOneElement() {
        var elements = net.collect();

        assertTrue(elements.count() > 1);
    }

    @Test
    void collect_withAdditionalPage_containsMoreElements() {
        var countBefore = net.collect().count();

        net.getPages().add(new Page());

        assertTrue(net.collect().count() > countBefore);
    }

    @Test
    void collect_withAdditionalToolSpecific_containsMoreElements() {
        var countBefore = net.collect().count();

        net.getToolSpecifics().add(new ToolSpecific("ExampleTool", "1.0"));

        assertTrue(net.collect().count() > countBefore);
    }

}