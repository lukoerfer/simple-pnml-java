package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AnnotationGraphicsTest {

    @Test
    void canCreate() {
        AnnotationGraphics graphics = new AnnotationGraphics();
        assertTrue(graphics.isDefault());
        assertTrue(graphics.collect().count() > 1);
    }

    @Test
    void canCreateUsingBuilder() {
        AnnotationGraphics graphics = AnnotationGraphics.builder()
            .offset(new Offset(1.4, 3.2))
            .build();
        assertFalse(graphics.isDefault());
        assertTrue(graphics.collect().count() > 1);
    }


}
