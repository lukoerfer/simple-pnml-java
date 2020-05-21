package de.lukaskoerfer.simplepnml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Singular;

import static de.lukaskoerfer.simplepnml.Defaults.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Represents a page of a place/transition net
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Page implements Identifiable, Collectable, Named, ToolExtendable {

    private String id;
    private Label name;
    private List<Page> pages;
    private List<Place> places;
    private List<Transition> transitions;
    private List<Arc> arcs;
    private List<ToolSpecific> toolSpecifics;

    /**
     * Creates a new page using a random identifier
     */
    public Page() { }

    /**
     * Creates a new page
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     */
    public Page(String id) {
        this.id = id;
    }

    @Builder
    private Page(String id, Label name,
                 @Singular List<Page> pages,
                 @Singular List<Place> places,
                 @Singular List<Transition> transitions,
                 @Singular List<Arc> arcs,
                 @Singular List<ToolSpecific> toolSpecifics) {
        this.id = id;
        this.name = name;
        this.pages = new ArrayList<>(pages);
        this.places = new ArrayList<>(places);
        this.transitions = new ArrayList<>(transitions);
        this.arcs = new ArrayList<>(arcs);
        this.toolSpecifics = new ArrayList<>(toolSpecifics);
    }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(getName())
            .include(getPages())
            .include(getPlaces())
            .include(getTransitions())
            .include(getArcs())
            .include(getToolSpecifics())
            .collect();
    }

    @XmlAttribute(name = "id", required = true)
    public String getId() {
        return requireNonNullElseGet(id, () -> id = Identifiable.randomId());
    }

    public void setId(String id) {
        this.id = id;
    }

    public Label getName() {
        return requireNonNullElseGet(name, () -> name = new Label());
    }

    public void setName(Label name) {
        this.name = name;
    }

    public List<Page> getPages() {
        return requireNonNullElseGet(pages, () -> pages = new ArrayList<>());
    }

    public void setPages(List<Page> pages) {
        this.pages = new ArrayList<>(pages);
    }

    public List<Place> getPlaces() {
        return requireNonNullElseGet(places, () -> places = new ArrayList<>());
    }

    public void setPlaces(List<Place> places) {
        this.places = new ArrayList<>(places);
    }

    public List<Transition> getTransitions() {
        return requireNonNullElseGet(transitions, () -> transitions = new ArrayList<>());
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = new ArrayList<>(transitions);
    }

    public List<Arc> getArcs() {
        return requireNonNullElseGet(arcs, () -> arcs = new ArrayList<>());
    }

    public void setArcs(List<Arc> arcs) {
        this.arcs = new ArrayList<>(arcs);
    }

    @Override
    public List<ToolSpecific> getToolSpecifics() {
        return requireNonNullElseGet(toolSpecifics, () -> toolSpecifics = new ArrayList<>());
    }

    @Override
    public void setToolSpecifics(List<ToolSpecific> toolSpecificData) {
        this.toolSpecifics = new ArrayList<>(toolSpecificData);
    }

    @XmlElement(name = "name")
    @SuppressWarnings("unused")
    private Label getNameXml() {
        return requireNonDefaultElseNull(getName());
    }

    @SuppressWarnings("unused")
    private void setNameXml(Label name) {
        setName(name);
    }

}
