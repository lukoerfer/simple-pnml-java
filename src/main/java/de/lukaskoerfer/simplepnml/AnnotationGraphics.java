package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;
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
    @XmlElement(name = "offset", required = true)
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

    @XmlElement(name = "font")
    private Font getFontXml() {
        return Objects.equals(getFont(), new Font()) ? null : getFont();
    }

    private void setFontXml(Font font) {
        setFont(font);
    }
}
