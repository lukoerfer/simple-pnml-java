package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Describes the graphics of an edge element
 */
@Builder
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class EdgeGraphics implements Collectable, Defaults, Lined  {

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
        return new Collector(this)
            .include(positions)
            .include(line)
            .collect();
    }

    @Override
    public boolean isDefault() {
        return positions.isEmpty()
            && line.isDefault();
    }

    //region Internal serialization

    @XmlElement(name = "line")
    @SuppressWarnings("unused")
    private Line getLineXml() {
        return Defaults.requireNonDefault(getLine());
    }

    @SuppressWarnings("unused")
    private void setLineXml(Line line) {
        setLine(line);
    }

    //endregion
}
