package de.lukaskoerfer.simplepnml;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DocumentTest {

    static EasyRandom random = new EasyRandom();

    @Test
    void equalsAfterSerialization() throws Exception {
        Document input = random.nextObject(Document.class);
        JAXBContext context = JAXBContext.newInstance(Document.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        context.createMarshaller().marshal(input, out);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        Document output = (Document) context.createUnmarshaller().unmarshal(in);
        assertEquals(input, output);
    }

}