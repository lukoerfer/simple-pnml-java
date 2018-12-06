package de.lukaskoerfer.simplepnml;

import org.simpleframework.xml.Element;

public class Label {

    @Element
    private String text;

    @Element(required = false)
    private Graphics graphics;

}
