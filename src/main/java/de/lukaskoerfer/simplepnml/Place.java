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
     * Sets the initial marking of the place
     * @param initialMarking A label containing the initial marking
     */
    public void setInitialMarking(Label initialMarking) {
        this.initialMarking = initialMarking;
    }

    /**
     * Sets the initial marking of this place
     * @param initialMarking The initial marking
     */
    public void setInitialMarking(int initialMarking) {
        setInitialMarking(new Label(initialMarking));
    }

    /**
     * Sets the name of this place
     * @param name A string containing the name
     * @return A reference to this place
     */
    public Place withName(String name) {
        setName(new Label(name));
        return this;
    }

    /**
     * Sets the name of this place
     * @param name A label containing the name
     * @return A reference to this place
     */
    public Place withName(Label name) {
        setName(name);
        return this;
    }

    /**
     * Sets the graphics of this place
     * @param graphics A graphics description for a node element
     * @return A reference to this place
     */
    public Place withGraphics(Node graphics) {
        setGraphics(graphics);
        return this;
    }

    /**
     * Defines the graphics of this place
     * @param x The position in X direction
     * @param y The position in Y direction
     * @return A reference to this place
     */
    public Place withGraphics(double x, double y) {
        setGraphics(new Node(x, y));
        return this;
    }

    /**
     * Defines the graphics of this place
     * @param x The position in X direction
     * @param y The position in Y direction
     * @param fill The fill of the graphical representation
     * @param line The line of the graphical representation
     * @return A reference to this place
     */
    public Place withGraphics(double x, double y, Fill fill, Line line) {
        setGraphics(new Node(x, y, fill, line));
        return this;
    }

    /**
     * Defines the graphics of this place
     * @param x The position in X direction
     * @param y The position in Y direction
     * @param width The length in X direction
     * @param height The length in Y direction
     * @return A reference to this place
     */
    public Place withGraphics(double x, double y, double width, double height) {
        setGraphics(new Node(x, y, width, height));
        return this;
    }

    /**
     * Defines the graphics of this place
     * @param x The position in X direction
     * @param y The position in Y direction
     * @param width The length in X direction
     * @param height The length in Y direction
     * @param fill The fill of the graphical representation
     * @param line The line of the graphical representation
     * @return A reference to this place
     */
    public Place withGraphics(double x, double y, double width, double height, Fill fill, Line line) {
        setGraphics(new Node(x, y, width, height, fill, line));
        return this;
    }

    /**
     * Sets the initial marking of this place
     * @param initialMarking The initial marking
     * @return A reference to this place
     */
    public Place withInitialMarking(int initialMarking) {
        setInitialMarking(initialMarking);
        return this;
    }

    /**
     * Sets the initial marking of this place
     * @param initialMarking A label containing the initial marking
     * @return A reference to this place
     */
    public Place withInitialMarking(Label initialMarking) {
        setInitialMarking(initialMarking);
        return this;
    }

    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(name)
            .collect(graphics)
            .collect(initialMarking)
            .collect(toolData)
            .build();
    }
}
