package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Represents a page of a place/transition net
 */
@EqualsAndHashCode(callSuper = true)
public class Page extends Identifiable implements Collectable, Named {

    /**
     * -- GETTER --
     * Gets the name of the page
     * @return A label containing the name
     * -- SETTER --
     * Sets the name of the page
     * @param name A label containing the name
     */
    @XmlElement
    @Getter @Setter
    private Label name;

    /**
     * -- GETTER --
     * Gets the list of sub-pages of this page
     * @return A list of pages
     */
    @XmlElement
    @Getter
    private List<Page> pages = new ArrayList<>();

    /**
     * -- GETTER --
     * Gets the list of places on this page
     * @return A list of places
     */
    @XmlElement
    @Getter
    private List<Place> places = new ArrayList<>();

    /**
     * -- GETTER --
     * Gets the list of transitions on this page
     * @return A list of transitions
     */
    @XmlElement
    @Getter
    private List<Transition> transitions = new ArrayList<>();

    /**
     * -- GETTER --
     * Gets the list of arcs on this page
     * @return A list of arcs
     */
    @XmlElement
    @Getter
    private List<Arc> arcs = new ArrayList<>();

    /**
     * -- GETTER --
     * Gets the list of tool data related to this page
     * @return A list of tool data definitions
     */
    @XmlElement
    @Getter
    private List<ToolData> toolData = new ArrayList<>();

    /**
     * Creates a new page using a random identifier
     */
    public Page() {
        this(null);
    }

    /**
     * Creates a new page
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     */
    public Page(String id) {
        this(id, null);
    }

    /**
     * Creates a new page
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     * @param name A label containing the name
     */
    public Page(String id, Label name) {
        setId(id);
        setName(name);
    }

    /**
     *
     * @param action
     * @return
     */
    public Page with(Consumer<Page> action) {
        action.accept(this);
        return this;
    }

    /**
     * Sets the name of the page
     * @param name A string containing the name
     * @return A reference to this page
     */
    public Page withName(String name) {
        setName(new Label(name));
        return this;
    }

    /**
     * Sets the name of the page
     * @param name A label containing the name
     * @return A reference to this page
     */
    public Page withName(Label name) {
        setName(name);
        return this;
    }

    /**
     * Adds sub-pages to the page
     * @param pages A list of pages
     * @return A reference to this page
     */
    public Page withPages(Page... pages) {
        this.pages.addAll(Arrays.asList(pages));
        return this;
    }

    /**
     * Adds places to the page
     * @param places A list of places
     * @return A reference to this page
     */
    public Page withPlaces(Place... places) {
        this.places.addAll(Arrays.asList(places));
        return this;
    }

    /**
     * Adds transitions to the page
     * @param transitions A list of transitions
     * @return A reference to this page
     */
    public Page withTransitions(Transition... transitions) {
        this.transitions.addAll(Arrays.asList(transitions));
        return this;
    }

    /**
     * Adds arcs to the page
     * @param arcs A list of arcs
     * @return A reference to this page
     */
    public Page withArcs(Arc... arcs) {
        this.arcs.addAll(Arrays.asList(arcs));
        return this;
    }

    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(name)
            .collect(pages)
            .collect(places)
            .collect(transitions)
            .collect(arcs)
            .collect(toolData)
            .build();
    }
}
