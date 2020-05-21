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

    private double x = 0.0;
    private double y = 0.0;

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
        this.x = x;
        this.y = y;
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

    @XmlAttribute(name = "x", required = true)
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @XmlAttribute(name = "y", required = true)
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
