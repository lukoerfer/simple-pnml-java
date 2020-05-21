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

    private double width = 0.0;
    private double height = 0.0;

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

    @XmlAttribute(name = "width", required = true)
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @XmlAttribute(name = "height", required = true)
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
