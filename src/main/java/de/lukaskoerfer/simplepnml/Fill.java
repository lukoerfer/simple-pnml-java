package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import java.net.URI;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Describes the fill of a graphical element
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Fill implements Collectable {

    /**
     * -- GETTER --
     * Gets the fill color
     * @return A string describing a color
     * -- SETTER --
     * Sets the fill color
     * @param color A string describing a color
     */
    @Getter @Setter
    @XmlAttribute(name = "color")
    private String color;

    /**
     * -- GETTER --
     * Gets the gradient color
     * @return A string describing a color
     * -- SETTER --
     * Sets the gradient color
     * @param gradientColor A string describing a color
     */
    @Getter @Setter
    @XmlAttribute(name = "gradient-color")
    private String gradientColor;

    /**
     * -- GETTER --
     * Gets the gradient rotation
     * @return A gradient rotation
     * -- SETTER --
     * Sets the gradient rotation
     * @param gradientRotation A gradient rotation
     */
    @Getter @Setter
    @XmlAttribute(name = "gradient-rotation")
    private GradientRotation gradientRotation;

    /**
     * -- GETTER --
     * Gets the fill image
     * @return An URI pointing to the fill image
     * -- SETTER --
     * Sets the fill image
     * @param image An URI pointing to the fill image
     */
    @Getter @Setter
    @XmlAttribute(name = "image")
    private URI image;

    /**
     * Creates a new fill
     */
    public Fill() { }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }
}
