package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.stream.Stream;

/**
 * Describes the graphics of an annotation element
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class AnnotationGraphics implements Collectable, Defaults, Filled, Lined {

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
        return new Collector(this)
            .include(offset)
            .include(fill)
            .include(font)
            .include(line)
            .collect();
    }

    @Override
    public boolean isDefault() {
        return offset.isDefault()
            && fill.isDefault()
            && line.isDefault()
            && font.isDefault();
    }

    //region Internal serialization

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

    @XmlElement(name = "font")
    @SuppressWarnings("unused")
    private Font getFontXml() {
        return Defaults.requireNonDefault(font);
    }

    @SuppressWarnings("unused")
    private void setFontXml(Font font) {
        this.font = font;
    }

    //endregion

}
