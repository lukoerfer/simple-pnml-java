package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Describes the graphics of an edge element
 */
@Builder
@EqualsAndHashCode
public class EdgeGraphics implements Collectable, Lined {

    /**
     * -- GETTER --
     * Gets a list containing the points that define this edge
     * @return A list of points
     */
    @NonNull
    @Getter @Setter
    @Singular
    @XmlElement(name = "position")
    private List<Position> positions;

    /**
     * -- GETTER --
     * Gets the line style of this edge
     * @return A line description
     * -- SETTER --
     * Sets the line style of this edge
     * @param line A line description
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private Line line = new Line();

    /**
     * Creates a new edge
     */
    public EdgeGraphics() {
        setPositions(new ArrayList<>());
    }

    // Internal constructor for builder
    private EdgeGraphics(List<Position> positions, Line line) {
        setPositions(new ArrayList<>(positions));
        setLine(line);
    }

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

    @XmlElement(name = "line")
    private Line getLineXml() {
        return Objects.equals(getLine(), new Line()) ? null : getLine();
    }

    private void setLineXml(Line line) {
        setLine(line);
    }
}
