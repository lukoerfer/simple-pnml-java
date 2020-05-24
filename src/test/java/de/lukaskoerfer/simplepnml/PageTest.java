package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PageTest {

    @Test
    void canCreate() {
        Page page = new Page();
        assertNotNull(page.getId());
        assertFalse(page.getId().isEmpty());
        assertTrue(page.collect().count() > 1);
    }

    @Test
    void canCreateUsingBuilder() {
        String id = "my-page";
        Page page = Page.builder()
            .id(id)
            .build();
        assertEquals(id, page.getId());
        assertTrue(page.collect().count() > 1);
    }

}