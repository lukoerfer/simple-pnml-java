package de.lukaskoerfer.simplepnml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ToolSpecificTest {

    private ToolSpecific toolSpecific;

    @BeforeEach
    void setup() {
        toolSpecific = new ToolSpecific("ExampleTool", "1.0");
    }



}
