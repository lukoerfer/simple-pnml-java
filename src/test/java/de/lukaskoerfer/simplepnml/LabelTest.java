package de.lukaskoerfer.simplepnml;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class LabelTest {

    @Test
    void equalsAfterSerialization() throws Exception {
        EasyRandom random = new EasyRandom();
        Label input = random.nextObject(Label.class);
        Persister persister = new Persister();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        persister.write(input, out);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        Label output = persister.read(Label.class, in);
        assertEquals(input, output);
    }

    @Test
    void validAbsolute() {
        EasyRandom random = new EasyRandom();
        int x = random.nextInt(), y = random.nextInt();
        String text = random.nextObject(String.class);
        Label label = Label.absolute(x, y, text);
        assertNotNull(label.getGraphics().getPosition());
        assertNull(label.getGraphics().getOffset());
    }

    @Test
    void validRelative() {
        EasyRandom random = new EasyRandom();
        int x = random.nextInt(), y = random.nextInt();
        String text = random.nextObject(String.class);
        Label label = Label.relative(x, y, text);
        assertNotNull(label.getGraphics().getOffset());
        assertNull(label.getGraphics().getPosition());
    }

}