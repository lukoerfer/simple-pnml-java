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
 * Represents a place in a place/transition net
 */
@Builder
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Place implements Connectable, Collectable, Named, Node, ToolExtendable {

    /**
     * -- GETTER --
     * Gets the identifier
     * @return The identifier
     */
    @NonNull
    @Getter @Setter
    @XmlAttribute(required = true)
    private String id;

    /**
     * -- GETTER --
     * Gets the name of this place
     * @return A label containing the name
     * -- SETTER --
     * Sets the name of this place
     * @param name A label containing the name
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private Label name = new Label();

    /**
     * -- GETTER --
     * Gets the graphics of this place
     * @return A graphics description for a node element
     * -- SETTER --
     * Sets the graphics of this place
     * @param graphics A graphics description for a node element
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private NodeGraphics graphics = new NodeGraphics();

    /**
     * -- GETTER --
     * Gets the initial marking of this place
     * @return A label containing the initial marking
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private Label initialMarking = new Label();

    /**
     * -- GETTER --
     * Gets a list containing tool-specific data
     * @return A list of tool-specific data
     */
    @NonNull
    @Getter @Setter
    @Singular("toolSpecific")
    @XmlElement(name = "toolspecific")
    private List<ToolSpecific> toolSpecificData;

    /**
     * Creates a new place using a random identifier
     */
    public Place() {
        this(null);
    }

    /**
     * Creates a new place
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     */
    public Place(String id) {
        this.id = Objects.requireNonNullElseGet(id, Identifiable::randomId);
        this.toolSpecificData = new ArrayList<>();
    }

    // Internal constructor for builder
    @SuppressWarnings("unused")
    private Place(String id, Label name, NodeGraphics graphics, Label initialMarking, List<ToolSpecific> toolSpecificData) {
        this.id = Objects.requireNonNullElseGet(id, Identifiable::randomId);
        this.name = name;
        this.graphics = graphics;
        this.initialMarking = initialMarking;
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
            .include(graphics)
            .include(initialMarking)
            .include(toolSpecificData)
            .collect();
    }

    //region Internal serialization

    @XmlElement(name = "name")
    @SuppressWarnings("unused")
    private Label getNameXml() {
        return Defaults.requireNonDefault(getName());
    }

    @SuppressWarnings("unused")
    private void setNameXml(Label name) {
        setName(name);
    }

    @XmlElement(name = "graphics")
    @SuppressWarnings("unused")
    private NodeGraphics getGraphicsXml() {
        return Defaults.requireNonDefault(getGraphics());
    }

    @SuppressWarnings("unused")
    private void setGraphicsXml(NodeGraphics graphics) {
        setGraphics(graphics);
    }

    @XmlElement(name = "initialMarking")
    @SuppressWarnings("unused")
    private Label getInitialMarkingXml() {
        return Defaults.requireNonDefault(getInitialMarking());
    }

    @SuppressWarnings("unused")
    private void setInitialMarkingXml(Label initialMarking) {
        setInitialMarking(initialMarking);
    }

    //endregion

}
