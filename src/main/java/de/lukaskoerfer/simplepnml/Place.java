package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Represents a place in a place/transition net
 */
@Builder
@EqualsAndHashCode
public class Place implements Connectable, Collectable, Named, Node {

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
     * Gets the name of this place
     * @return A label containing the name
     * -- SETTER --
     * Sets the name of this place
     * @param name A label containing the name
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlElement(name = "name")
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
    @XmlElement(name = "graphics")
    private NodeGraphics graphics = new NodeGraphics();

    /**
     * -- GETTER --
     * Gets the initial marking of this place
     * @return A label containing the initial marking
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlElement(name = "initialMarking")
    private Label initialMarking = new Label();

    /**
     * -- GETTER --
     * Gets a list containing tool-specific data
     * @return A list of tool-specific data
     */
    @NonNull
    @Getter @Setter
    @Singular("data")
    @XmlElement
    private List<ToolData> toolData;

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
        setId(id);
        setToolData(new ArrayList<>());
    }

    // Internal constructor for builder
    private Place(String id, Label name, NodeGraphics graphics, Label initialMarking, List<ToolData> toolData) {
        setId(id);
        setName(name);
        setGraphics(graphics);
        setInitialMarking(initialMarking);
        setToolData(new ArrayList<>(toolData));
    }

    /**
     * Sets the identifier, defaults to a random UUID if null, empty or whitespace
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     */
    public void setId(String id) {
        this.id = id != null ? id : UUID.randomUUID().toString();
    }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(getName())
            .collect(getGraphics())
            .collect(getInitialMarking())
            .collect(getToolData())
            .build();
    }
}
