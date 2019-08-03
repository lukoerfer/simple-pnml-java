package de.lukaskoerfer.simplepnml;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class GraphicsTest {

    @Test
    void equalsAfterSerialization() throws Exception {
        EasyRandom random = new EasyRandom();
        Graphics input = random.nextObject(Graphics.class);
        Persister persister = new Persister();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        persister.write(input, out);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        Graphics output = persister.read(Graphics.class, in);
        assertEquals(input, output);
    }

    @Test
    void validAbsolute() {
        EasyRandom random = new EasyRandom();
        int x = random.nextInt(), y = random.nextInt();
        Graphics graphics = Graphics.absolute(x, y);
        assertNotNull(graphics.getPosition());
        assertNull(graphics.getOffset());
    }

    @Test
    void validRelative() {
        EasyRandom random = new EasyRandom();
        int x = random.nextInt(), y = random.nextInt();
        Graphics graphics = Graphics.relative(x, y);
        assertNotNull(graphics.getOffset());
        assertNull(graphics.getPosition());
    }

}