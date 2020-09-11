package de.lukaskoerfer.simplepnml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Represents a place in a petri net
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Place implements Connectable, Collectable, Named, Node, ToolExtendable {

    private String id;
    private Label name;
    private NodeGraphics graphics;
    private Label initialMarking;
    private List<ToolSpecific> toolSpecifics;

    /**
     * Creates a new place
     */
    public Place() { }

    /**
     * Creates a new place
     * @param id An unique identifier
     */
    public Place(String id) {
        this.id = id;
    }

    @lombok.Builder
    private Place(String id, Label name, NodeGraphics graphics, Label initialMarking,
                  @lombok.Singular List<ToolSpecific> toolSpecifics) {
        this.id = id;
        this.name = name;
        this.graphics = graphics;
        this.initialMarking = initialMarking;
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
            .include(getGraphics())
            .include(getInitialMarking())
            .include(getToolSpecifics())
            .collect();
    }

    /**
     * Gets the identifier of this place
     * @return
     */
    @XmlAttribute(name = "id", required = true)
    public String getId() {
        return requireNonNullElseGet(id, () -> id = Identifiable.randomId());
    }

    /**
     * Sets the identifier of this place
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name of this place
     * @return
     */
    public Label getName() {
        return requireNonNullElseGet(name, () -> name = new Label());
    }

    /**
     * Sets the name of this place
     * @param name
     */
    public void setName(Label name) {
        this.name = name;
    }

    /**
     * Gets the graphical representation of this place
     * @return
     */
    @Override
    public NodeGraphics getGraphics() {
        return requireNonNullElseGet(graphics, () -> graphics = new NodeGraphics());
    }

    /**
     * Sets the graphical representation of this place
     * @param graphics
     */
    public void setGraphics(NodeGraphics graphics) {
        this.graphics = graphics;
    }

    /**
     * Gets the initial marking of this place
     * @return
     */
    public Label getInitialMarking() {
        return requireNonNullElseGet(initialMarking, () -> initialMarking = new Label());
    }

    /**
     * Sets the initial marking of this place
     * @param initialMarking
     */
    public void setInitialMarking(Label initialMarking) {
        this.initialMarking = initialMarking;
    }

    /**
     * Gets the tool-specific elements related to this place
     * @return
     */
    public List<ToolSpecific> getToolSpecifics() {
        return requireNonNullElseGet(toolSpecifics, () -> toolSpecifics = new ArrayList<>());
    }

    /**
     * Sets the tool-specific elements related to this place
     * @param toolSpecificData
     */
    public void setToolSpecifics(List<ToolSpecific> toolSpecificData) {
        this.toolSpecifics = new ArrayList<>(toolSpecificData);
    }

    @XmlElement(name = "name")
    @SuppressWarnings("unused")
    private Label getNameXml() {
        return requireNonDefaultElseNull(name);
    }

    @SuppressWarnings("unused")
    private void setNameXml(Label name) {
        this.name = name;
    }

    @XmlElement(name = "graphics")
    @SuppressWarnings("unused")
    private NodeGraphics getGraphicsXml() {
        return requireNonDefaultElseNull(graphics);
    }

    @SuppressWarnings("unused")
    private void setGraphicsXml(NodeGraphics graphics) {
        this.graphics = graphics;
    }

    @XmlElement(name = "initialMarking")
    @SuppressWarnings("unused")
    private Label getInitialMarkingXml() {
        return requireNonDefaultElseNull(initialMarking);
    }

    @SuppressWarnings("unused")
    private void setInitialMarkingXml(Label initialMarking) {
        this.initialMarking = initialMarking;
    }

}
