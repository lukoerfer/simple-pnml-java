package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Describes a graphical line element
 */
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
    public Line() {}

    /**
     * Creates a new line
     * @param color
     */
    public Line(String color) {
        setColor(color);
    }

    /**
     * Creates a new line
     * @param color
     * @param width
     */
    public Line(String color, double width) {
        setColor(color);
        setWidth(width);
    }

    /**
     * Creates a new line
     * @param color
     * @param width
     * @param shape
     * @param style
     */
    public Line(String color, double width, LineShape shape, LineStyle style) {
        setColor(color);
        setWidth(width);
        setShape(shape);
        setStyle(style);
    }

    /**
     *
     * @param color
     * @return
     */
    public Line withColor(String color) {
        setColor(color);
        return this;
    }

    /**
     * Sets the line width
     * @param width
     * @return
     */
    public Line withWidth(double width) {
        setWidth(width);
        return this;
    }

    /**
     *
     * @param shape
     * @return
     */
    public Line withShape(LineShape shape) {
        setShape(shape);
        return this;
    }

    /**
     *
     * @param style
     * @return
     */
    public Line withStyle(LineStyle style) {
        setStyle(style);
        return this;
    }

    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }
}
