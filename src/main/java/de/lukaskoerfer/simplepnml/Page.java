package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Represents a page of a place/transition net
 */
@Builder
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Page implements Identifiable, Collectable, Named, ToolExtendable {

    /**
     * -- GETTER --
     * Gets the identifier
     * @return The identifier
     */
    @NonNull
    @Getter @Setter
    @XmlAttribute(name = "id", required = true)
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
        this.id = Objects.requireNonNullElseGet(id, Identifiable::randomId);
        this.pages = new ArrayList<>();
        this.places = new ArrayList<>();
        this.transitions = new ArrayList<>();
        this.arcs = new ArrayList<>();
        this.toolSpecificData = new ArrayList<>();
    }

    // Internal constructor for builder
    @SuppressWarnings("unused")
    private Page(String id, Label name, List<Page> pages, List<Place> places, List<Transition> transitions, List<Arc> arcs, List<ToolSpecific> toolSpecificData) {
        this.id = Objects.requireNonNullElseGet(id, Identifiable::randomId);
        this.name = name;
        this.pages = new ArrayList<>(pages);
        this.places = new ArrayList<>(places);
        this.transitions = new ArrayList<>(transitions);
        this.arcs = new ArrayList<>(arcs);
        this.toolSpecificData = new ArrayList<>(toolSpecificData);
    }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(name)
            .include(pages)
            .include(places)
            .include(transitions)
            .include(arcs)
            .include(toolSpecificData)
            .collect();
    }

    //region Internal serialization

    @XmlAttribute(name = "name")
    @SuppressWarnings("unused")
    private Label getNameXml() {
        return Defaults.requireNonDefault(getName());
    }

    @SuppressWarnings("unused")
    private void setNameXml(Label name) {
        setName(name);
    }

    //endregion

}
