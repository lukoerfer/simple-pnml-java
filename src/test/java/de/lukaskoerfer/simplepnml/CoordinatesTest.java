package de.lukaskoerfer.simplepnml;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinatesTest {

    static EasyRandom random = new EasyRandom();

    @Test
    void canCreate() {
        double x = random.nextDouble(), y = random.nextDouble();
        Coordinates coordinates = new Coordinates(x, y);
        assertEquals(x, coordinates.getX());
        assertEquals(y, coordinates.getY());
    }

}