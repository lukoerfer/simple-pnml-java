package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Describes dimension information (size) of a graphical element
 */
@EqualsAndHashCode
public class Dimension {

    /**
     * --- GETTER ---
     * Gets the length in X direction
     * @return The length in X direction
     * --- SETTER ---
     * Sets the length in X direction
     * @param width The length in X direction
     */
    @XmlAttribute(name = "x")
    @Getter @Setter
    private double width;

    /**
     * --- GETTER ---
     * Gets the length in Y direction
     * @return The length in Y direction
     * --- SETTER ---
     * Sets the length in Y direction
     * @param height The length in Y direction
     */
    @XmlAttribute(name = "y")
    @Getter @Setter
    private double height;

    /**
     * Creates an empty dimension information
     */
    public Dimension() { }

    /**
     * Creates a new dimension information
     * @param width The length in X direction
     * @param height The length in Y direction
     */
    public Dimension(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

}
