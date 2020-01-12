package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Describes the position of a graphical element in two dimensions
 */
@EqualsAndHashCode
public class Position implements Collectable {

    /**
     * -- GETTER --
     * Gets the position in X direction
     * @return The position in X direction
     * -- SETTER --
     * Sets the position in X direction
     * @param x The position in X direction
     */
    @Getter @Setter
    @XmlAttribute(name = "x", required = true)
    private double x;

    /**
     * -- GETTER --
     * Gets the position in Y direction
     * @return The position in Y direction
     * -- SETTER --
     * Sets the position in Y direction
     * @param y The position in Y direction
     */
    @Getter @Setter
    @XmlAttribute(name = "y", required = true)
    private double y;

    /**
     * Creates an empty set of coordinates
     */
    public Position() { }

    /**
     * Creates a new set of coordinates
     * @param x The position in X direction
     * @param y The position in Y direction
     */
    public Position(double x, double y) {
        setX(x);
        setY(y);
    }

    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }
}
