package de.lukaskoerfer.simplepnml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root
public class Page {

    @Attribute
    private String id;

    @Element(required = false)
    private Label name;

    @ElementList(required = false, inline = true)
    private List<Page> pages = new ArrayList<>();

    @ElementList(required = false, inline = true)
    private List<Place> places = new ArrayList<>();

    @ElementList(required = false, inline = true)
    private List<Transition> transitions = new ArrayList<>();

    @ElementList(required = false, inline = true)
    private List<Arc> arcs = new ArrayList<>();

}
