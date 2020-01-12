package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

import lombok.*;

/**
 * Represents a transition in a place/transition net
 */
@Builder
@EqualsAndHashCode
public class Transition implements Connectable, Collectable, Named, Node {

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
     * Gets the name of this transition
     * @return A label containing the name
     * -- SETTER --
     * Sets the name of this transition
     * @param name A label containing the name
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
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
        setId(id);
        setToolSpecificData(new ArrayList<>());
    }

    // Internal constructor for builder
    private Transition(String id, Label name, NodeGraphics graphics, List<ToolSpecific> toolSpecificData) {
        setId(id);
        setName(name);
        setGraphics(graphics);
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
     * Collects the child elements of this transition recursively
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(getName())
            .collect(getGraphics())
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

    @XmlElement(name = "graphics")
    private NodeGraphics getGraphicsXml() {
        return Objects.equals(getGraphics(), new NodeGraphics()) ? null : getGraphics();
    }

    private void setGraphicsXml(NodeGraphics graphics) {
        setGraphics(graphics);
    }
}
