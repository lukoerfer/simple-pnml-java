package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Describes the graphics of an edge element
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
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
    private EdgeGraphics(@lombok.Singular List<Position> positions, Line line) {
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

    @XmlElement(name = "line")
    private Line getLineXml() {
        return requireNonDefaultElseNull(line);
    }

    private void setLineXml(Line line) {
        this.line = line;
    }

}
