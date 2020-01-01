package de.lukaskoerfer.simplepnml;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.net.URI;
import java.util.stream.Stream;

/**
 * Describes the graphics of a node element
 */
@Builder
@EqualsAndHashCode
public class Node implements Collectable, Lined, Filled {

    /**
     * -- GETTER --
     * Gets the position of this graphical node
     * @return
     * -- SETTER --
     * Sets the position of this graphical node
     * @param position
     */
    @XmlElement(name = "position", required = true)
    @Getter @Setter
    private Position position = new Position();

    /**
     * -- GETTER --
     * Gets the size of this graphical node
     * @return
     * -- SETTER --
     * Sets the size of this graphical node
     * @param size
     */
    @XmlElement(name = "dimension")
    @Getter @Setter
    private Size size;

    /**
     * -- GETTER --
     * Gets the fill of this graphical node
     * @return
     * -- SETTER --
     * Sets the fill of this graphical node
     * @param fill
     */
    @XmlElement(name = "fill")
    @Getter @Setter
    private Fill fill;

    /**
     * -- GETTER --
     * Gets the line of this graphical node
     * @return
     * -- SETTER --
     * Se
     * ts the line of this graphical node
     * @param line
     */
    @XmlElement(name = "line")
    @Getter @Setter
    private Line line;

    /**
     * Creates a new graphical node
     */
    public Node() {}

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(getPosition())
            .collect(getSize())
            .collect(getFill())
            .collect(getLine())
            .build();
    }
}
