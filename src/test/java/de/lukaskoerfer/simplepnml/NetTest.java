package de.lukaskoerfer.simplepnml;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NetTest {

    @Test
    void equalsAfterSerialization() throws Exception {
        EasyRandom random = new EasyRandom();
        Net input = random.nextObject(Net.class);
        Persister persister = new Persister();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        persister.write(input, out);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        Net output = persister.read(Net.class, in);
        assertEquals(input, output);
    }

    static Stream<String> ids() {
        return Stream.of(null, "", "   ", "test");
    }

    @ParameterizedTest
    @MethodSource("ids")
    void createAssignsValidId(String id) {
        Net net = Net.create(id);
        assertNotNull(net.getId());
        assertTrue(net.getId().length() > 0);
        assertTrue(net.getId().trim().length() > 0);
    }

    @Test
    void withPagesAddsPages() {
        EasyRandom random = new EasyRandom();
        Page page1 = random.nextObject(Page.class), page2 = random.nextObject(Page.class);
        Net net = new Net().withPages(page1, page2);
        assertEquals(2, net.getPages().size());
    }

}