package de.lukaskoerfer.simplepnml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Arc {

    @Attribute
    private String id;

    @Attribute
    private String source;

    @Attribute
    private String target;

    @Element(required = false)
    private Label inscription;

}
