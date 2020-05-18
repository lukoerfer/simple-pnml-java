package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.stream.Stream;

/**
 *
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Offset implements Collectable, Defaults {

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

    @Override
    public boolean isDefault() {
        return x == 0.0
            && y == 0.0;
    }

}
