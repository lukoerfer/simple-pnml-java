package de.lukaskoerfer.simplepnml;

import lombok.Builder;
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
@Builder
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
        setId(id);
    }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(getName())
            .collect(getPages())
            .collect(getPlaces())
            .collect(getTransitions())
            .collect(getArcs())
            .collect(getToolData())
            .build();
    }
}
