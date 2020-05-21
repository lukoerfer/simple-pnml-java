package de.lukaskoerfer.simplepnml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;

import static de.lukaskoerfer.simplepnml.Defaults.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Represents a transition in a place/transition net
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Transition implements Connectable, Collectable, Named, Node, ToolExtendable {

    private String id;
    private Label name;
    private NodeGraphics graphics;
    private List<ToolSpecific> toolSpecifics;

    /**
     * Creates a new transition with a random identifier
     */
    public Transition() { }

    /**
     * Creates a new transition
     */
    public Transition(String id) {
        this.id = id;
    }

    @Builder
    private Transition(String id, Label name, NodeGraphics graphics,
                       @Singular List<ToolSpecific> toolSpecifics) {
        this.id = id;
        this.name = name;
        this.graphics = graphics;
        this.toolSpecifics = new ArrayList<>(toolSpecifics);
    }

    /**
     * Collects the child elements of this transition recursively
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(getName())
            .include(getGraphics())
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

    public NodeGraphics getGraphics() {
        return requireNonNullElseGet(graphics, () -> graphics = new NodeGraphics());
    }

    public void setGraphics(NodeGraphics graphics) {
        this.graphics = graphics;
    }

    @XmlElement(name = "toolspecific")
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

}
