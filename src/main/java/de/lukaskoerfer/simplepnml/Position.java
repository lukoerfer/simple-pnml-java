package de.lukaskoerfer.simplepnml;

import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Getter;
import lombok.Setter;

/**
 * Describes the position of a graphical element
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Position implements Collectable, Defaultable {

    @Getter @Setter
    @XmlAttribute(name = "x", required = true)
    private double x = 0.0;

    @Getter @Setter
    @XmlAttribute(name = "y", required = true)
    private double y = 0.0;

    /**
     * Creates a new position located in the origin (0.0, 0.0)
     */
    public Position() { }

    /**
     * Creates a new position
     * @param x The position in X direction
     * @param y The position in Y direction
     */
    public Position(double x, double y) {
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

    /**
     *
     * @return
     */
    @Override
    public boolean isDefault() {
        return x == 0.0
            && y == 0.0;
    }

}
