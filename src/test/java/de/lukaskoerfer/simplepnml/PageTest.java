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

class PageTest {

    @Test
    void equalsAfterSerialization() throws Exception {
        EasyRandom random = new EasyRandom();
        Page input = random.nextObject(Page.class);
        Persister persister = new Persister();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        persister.write(input, out);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        Page output = persister.read(Page.class, in);
        assertEquals(input, output);
    }

    static Stream<String> ids() {
        return Stream.of(null, "", "   ", "test");
    }

    @ParameterizedTest
    @MethodSource("ids")
    void createAssignsValidId(String id) {
        Page page = Page.create(id);
        assertNotNull(page.getId());
        assertTrue(page.getId().length() > 0);
        assertTrue(page.getId().trim().length() > 0);
    }

    @Test
    void withPagesAddsPages() {
        EasyRandom random = new EasyRandom();
        Page page1 = random.nextObject(Page.class), page2 = random.nextObject(Page.class);
        Page page = new Page().withPages(page1, page2);
        assertEquals(2, page.getPages().size());
    }

    @Test
    void withPlacesAddsPlaces() {
        EasyRandom random = new EasyRandom();
        Place place1 = random.nextObject(Place.class), place2 = random.nextObject(Place.class);
        Page page = new Page().withPlaces(place1, place2);
        assertEquals(2, page.getPlaces().size());
    }

    @Test
    void withTransitionsAddsTransitions() {
        EasyRandom random = new EasyRandom();
        Transition transition1 = random.nextObject(Transition.class), transition2 = random.nextObject(Transition.class);
        Page page = new Page().withTransitions(transition1, transition2);
        assertEquals(2, page.getTransitions().size());
    }

    @Test
    void withArcsAddsArcs() {
        EasyRandom random = new EasyRandom();
        Arc arc1 = random.nextObject(Arc.class), arc2 = random.nextObject(Arc.class);
        Page page = new Page().withArcs(arc1, arc2);
        assertEquals(2, page.getArcs().size());
    }

}