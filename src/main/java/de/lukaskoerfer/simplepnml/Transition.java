package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import lombok.*;

/**
 * Represents a transition in a place/transition net
 */
@Builder
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Transition implements Connectable, Collectable, Named, Node, ToolExtendable {

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
     * Gets the name of this transition
     * @return A label containing the name
     * -- SETTER --
     * Sets the name of this transition
     * @param name A label containing the name
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlTransient
    private Label name = new Label();

    /**
     * -- GETTER --
     * Gets the graphics of this transition
     * @return A graphics description
     * -- SETTER --
     * Sets the graphics of this transition
     * @param graphics A graphics description
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlTransient
    private NodeGraphics graphics = new NodeGraphics();

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
     * Creates a new transition with a random identifier
     */
    public Transition() {
        this(null);
    }

    /**
     * Creates a new transition
     */
    public Transition(String id) {
        this.id = Objects.requireNonNullElseGet(id, Identifiable::randomId);
        this.toolSpecificData = new ArrayList<>();
    }

    // Internal constructor for builder
    @SuppressWarnings("unused")
    private Transition(String id, Label name, NodeGraphics graphics, List<ToolSpecific> toolSpecificData) {
        this.id = Objects.requireNonNullElseGet(id, Identifiable::randomId);
        this.name = name;
        this.graphics = graphics;
        this.toolSpecificData = new ArrayList<>(toolSpecificData);
    }

    /**
     * Collects the child elements of this transition recursively
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(name)
            .include(graphics)
            .include(toolSpecificData)
            .collect();
    }

    //region Internal serialization

    @XmlElement(name = "name")
    @SuppressWarnings("unused")
    private Label getNameXml() {
        return Defaults.requireNonDefault(name);
    }

    @SuppressWarnings("unused")
    private void setNameXml(Label name) {
        this.name = name;
    }

    @XmlElement(name = "graphics")
    @SuppressWarnings("unused")
    private NodeGraphics getGraphicsXml() {
        return Defaults.requireNonDefault(graphics);
    }

    @SuppressWarnings("unused")
    private void setGraphicsXml(NodeGraphics graphics) {
        this.graphics = graphics;
    }

    //endregion

}
