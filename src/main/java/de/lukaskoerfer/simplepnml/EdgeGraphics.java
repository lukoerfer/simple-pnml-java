package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static de.lukaskoerfer.simplepnml.Defaults.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Describes the graphics of an edge element
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class EdgeGraphics implements Collectable, Defaults, Lined  {

    private List<Position> positions;
    private Line line;

    /**
     * Creates a new edge
     */
    public EdgeGraphics() { }

    @Builder
    private EdgeGraphics(@Singular List<Position> positions, Line line) {
        this.positions = new ArrayList<>(positions);
        this.line = line;
    }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(getPositions())
            .include(getLine())
            .collect();
    }

    @Override
    public boolean isDefault() {
        return getPositions().isEmpty()
            && getLine().isDefault();
    }

    @XmlElement(name = "position")
    public List<Position> getPositions() {
        return requireNonNullElseGet(positions, () -> positions = new ArrayList<>());
    }

    public void setPositions(List<Position> positions) {
        this.positions = new ArrayList<>(positions);
    }

    @Override
    public Line getLine() {
        return requireNonNullElseGet(line, () -> line = new Line());
    }

    public void setLine(Line line) {
        this.line = line;
    }

    @XmlElement(name = "line")
    @SuppressWarnings("unused")
    private Line getLineXml() {
        return requireNonDefaultElseNull(getLine());
    }

    @SuppressWarnings("unused")
    private void setLineXml(Line line) {
        setLine(line);
    }

}
