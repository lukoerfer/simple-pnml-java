package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Represents a transition in a place/transition net
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class Transition extends Connectable implements Collectable, Named, NodeElement {

    /**
     * -- GETTER --
     * Gets the name of this transition
     * @return A label containing the name
     * -- SETTER --
     * Sets the name of this transition
     * @param name A label containing the name
     */
    @Getter @Setter
    @XmlElement
    private Label name;

    /**
     * -- GETTER --
     * Gets the graphics of this transition
     * @return A graphics description
     * -- SETTER --
     * Sets the graphics of this transition
     * @param graphics A graphics description
     */
    @Getter @Setter
    @XmlElement
    private Node graphics;

    /**
     * -- GETTER --
     * Gets a list containing tool-specific data
     * @return A list of tool-specific data
     */
    @Getter @Setter
    @XmlElement
    private List<ToolData> toolData;

    /**
     * Creates a new transition using a random identifier
     */
    public Transition() {
        this(null);
    }

    /**
     * Creates a new transition
     * @param id An unique identifier, defaults to an UUID if null, empty or whitespace
     */
    public Transition(String id) {
        setId(id);
        setToolData(new ArrayList<>());
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
            .collect(getToolData())
            .build();
    }
}
