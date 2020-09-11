package de.lukaskoerfer.simplepnml;

import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Getter;
import lombok.Setter;

/**
 * Describes the offset of a graphical element
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Offset implements Collectable, Defaultable {

    @XmlAttribute(name = "x", required = true)
    private double x = 0.0;

    @XmlAttribute(name = "y", required = true)
    private double y = 0.0;

    /**
     * Creates a new offset
     */
    public Offset() { }

    /**
     * Creates a new offset
     * @param x The offset in X direction
     * @param y The offset in Y direction
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
