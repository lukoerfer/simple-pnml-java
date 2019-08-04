package de.lukaskoerfer.simplepnml;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class PNMLTest {

    @Test
    void equalsAfterSerialization() throws Exception {
        EasyRandom random = new EasyRandom();
        PNML input = random.nextObject(PNML.class);
        Persister persister = new Persister();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        persister.write(input, out);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        PNML output = persister.read(PNML.class, in);
        assertEquals(input, output);
    }


}