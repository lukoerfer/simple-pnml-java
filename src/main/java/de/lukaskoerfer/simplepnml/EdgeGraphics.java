package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;

/**
 * Describes the graphics of an edge element
 */
@EqualsAndHashCode
@XmlType(propOrder = { "positions", "lineXml" })
public class EdgeGraphics implements Collectable, Defaultable, Lined  {

    @Getter
    @XmlElement(name = "position")
    private List<Position> positions = new ArrayList<>();

    @Getter @Setter
    @NonNull
    private Line line = new Line();

    /**
     * Creates a new graphical representation for edge elements
     */
    public EdgeGraphics() { }

    @lombok.Builder
    private EdgeGraphics(@Singular List<Position> positions, Line line) {
        this.positions = new ArrayList<>(positions);
        this.line = line;
    }

    /**
     *
     * @param positions
     */
    public void setPositions(@NonNull List<Position> positions) {
        this.positions = new ArrayList<>(positions);
    }

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

    @XmlElement(name = "line")
    private Line getLineXml() {
        return requireNonDefaultElseNull(line);
    }

    private void setLineXml(Line line) {
        this.line = line;
    }

}
