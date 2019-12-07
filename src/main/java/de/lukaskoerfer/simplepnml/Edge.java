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
     * Creates a new edge
     * @param positions
     */
    public Edge(Position... positions) {
        this.positions = Arrays.asList(positions);
    }

    /**
     * Sets the line style of the edge
     * @param line A line description
     * @return A reference to this graphical edge
     */
    public Edge withLine(Line line) {
        setLine(line);
        return this;
    }

    /**
     * Defines the line style of the edge
     * @param color The line color
     * @param width The line width
     * @param shape The line shape
     * @param style The line style
     * @return A reference to this graphical edge
     */
    public Edge withLine(String color, double width, LineShape shape, LineStyle style) {
        setLine(new Line(color, width, shape, style));
        return this;
    }

    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(positions)
            .collect(line)
            .build();
    }
}
