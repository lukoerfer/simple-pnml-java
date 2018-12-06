package de.lukaskoerfer.simplepnml;

import org.simpleframework.xml.Element;

public class Graphics {

    @Element(required = false)
    private Coordinates position;

    @Element(required = false)
    private Coordinates offset;


}
