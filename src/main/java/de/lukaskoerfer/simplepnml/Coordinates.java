package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Stores coordinates in two dimensions
 */
@EqualsAndHashCode
public class Coordinates {

    /**
     * -- GETTER --
     * Gets the position in X direction
     * @return The position in X direction
     * -- SETTER --
     * Sets the position in X direction
     * @param x The position in X direction
     */
    @XmlAttribute
    @Getter @Setter
    private double x;

    /**
     * -- GETTER --
     * Gets the position in Y direction
     * @return The position in Y direction
     * -- SETTER --
     * Sets the position in Y direction
     * @param y The position in Y direction
     */
    @XmlAttribute
    @Getter @Setter
    private double y;

    /**
     * Creates an empty set of coordinates
     */
    public Coordinates() {

    }

    /**
     * Creates a new set of coordinates
     * @param x The position in X direction
     * @param y The position in Y direction
     */
    public Coordinates(double x, double y) {
        setX(x);
        setY(y);
    }
}
