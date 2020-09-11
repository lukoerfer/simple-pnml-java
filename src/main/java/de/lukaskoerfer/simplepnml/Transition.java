package de.lukaskoerfer.simplepnml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Represents a transition in a petri net
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Transition implements Connectable, Collectable, Named, Node, ToolExtendable {

    @Setter
    private String id;

    @Getter @Setter
    private Label name = new Label();

    @Getter @Setter
    private NodeGraphics graphics = new NodeGraphics();

    @Getter
    @XmlElement(name = "toolspecific")
    private List<ToolSpecific> toolSpecifics;

    /**
     * Creates a new transition
     */
    public Transition() { }

    /**
     * Creates a new transition
     */
    public Transition(String id) {
        this.id = id;
    }

    @lombok.Builder
    private Transition(String id, Label name, NodeGraphics graphics,
                       @lombok.Singular List<ToolSpecific> toolSpecifics) {
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

    /**
     * Gets the identifier of this transition
     * @return
     */
    @XmlAttribute(name = "id", required = true)
    public String getId() {
        return requireNonNullElseGet(id, () -> id = Identifiable.randomId());
    }

    /**
     * Sets the tool-specific elements related to this transition
     * @param toolSpecificData
     */
    public void setToolSpecifics(List<ToolSpecific> toolSpecificData) {
        this.toolSpecifics = new ArrayList<>(toolSpecificData);
    }

    @XmlElement(name = "name")
    private Label getNameXml() {
        return requireNonDefaultElseNull(name);
    }

    private void setNameXml(Label name) {
        this.name = name;
    }

    @XmlElement(name = "graphics")
    private NodeGraphics getGraphicsXml() {
        return requireNonDefaultElseNull(graphics);
    }

    private void setGraphicsXml(NodeGraphics graphics) {
        this.graphics = graphics;
    }

}
