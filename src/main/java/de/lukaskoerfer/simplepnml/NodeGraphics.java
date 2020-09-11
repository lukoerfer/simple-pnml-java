package de.lukaskoerfer.simplepnml;

import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Describes the graphics of a node element
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class NodeGraphics implements Collectable, Defaultable, Lined, Filled {

    @Getter @Setter
    @NonNull
    @XmlElement(name = "position", required = true)
    private Position position = new Position();

    @Getter @Setter
    @NonNull
    private Size size = new Size();

    @Getter @Setter
    @NonNull
    private Fill fill = new Fill();

    @Getter @Setter
    @NonNull
    private Line line = new Line();

    /**
     * Creates a new graphical representation for a node element
     */
    public NodeGraphics() { }

    @lombok.Builder
    private NodeGraphics(Position position, Size size, Fill fill, Line line) {
        this.position = position;
        this.size = size;
        this.fill = fill;
        this.line = line;
    }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(getPosition())
            .include(getSize())
            .include(getFill())
            .include(getLine())
            .collect();
    }

    @Override
    public boolean isDefault() {
        return getPosition().isDefault()
            && getSize().isDefault()
            && getFill().isDefault()
            && getLine().isDefault();
    }

    @XmlElement(name = "dimension")
    private Size getSizeXml() {
        return requireNonDefaultElseNull(size);
    }

    private void setSizeXml(Size size) {
        this.size = size;
    }

    @XmlElement(name = "fill")
    private Fill getFillXml() {
        return requireNonDefaultElseNull(fill);
    }

    private void setFillXml(Fill fill) {
        this.fill = fill;
    }

    @XmlElement(name = "line")
    private Line getLineXml() {
        return requireNonDefaultElseNull(line);
    }

    private void setLineXml(Line line) {
        this.line = line;
    }

}
