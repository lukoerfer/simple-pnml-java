package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PageTest {

    private Page page;

    @BeforeEach
    void setup() {
        page = new Page();
    }

    @Test
    void getId_newInstance_notNullOrEmpty() {
        String id = page.getId();

        assertNotNull(id);
        assertFalse(id.isEmpty());
    }

    @Test
    void setId_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            page.setId(null);
        });
    }

    @Test
    void setName_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            page.setName(null);
        });
    }

    @Test
    void setPages_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            page.setPages(null);
        });
    }

    @Test
    void setPlaces_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            page.setPlaces(null);
        });
    }

    @Test
    void setTransitions_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            page.setTransitions(null);
        });
    }

    @Test
    void setArcs_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            page.setArcs(null);
        });
    }

    @Test
    void setToolSpecifics_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            page.setToolSpecifics(null);
        });
    }

    @Test
    void collect_newInstance_containsMoreThanOneElement() {
        var elements = page.collect();

        assertTrue(elements.count() > 1);
    }

    @Test
    void collect_withAdditionalPage_containsMoreElements() {
        var countBefore = page.collect().count();

        page.getPages().add(new Page());

        assertTrue(page.collect().count() > countBefore);
    }

    @Test
    void collect_withAdditionalPlace_containsMoreElements() {
        var countBefore = page.collect().count();

        page.getPlaces().add(new Place());

        assertTrue(page.collect().count() > countBefore);
    }

    @Test
    void collect_withAdditionalTransition_containsMoreElements() {
        var countBefore = page.collect().count();

        page.getTransitions().add(new Transition());

        assertTrue(page.collect().count() > countBefore);
    }

    @Test
    void collect_withAdditionalArc_containsMoreElements() {
        var countBefore = page.collect().count();

        page.getArcs().add(new Arc());

        assertTrue(page.collect().count() > countBefore);
    }

    @Test
    void collect_withAdditionalToolSpecific_containsMoreElements() {
        var countBefore = page.collect().count();

        page.getToolSpecifics().add(new ToolSpecific("my-tool", "1.0.0"));

        assertTrue(page.collect().count() > countBefore);
    }

}