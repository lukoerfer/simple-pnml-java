package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Represents a page of a place/transition net
 */
@Builder
@EqualsAndHashCode
public class Page implements Identifiable, Collectable, Named {

    /**
     * -- GETTER --
     * Gets the identifier
     * @return The identifier
     */
    @Getter
    @XmlAttribute(required = true)
    private String id;

    /**
     * -- GETTER --
     * Gets the name of the page
     * @return A label containing the name
     * -- SETTER --
     * Sets the name of the page
     * @param name A label containing the name
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private Label name = new Label();

    /**
     * -- GETTER --
     * Gets the list of sub-pages of this page
     * @return A list of pages
     */
    @NonNull
    @Getter @Setter
    @Singular
    @XmlElement(name = "page")
    private List<Page> pages;

    /**
     * -- GETTER --
     * Gets the list of places on this page
     * @return A list of places
     */
    @NonNull
    @Getter @Setter
    @Singular
    @XmlElement(name = "place")
    private List<Place> places;

    /**
     * -- GETTER --
     * Gets the list of transitions on this page
     * @return A list of transitions
     */
    @NonNull
    @Getter @Setter
    @Singular
    @XmlElement(name = "transition")
    private List<Transition> transitions;

    /**
     * -- GETTER --
     * Gets the list of arcs on this page
     * @return A list of arcs
     */
    @NonNull
    @Getter @Setter
    @Singular
    @XmlElement(name = "arc")
    private List<Arc> arcs;

    /**
     * -- GETTER --
     * Gets the list of tool data related to this page
     * @return A list of tool data definitions
     */
    @NonNull
    @Getter @Setter
    @Singular("toolSpecific")
    @XmlElement(name = "toolspecific")
    private List<ToolSpecific> toolSpecificData;

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
        setToolSpecificData(new ArrayList<>());
    }

    // Internal constructor for builder
    private Page(String id, Label name, List<Page> pages, List<Place> places, List<Transition> transitions, List<Arc> arcs, List<ToolSpecific> toolSpecificData) {
        setId(id);
        setName(name);
        setPages(new ArrayList<>(pages));
        setPlaces(new ArrayList<>(places));
        setTransitions(new ArrayList<>(transitions));
        setArcs(new ArrayList<>(arcs));
        setToolSpecificData(new ArrayList<>(toolSpecificData));
    }

    /**
     * Sets the identifier, defaults to a random UUID if null, empty or whitespace
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     */
    public void setId(String id) {
        this.id = id != null ? id : UUID.randomUUID().toString();
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
            .collect(getToolSpecificData())
            .build();
    }

    @XmlElement(name = "name")
    private Label getNameXml() {
        return Objects.equals(getName(), new Label()) ? null : getName();
    }

    private void setNameXml(Label name) {
        setName(name);
    }
}
