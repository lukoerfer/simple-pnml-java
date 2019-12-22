package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 */
@EqualsAndHashCode
public class Offset implements Collectable {

    /**
     * -- GETTER --
     * Gets the position in X direction
     * @return The position in X direction
     * -- SETTER --
     * Sets the position in X direction
     * @param x The position in X direction
     */
    @XmlAttribute
    @Getter
    @Setter
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
    public Offset() { }

    /**
     * Creates a new set of coordinates
     * @param x The position in X direction
     * @param y The position in Y direction
     */
    public Offset(double x, double y) {
        setX(x);
        setY(y);
    }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }
}
