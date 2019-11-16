package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
public class Page extends Identifiable {

    @XmlElement
    @Getter @Setter
    private Label name;

    @XmlElement
    @Getter
    private List<Page> pages = new ArrayList<>();

    @XmlElement
    @Getter
    private List<Place> places = new ArrayList<>();

    @XmlElement
    @Getter
    private List<Transition> transitions = new ArrayList<>();

    @XmlElement
    @Getter
    private List<Arc> arcs = new ArrayList<>();

    @XmlElement
    @Getter
    private List<ToolData> toolData = new ArrayList<>();

    public Page() {
        this(null);
    }

    public Page(String id) {
        this(id, null);
    }

    public Page(String id, Label name) {
        setId(id);
        setName(name);
    }

    public Page withName(String name) {
        setName(new Label(name));
        return this;
    }

    public Page withName(Label name) {
        setName(name);
        return this;
    }

    public Page withPages(Page... pages) {
        this.pages.addAll(Arrays.asList(pages));
        return this;
    }

    public Page withPlaces(Place... places) {
        this.places.addAll(Arrays.asList(places));
        return this;
    }

    public Page withTransitions(Transition... transitions) {
        this.transitions.addAll(Arrays.asList(transitions));
        return this;
    }
    
    public Page withArcs(Arc... arcs) {
        this.arcs.addAll(Arrays.asList(arcs));
        return this;
    }
}
