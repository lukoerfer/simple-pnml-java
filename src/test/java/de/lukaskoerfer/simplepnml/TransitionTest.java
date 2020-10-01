package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TransitionTest {

    private Transition transition;

    @BeforeEach
    void setup() {
        transition = new Transition();
    }

    @Test
    void getId_newInstance_notNullOrEmpty() {
        String id = transition.getId();

        assertNotNull(id);
        assertFalse(id.isEmpty());
    }

    @Test
    void setId_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            transition.setId(null);
        });
    }

    @Test
    void setName_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            transition.setName(null);
        });
    }

    @Test
    void setGraphics_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            transition.setGraphics(null);
        });
    }

    @Test
    void setToolSpecifics_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            transition.setToolSpecifics(null);
        });
    }

    @Test
    void collect_newInstance_containsMoreThanOneElement() {
        var elements = transition.collect();

        assertTrue(elements.count() > 1);
    }

    @Test
    void collect_withAdditionalToolSpecific_containsMoreElements() {
        var countBefore = transition.collect().count();

        transition.getToolSpecifics().add(new ToolSpecific("my-tool", "1.0.0"));

        assertTrue(transition.collect().count() > countBefore);
    }

}