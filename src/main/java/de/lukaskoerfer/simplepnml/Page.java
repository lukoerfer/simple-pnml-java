package de.lukaskoerfer.simplepnml;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root
@NoArgsConstructor
public class Page implements Identifiable {

    @Attribute
    @Getter @Setter
    private String id;

    @Element(required = false)
    @Getter @Setter
    private Label name;

    @ElementList(required = false, inline = true)
    @Getter
    private List<Page> pages = new ArrayList<>();

    @ElementList(required = false, inline = true)
    @Getter
    private List<Place> places = new ArrayList<>();

    @ElementList(required = false, inline = true)
    @Getter
    private List<Transition> transitions = new ArrayList<>();

    @ElementList(required = false, inline = true)
    @Getter
    private List<Arc> arcs = new ArrayList<>();

}
