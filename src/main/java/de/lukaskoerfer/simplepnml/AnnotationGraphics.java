package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.util.stream.Stream;

/**
 * Describes the graphics of an annotation element
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class AnnotationGraphics implements Collectable, Filled, Lined {

    /**
     * -- GETTER --
     * Gets the offset of this annotation graphics
     * @return A set of relative coordinates
     * -- SETTER --
     * Sets the offsets of this annotation graphics
     * @param offset A set of relative coordinates
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlElement(name = "offset")
    private Position offset = new Position();

    /**
     * -- GETTER --
     * Gets the fill of this annotation graphics
     * @return
     * -- SETTER --
     * Sets the fill of this annotation graphics
     * @param fill
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlElement(name = "fill")
    private Fill fill = new Fill();

    /**
     * -- GETTER --
     * Gets the line of this annotation graphics
     * @return
     * -- SETTER --
     * Sets the line of this annotation graphics
     * @param line
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlElement(name = "line")
    private Line line = new Line();

    /**
     * -- GETTER --
     * Gets the font of this annotation graphics
     * @return
     * -- SETTER --
     * Sets the font of this annotation graphics
     * @param font
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlElement(name = "font")
    private Font font = new Font();

    /**
     * Creates a new annotation graphics
     */
    public AnnotationGraphics() { }

    /**
     * Collects the child elements of this annotation recursively
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(getOffset())
            .collect(getFill())
            .collect(getFont())
            .collect(getLine())
            .build();
    }
}
