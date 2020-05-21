package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.stream.Stream;

import static de.lukaskoerfer.simplepnml.Defaults.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Describes the graphics of a node element
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class NodeGraphics implements Collectable, Defaults, Lined, Filled {

    private Position position;
    private Size size;
    private Fill fill;
    private Line line;

    /**
     * Creates a new graphical node
     */
    public NodeGraphics() { }

    @Builder
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

    @XmlElement(name = "position", required = true)
    public Position getPosition() {
        return requireNonNullElseGet(position, () -> position = new Position());
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Size getSize() {
        return requireNonNullElseGet(size, () -> size = new Size());
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public Fill getFill() {
        return requireNonNullElseGet(fill, () -> fill = new Fill());
    }

    public void setFill(Fill fill) {
        this.fill = fill;
    }

    @Override
    public Line getLine() {
        return requireNonNullElseGet(line, () -> line = new Line());
    }

    public void setLine(Line line) {
        this.line = line;
    }

    @XmlElement(name = "dimension")
    @SuppressWarnings("unused")
    private Size getSizeXml() {
        return requireNonDefaultElseNull(size);
    }

    @SuppressWarnings("unused")
    private void setSizeXml(Size size) {
        this.size = size;
    }

    @XmlElement(name = "fill")
    @SuppressWarnings("unused")
    private Fill getFillXml() {
        return requireNonDefaultElseNull(fill);
    }

    @SuppressWarnings("unused")
    private void setFillXml(Fill fill) {
        this.fill = fill;
    }

    @XmlElement(name = "line")
    @SuppressWarnings("unused")
    private Line getLineXml() {
        return requireNonDefaultElseNull(line);
    }

    @SuppressWarnings("unused")
    private void setLineXml(Line line) {
        this.line = line;
    }

}
