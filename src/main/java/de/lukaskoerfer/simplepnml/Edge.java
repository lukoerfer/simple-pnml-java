package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Describes the graphics of an edge element
 */
@EqualsAndHashCode
public class Edge implements Collectable, Lined {

    /**
     * -- GETTER --
     * Gets a list containing the points that define this edge
     * @return A list of points
     */
    @XmlElement
    @Getter
    private List<Position> positions = new ArrayList<>();

    /**
     * -- GETTER --
     * Gets the line style of this edge
     * @return A line description
     * -- SETTER --
     * Sets the line style of this edge
     * @param line A line description
     */
    @XmlElement
    @Getter @Setter
    private Line line;

    /**
     * Creates a new edge
     */
    public Edge() {}

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(getPositions())
            .collect(getLine())
            .build();
    }
}
