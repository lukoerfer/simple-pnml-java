package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Specifies a font
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Font implements Collectable {

    /**
     * -- GETTER --
     * Gets the font family
     * @return A string containing a font family in CSS
     * -- SETTER --
     * Sets the font family
     * @param family A string containing a font family in CSS
     */
    @Getter @Setter
    @XmlAttribute(name = "family")
    private String family;

    /**
     * -- GETTER --
     * Gets the font style
     * @return A string containing a font style in CSS
     * -- SETTER --
     * Sets the font style
     * @param style A string containing a font style in CSS
     */
    @Getter @Setter
    @XmlAttribute(name = "style")
    private String style;

    /**
     * -- GETTER --
     * Gets the font weight
     * @return A string containing a font weight in CSS
     * -- SETTER --
     * Sets the font weight
     * @param weight A string containing a font weight in CSS
     */
    @Getter @Setter
    @XmlAttribute(name = "weight")
    private String weight;

    /**
     * -- GETTER --
     * Gets the font size
     * @return A string containing a font size in CSS
     * -- SETTER --
     * Sets the font size
     * @param size A string containing a font size in CSS
     */
    @Getter @Setter
    @XmlAttribute(name = "size")
    private String size;

    /**
     * -- GETTER --
     * Gets the font decoration
     * @return A font decoration
     * -- SETTER --
     * Sets the font decoration
     * @param decoration A font decoration
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private FontDecoration decoration = FontDecoration.NONE;

    /**
     * -- GETTER --
     * Gets the font alignment
     * @return A font alignment
     * -- SETTER --
     * Sets the font alignment
     * @param align A font alignment
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private FontAlign align = FontAlign.LEFT;

    /**
     * -- GETTER --
     * Gets the font rotation
     * @return A font rotation
     * -- SETTER --
     * Sets the font rotation
     * @param rotation A font rotation
     */
    @Getter @Setter
    private double rotation;

    /**
     * Creates a new font
     */
    public Font() { }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }

    @XmlAttribute(name = "decoration")
    private FontDecoration getDecorationXml() {
        return Objects.equals(getDecoration(), FontDecoration.NONE) ? null : getDecoration();
    }

    private void setDecorationXml(FontDecoration decoration) {
        setDecoration(decoration);
    }

    @XmlAttribute(name = "align")
    private FontAlign getAlignXml() {
        return Objects.equals(getAlign(), FontAlign.LEFT) ? null : getAlign();
    }

    private void setAlignXml(FontAlign align) {
        setAlign(align);
    }

    @XmlAttribute(name = "rotation")
    private Double getRotationXml() {
        return Objects.equals(getRotation(), 0.0) ? null : getRotation();
    }

    private void setRotationXml(Double rotation) {
        setRotation(rotation != null ? rotation : 0.0);
    }
}
