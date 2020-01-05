package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.net.URI;
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
    @XmlElement(name = "dimension")
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
    @XmlElement(name = "fill")
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
    @XmlElement(name = "line")
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
}
