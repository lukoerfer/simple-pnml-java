package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Describes a graphical line element
 */
@Builder
@EqualsAndHashCode
public class Line implements Collectable {

    /**
     * -- GETTER --
     * Gets the line color
     * @return
     * -- SETTER --
     * Sets the line color
     * @param color
     */
    @XmlAttribute
    @Getter @Setter
    private String color;

    /**
     * -- GETTER --
     * Gets the line width
     * @return
     * -- SETTER --
     * Sets the line width
     * @param width
     */
    @XmlAttribute
    @Getter @Setter
    private double width;

    /**
     * -- GETTER --
     * Gets the line shape
     * @return
     * -- SETTER --
     * Sets the line shape
     * @param shape
     */
    @XmlAttribute
    @Getter @Setter
    private LineShape shape;

    /**
     * -- GETTER --
     * Gets the line style
     * @return
     * -- SETTER --
     * Sets the line style
     * @param style
     */
    @XmlAttribute
    @Getter @Setter
    private LineStyle style;

    /**
     * Creates a new line
     */
    public Line() { }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }
}
