package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.Test;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void serialize() throws Exception {
        Coordinates coordinates = new Coordinates(0, 0);
        Persister persister = new Persister();
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            persister.write(coordinates, stream);
            String output = new String(stream.toByteArray(), StandardCharsets.UTF_8);
            System.out.println(output);
        }
    }

}