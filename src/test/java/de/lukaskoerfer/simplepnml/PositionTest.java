package de.lukaskoerfer.simplepnml;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    static EasyRandom random = new EasyRandom();

    @Test
    void canCreate() {
        double x = random.nextDouble(), y = random.nextDouble();
        Position position = new Position(x, y);
        assertEquals(x, position.getX());
        assertEquals(y, position.getY());
    }

}