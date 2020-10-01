package de.lukaskoerfer.simplepnml;

import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;

/**
 * Describes the graphics of a node element
 */
@EqualsAndHashCode
@XmlType(propOrder = { "position", "sizeXml", "fillXml", "lineXml" })
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
            .include(position)
            .include(size)
            .include(fill)
            .include(line)
            .collect();
    }

    @Override
    public boolean isDefault() {
        return position.isDefault()
            && size.isDefault()
            && fill.isDefault()
            && line.isDefault();
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
