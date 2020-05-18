package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.stream.Stream;

/**
 * Describes the size of a graphical element in two dimensions
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Size implements Collectable, Defaults {

    /**
     * --- GETTER ---
     * Gets the length in X direction
     * @return The length in X direction
     * --- SETTER ---
     * Sets the length in X direction
     * @param width The length in X direction
     */
    @Getter @Setter
    @XmlAttribute(name = "x", required = true)
    private double width;

    /**
     * --- GETTER ---
     * Gets the length in Y direction
     * @return The length in Y direction
     * --- SETTER ---
     * Sets the length in Y direction
     * @param height The length in Y direction
     */
    @Getter @Setter
    @XmlAttribute(name = "y", required = true)
    private double height;

    /**
     * Creates an empty dimension information
     */
    public Size() { }

    /**
     * Creates a new dimension information
     * @param width The length in X direction
     * @param height The length in Y direction
     */
    public Size(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }

    @Override
    public boolean isDefault() {
        return height == 0.0
            && width == 0.0;
    }

}
