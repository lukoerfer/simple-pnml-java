package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.net.URI;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Describes the graphics of a node element
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class NodeGraphics implements Collectable, Lined, Filled {

    /**
     * -- GETTER --
     * Gets the position of this graphical node
     * @return
     * -- SETTER --
     * Sets the position of this graphical node
     * @param position
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlElement(name = "position", required = true)
    private Position position = new Position();

    /**
     * -- GETTER --
     * Gets the size of this graphical node
     * @return
     * -- SETTER --
     * Sets the size of this graphical node
     * @param size
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private Size size = new Size();

    /**
     * -- GETTER --
     * Gets the fill of this graphical node
     * @return
     * -- SETTER --
     * Sets the fill of this graphical node
     * @param fill
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private Fill fill = new Fill();

    /**
     * -- GETTER --
     * Gets the line of this graphical node
     * @return
     * -- SETTER --
     * Se
     * ts the line of this graphical node
     * @param line
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private Line line = new Line();

    /**
     * Creates a new graphical node
     */
    public NodeGraphics() {}

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(getPosition())
            .collect(getSize())
            .collect(getFill())
            .collect(getLine())
            .build();
    }

    @XmlElement(name = "dimension")
    private Size getSizeXml() {
        return Objects.equals(getSize(), new Size()) ? null : getSize();
    }

    private void setSizeXml(Size size) {
        setSize(size);
    }

    @XmlElement(name = "fill")
    private Fill getFillXml() {
        return Objects.equals(getFill(), new Fill()) ? null : getFill();
    }

    private void setFillXml(Fill fill) {
        setFill(fill);
    }

    @XmlElement(name = "line")
    private Line getLineXml() {
        return Objects.equals(getLine(), new Line()) ? null : getLine();
    }

    private void setLineXml(Line line) {
        setLine(line);
    }

}
