package de.lukaskoerfer.simplepnml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Represents a place in a petri net
 */
@EqualsAndHashCode
@XmlType(propOrder = {"nameXml", "graphicsXml", "initialMarkingXml", "toolSpecifics"})
public class Place implements Connectable, Collectable, Named, Node, ToolExtendable {

    @Setter
    @NonNull
    private String id;

    @Getter @Setter
    @NonNull
    private Label name = new Label();

    @Getter @Setter
    @NonNull
    private NodeGraphics graphics = new NodeGraphics();

    @Getter @Setter
    @NonNull
    private Label initialMarking = new Label();

    @Getter
    @XmlElement(name = "toolspecific")
    private List<ToolSpecific> toolSpecifics = new ArrayList<>();

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
                  @Singular List<ToolSpecific> toolSpecifics) {
        this.id = id;
        this.name = name;
        this.graphics = graphics;
        this.initialMarking = initialMarking;
        this.toolSpecifics = new ArrayList<>(toolSpecifics);
    }

    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(name)
            .include(graphics)
            .include(initialMarking)
            .include(toolSpecifics)
            .collect();
    }

    @XmlAttribute(name = "id", required = true)
    public String getId() {
        return requireNonNullElseGet(id, () -> id = Identifiable.randomId());
    }

    public void setToolSpecifics(@NonNull List<ToolSpecific> toolSpecificData) {
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

    @XmlElement(name = "initialMarking")
    private Label getInitialMarkingXml() {
        return requireNonDefaultElseNull(initialMarking);
    }

    private void setInitialMarkingXml(Label initialMarking) {
        this.initialMarking = initialMarking;
    }

}
