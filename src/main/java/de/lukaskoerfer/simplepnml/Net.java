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
 * Represents a place/transition net
 */
@Builder
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Net implements Identifiable, Named, Collectable {

    /**
     * Defines the identifier for Place-Transition (PT) nets
     */
    public static final String PLACE_TRANSITION_TYPE = "http://www.pnml.org/version-2009/grammar/ptnet";

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
     * Gets the net type
     * @return
     */
    @NonNull
    @Getter @Setter
    @XmlAttribute(name = "type", required = true)
    private String type;

    /**
     * -- GETTER --
     * Gets the label containing the name
     * @return A label containing the name
     * -- SETTER --
     * Sets the label containing the name
     * @param name A label containing the name
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlElement(name = "name")
    private Label name = new Label();

    /**
     * -- GETTER --
     * Gets the pages of the net
     * @return A list of pages
     */
    @NonNull
    @Getter @Setter
    @Singular
    @XmlElement(name = "page")
    private List<Page> pages;

    /**
     * -- GETTER --
     * Gets tool-specific data related to the net
     * @return A list of tool data definitions
     */
    @NonNull
    @Getter @Setter
    @Singular("toolSpecific")
    @XmlElement(name = "toolspecific")
    private List<ToolSpecific> toolSpecificData;

    /**
     * Creates a new net using a random identifier
     */
    public Net() {
        this(null);
    }

    /**
     * Creates a new net
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     */
    public Net(String id) {
        this(id, null);
    }

    /**
     * Creates a new net
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     * @param type
     */
    public Net(String id, String type) {
        this.id = Objects.requireNonNullElseGet(id, Identifiable::randomId);
        this.type = Objects.requireNonNullElse(type, PLACE_TRANSITION_TYPE);
        this.pages = new ArrayList<>();
        this.toolSpecificData = new ArrayList<>();
    }

    // Internal constructor for builder
    private Net(String id, String type, Label name, List<Page> pages, List<ToolSpecific> toolSpecificData) {
        this.id = Objects.requireNonNullElseGet(id, Identifiable::randomId);
        this.type = Objects.requireNonNullElse(type, PLACE_TRANSITION_TYPE);
        this.name = name;
        this.pages = new ArrayList<>(pages);
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
            .include(toolSpecificData)
            .collect();
    }

}
