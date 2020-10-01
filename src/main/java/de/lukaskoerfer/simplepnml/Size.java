package de.lukaskoerfer.simplepnml;

import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Describes the size of a graphical element
 */
@EqualsAndHashCode
public class Size implements Collectable, Defaultable {

    @Getter @Setter
    @XmlAttribute(name = "x", required = true)
    private double width = 0.0;

    @Getter @Setter
    @XmlAttribute(name = "y", required = true)
    private double height = 0.0;

    /**
     * Creates a new size
     */
    public Size() { }

    /**
     * Creates a new size
     * @param width The length in X direction
     * @param height The length in Y direction
     */
    public Size(double width, double height) {
        this.width = width;
        this.height = height;
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
        return height == 0.0
            && width == 0.0;
    }

}
