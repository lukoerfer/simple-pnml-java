package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents a place in a place/transition net
 */
@EqualsAndHashCode(callSuper = true)
public class Place extends Connectable implements Collectable, Named, NodeElement {

    /**
     * -- GETTER --
     * Gets the name of this place
     * @return A label containing the name
     * -- SETTER --
     * Sets the name of this place
     * @param name A label containing the name
     */
    @XmlElement
    @Getter @Setter
    private Label name;

    /**
     * -- GETTER --
     * Gets the graphics of this place
     * @return A graphics description for a node element
     * -- SETTER --
     * Sets the graphics of this place
     * @param graphics A graphics description for a node element
     */
    @XmlElement
    @Getter @Setter
    private Node graphics;

    /**
     * -- GETTER --
     * Gets the initial marking of this place
     * @return A label containing the initial marking
     */
    @XmlElement
    @Getter
    private Label initialMarking;

    /**
     * -- GETTER --
     * Gets a list containing tool-specific data
     * @return A list of tool-specific data
     */
    @XmlElement
    @Getter
    private List<ToolData> toolData = new ArrayList<>();

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
