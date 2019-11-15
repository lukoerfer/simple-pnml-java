package de.lukaskoerfer.simplepnml;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnnotationTest {

    static EasyRandom random = new EasyRandom();

    @Test
    void canCreate() {
        double x = random.nextDouble(), y = random.nextDouble();
        Fill fill = random.nextObject(Fill.class);
        Line line = random.nextObject(Line.class);
        Font font = random.nextObject(Font.class);
        Annotation annotation = new Annotation(x, y, fill, line, font);
        assertEquals(x, annotation.getOffset().getX());
        assertEquals(y, annotation.getOffset().getY());
        assertEquals(fill, annotation.getFill());
        assertEquals(line, annotation.getLine());
        assertEquals(font, annotation.getFont());
    }

    @Test
    void canCreateFluently() {
        double x = random.nextDouble(), y = random.nextDouble();
        Fill fill = random.nextObject(Fill.class);
        Line line = random.nextObject(Line.class);
        Font font = random.nextObject(Font.class);
        Annotation annotation = new Annotation()
            .offset(x, y)
            .withFill(fill)
            .withLine(line)
            .withFont(font);
        assertEquals(x, annotation.getOffset().getX());
        assertEquals(y, annotation.getOffset().getY());
        assertEquals(fill, annotation.getFill());
        assertEquals(line, annotation.getLine());
        assertEquals(font, annotation.getFont());
    }


}
