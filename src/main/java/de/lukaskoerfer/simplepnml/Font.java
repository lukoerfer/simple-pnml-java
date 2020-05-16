package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.stream.Stream;

/**
 * Specifies a font
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Font implements Collectable, Defaults {

    /**
     * -- GETTER --
     * Gets the font family
     * @return A string containing a font family in CSS
     * -- SETTER --
     * Sets the font family
     * @param family A string containing a font family in CSS
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlAttribute(name = "family")
    private String family = "";

    /**
     * -- GETTER --
     * Gets the font style
     * @return A string containing a font style in CSS
     * -- SETTER --
     * Sets the font style
     * @param style A string containing a font style in CSS
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlAttribute(name = "style")
    private String style = "";

    /**
     * -- GETTER --
     * Gets the font weight
     * @return A string containing a font weight in CSS
     * -- SETTER --
     * Sets the font weight
     * @param weight A string containing a font weight in CSS
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlAttribute(name = "weight")
    private String weight = "";

    /**
     * -- GETTER --
     * Gets the font size
     * @return A string containing a font size in CSS
     * -- SETTER --
     * Sets the font size
     * @param size A string containing a font size in CSS
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlAttribute(name = "size")
    private String size = "";

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
    @XmlAttribute(name = "decoration")
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
    @XmlAttribute(name = "align")
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
    @XmlAttribute(name = "rotation")
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

    @Override
    public boolean isDefault() {
        return family.isEmpty()
            && style.isEmpty()
            && weight.isEmpty()
            && size.isEmpty()
            && decoration.isDefault()
            && align.isDefault()
            && rotation == 0.0;
    }
}
