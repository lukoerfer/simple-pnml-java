package de.lukaskoerfer.simplepnml;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.stream.Stream;

/**
 * Specifies a font
 */
@Builder
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
    @XmlAttribute
    @Getter @Setter
    private String family;

    /**
     * -- GETTER --
     * Gets the font style
     * @return A string containing a font style in CSS
     * -- SETTER --
     * Sets the font style
     * @param style A string containing a font style in CSS
     */
    @XmlAttribute
    @Getter @Setter
    private String style;

    /**
     * -- GETTER --
     * Gets the font weight
     * @return A string containing a font weight in CSS
     * -- SETTER --
     * Sets the font weight
     * @param weight A string containing a font weight in CSS
     */
    @XmlAttribute
    @Getter @Setter
    private String weight;

    /**
     * -- GETTER --
     * Gets the font size
     * @return A string containing a font size in CSS
     * -- SETTER --
     * Sets the font size
     * @param size A string containing a font size in CSS
     */
    @XmlAttribute
    @Getter @Setter
    private String size;

    /**
     * -- GETTER --
     * Gets the font decoration
     * @return A font decoration
     * -- SETTER --
     * Sets the font decoration
     * @param decoration A font decoration
     */
    @XmlAttribute
    @Getter @Setter
    private FontDecoration decoration;

    /**
     * -- GETTER --
     * Gets the font alignment
     * @return A font alignment
     * -- SETTER --
     * Sets the font alignment
     * @param align A font alignment
     */
    @XmlAttribute
    @Getter @Setter
    private FontAlign align;

    /**
     * -- GETTER --
     * Gets the font rotation
     * @return A font rotation
     * -- SETTER --
     * Sets the font rotation
     * @param rotation A font rotation
     */
    @XmlAttribute
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
}
