package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToolSpecificTest {

    private ToolSpecific toolSpecific;

    @BeforeEach
    void setup() {
        toolSpecific = new ToolSpecific("ExampleTool", "1.0");
    }

    @Test
    void setTool_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            toolSpecific.setTool(null);
        });
    }

    @Test
    void setVersion_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            toolSpecific.setVersion(null);
        });
    }

    @Test
    void setContents_nullValue_fails() {
        assertThrows(IllegalArgumentException.class, () -> {
            toolSpecific.setContents(null);
        });
    }



}
