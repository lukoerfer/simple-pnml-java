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
    }
}