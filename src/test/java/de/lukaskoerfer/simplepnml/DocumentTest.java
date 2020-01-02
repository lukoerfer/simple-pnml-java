package de.lukaskoerfer.simplepnml;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import static de.lukaskoerfer.simplepnml.StreamUtil.ofType;
import static org.jeasy.random.FieldPredicates.inClass;
import static org.jeasy.random.FieldPredicates.named;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DocumentTest {

    static EasyRandom random = new EasyRandom(new EasyRandomParameters()
        .overrideDefaultInitialization(true)
        .collectionSizeRange(1, 2)
        .excludeField(named("pages").and(inClass(Page.class)))
        .excludeField(named("contents").and(inClass(ToolData.class))));

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