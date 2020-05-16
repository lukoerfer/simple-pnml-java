package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.stream.Stream;

/**
 * Describes the graphics of a node element
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class NodeGraphics implements Collectable, Defaults, Lined, Filled {

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

    //region Internal serialization

    @XmlElement(name = "dimension")
    @SuppressWarnings("unused")
    private Size getSizeXml() {
        return Defaults.requireNonDefault(size);
    }

    @SuppressWarnings("unused")
    private void setSizeXml(Size size) {
        this.size = size;
    }

    @XmlElement(name = "fill")
    @SuppressWarnings("unused")
    private Fill getFillXml() {
        return Defaults.requireNonDefault(fill);
    }

    @SuppressWarnings("unused")
    private void setFillXml(Fill fill) {
        this.fill = fill;
    }

    @XmlElement(name = "line")
    @SuppressWarnings("unused")
    private Line getLineXml() {
        return Defaults.requireNonDefault(line);
    }

    @SuppressWarnings("unused")
    private void setLineXml(Line line) {
        this.line = line;
    }

    //endregion

}
