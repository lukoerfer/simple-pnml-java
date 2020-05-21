package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static de.lukaskoerfer.simplepnml.Defaults.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Represents a place in a place/transition net
 */
@EqualsAndHashCode
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
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     */
    public Place(String id) {
        this.id = id;
    }

    @Builder
    private Place(String id, Label name, NodeGraphics graphics, Label initialMarking,
                  @Singular List<ToolSpecific> toolSpecifics) {
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

    @XmlAttribute(name = "id", required = true)
    public String getId() {
        return requireNonNullElseGet(id, () -> id = Identifiable.randomId());
    }

    public void setId(String id) {
        this.id = id;
    }

    public Label getName() {
        return requireNonNullElseGet(name, () -> name = new Label());
    }

    public void setName(Label name) {
        this.name = name;
    }

    @Override
    public NodeGraphics getGraphics() {
        return requireNonNullElseGet(graphics, () -> graphics = new NodeGraphics());
    }

    public void setGraphics(NodeGraphics graphics) {
        this.graphics = graphics;
    }

    public Label getInitialMarking() {
        return requireNonNullElseGet(initialMarking, () -> initialMarking = new Label());
    }

    public void setInitialMarking(Label initialMarking) {
        this.initialMarking = initialMarking;
    }

    public List<ToolSpecific> getToolSpecifics() {
        return requireNonNullElseGet(toolSpecifics, () -> toolSpecifics = new ArrayList<>());
    }

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
