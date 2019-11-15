package de.lukaskoerfer.simplepnml;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PageTest {

    static EasyRandom random = new EasyRandom();

    static Stream<String> ids() {
        return Stream.of(null, "", "   ", "test");
    }

    @ParameterizedTest
    @MethodSource("ids")
    void createAssignsValidId(String id) {
        Page page = new Page(id);
        assertNotNull(page.getId());
        assertTrue(page.getId().length() > 0);
        assertTrue(page.getId().trim().length() > 0);
    }

    @Test
    void withPagesAddsPages() {
        Page page1 = random.nextObject(Page.class), page2 = random.nextObject(Page.class);
        Page page = new Page().withPages(page1, page2);
        assertEquals(2, page.getPages().size());
    }

    @Test
    void withPlacesAddsPlaces() {
        Place place1 = random.nextObject(Place.class), place2 = random.nextObject(Place.class);
        Page page = new Page().withPlaces(place1, place2);
        assertEquals(2, page.getPlaces().size());
    }

    @Test
    void withTransitionsAddsTransitions() {
        Transition transition1 = random.nextObject(Transition.class), transition2 = random.nextObject(Transition.class);
        Page page = new Page().withTransitions(transition1, transition2);
        assertEquals(2, page.getTransitions().size());
    }

    @Test
    void withArcsAddsArcs() {
        Arc arc1 = random.nextObject(Arc.class), arc2 = random.nextObject(Arc.class);
        Page page = new Page().withArcs(arc1, arc2);
        assertEquals(2, page.getArcs().size());
    }

}