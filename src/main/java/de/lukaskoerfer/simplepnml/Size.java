package de.lukaskoerfer.simplepnml;

import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Getter;
import lombok.Setter;

/**
 * Describes the size of a graphical element
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Size implements Collectable, Defaultable {

    @Getter @Setter
    @XmlAttribute(name = "width", required = true)
    private double width = 0.0;

    @Getter @Setter
    @XmlAttribute(name = "height", required = true)
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
