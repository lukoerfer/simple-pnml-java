package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ToolSpecificTest {

    @Test
    void canCreate() {
        String tool = "MyTool", version = "1.0";
        ToolSpecific toolSpecific = new ToolSpecific(tool, version);
        assertEquals(tool, toolSpecific.getTool());
        assertEquals(version, toolSpecific.getVersion());
        assertTrue(toolSpecific.getContents().isEmpty());
    }

    @Test
    void canCreateUsingBuilder() {
        String tool = "MyTool", version = "1.0";
        ToolSpecific toolSpecific = ToolSpecific.builder()
            .tool(tool)
            .version(version)
            .content("MyContent")
            .build();
        assertEquals(tool, toolSpecific.getTool());
        assertEquals(version, toolSpecific.getVersion());
        assertEquals(1, toolSpecific.getContents().size());
    }

}
