package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AnnotationGraphicsTest {

    @Test
    void canCreate() {
        AnnotationGraphics graphics = new AnnotationGraphics();
        assertTrue(graphics.isDefault());
    }

    @Test
    void canCreateUsingBuilder() {
        AnnotationGraphics graphics = AnnotationGraphics.builder()
            .build();
    }


}
