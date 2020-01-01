package de.lukaskoerfer.simplepnml;

import lombok.*;

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
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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
    @Getter @Setter
    @XmlElement
    private Label name;

    /**
     * -- GETTER --
     * Gets the list of sub-pages of this page
     * @return A list of pages
     */
    @Getter @Setter
    @Singular
    @XmlElement
    private List<Page> pages;

    /**
     * -- GETTER --
     * Gets the list of places on this page
     * @return A list of places
     */
    @Getter @Setter
    @Singular
    @XmlElement
    private List<Place> places;

    /**
     * -- GETTER --
     * Gets the list of transitions on this page
     * @return A list of transitions
     */
    @Getter @Setter
    @Singular
    @XmlElement
    private List<Transition> transitions;

    /**
     * -- GETTER --
     * Gets the list of arcs on this page
     * @return A list of arcs
     */
    @Getter @Setter
    @Singular
    @XmlElement
    private List<Arc> arcs;

    /**
     * -- GETTER --
     * Gets the list of tool data related to this page
     * @return A list of tool data definitions
     */
    @Getter @Setter
    @XmlElement
    private List<ToolData> toolData;

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
        setPages(new ArrayList<>());
        setPlaces(new ArrayList<>());
        setTransitions(new ArrayList<>());
        setArcs(new ArrayList<>());
        setToolData(new ArrayList<>());
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
