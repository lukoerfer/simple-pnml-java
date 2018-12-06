package de.lukaskoerfer.simplepnml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Place {

    @Attribute
    private String id;

    @Element(required = false)
    private Label name;

    @Element(required = false)
    private Graphics graphics;

    @Element(required = false)
    private Label initialMarking;

}
