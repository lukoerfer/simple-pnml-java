package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.net.URI;
import java.util.stream.Stream;

/**
 * Describes the graphics of a node element
 */
@EqualsAndHashCode
public class Node implements Collectable, Lined, Filled {

    /**
     * -- GETTER --
     * Gets the position of this graphical node
     * @return
     * -- SETTER --
     * Sets the position of this graphical node
     * @param position
     */
    @XmlElement(name = "position", required = true)
    @Getter @Setter
    private Position position = new Position();

    /**
     * -- GETTER --
     * Gets the size of this graphical node
     * @return
     * -- SETTER --
     * Sets the size of this graphical node
     * @param size
     */
    @XmlElement(name = "dimension")
    @Getter @Setter
    private Size size;

    /**
     * -- GETTER --
     * Gets the fill of this graphical node
     * @return
     * -- SETTER --
     * Sets the fill of this graphical node
     * @param fill
     */
    @XmlElement(name = "fill")
    @Getter @Setter
    private Fill fill;

    /**
     * -- GETTER --
     * Gets the line of this graphical node
     * @return
     * -- SETTER --
     * Sets the line of this graphical node
     * @param line
     */
    @XmlElement(name = "line")
    @Getter @Setter
    private Line line;

    /**
     * Creates a new graphical node
     */
    public Node() {}

    /**
     * Creates a new graphical node
     * @param x The position in X direction
     * @param y The position in Y direction
     */
    public Node(double x, double y) {
        setPosition(new Position(x, y));
    }

    /**
     * Creates a new graphical node
     * @param x The position in X direction
     * @param y The position in Y direction
     * @param fill
     */
    public Node(double x, double y, Fill fill) {
        setPosition(new Position(x, y));
        setFill(fill);
    }

    /**
     * Creates a new graphical node
     * @param x The position in X direction
     * @param y The position in Y direction
     * @param line
     */
    public Node(double x, double y, Line line) {
        setPosition(new Position(x, y));
        setLine(line);
    }

    /**
     * Creates a new graphical node
     * @param x The position in X direction
     * @param y The position in Y direction
     * @param fill
     * @param line
     */
    public Node(double x, double y, Fill fill, Line line) {
        setPosition(new Position(x, y));
        setFill(fill);
        setLine(line);
    }

    /**
     * Creates a new graphical node
     * @param x The position in X direction
     * @param y The position in Y direction
     * @param width
     * @param height
     */
    public Node(double x, double y, double width, double height) {
        setPosition(new Position(x, y));
        setSize(new Size(width, height));
    }

    /**
     * Creates a new graphical node
     * @param x The position in X direction
     * @param y The position in Y direction
     * @param width
     * @param height
     * @param fill
     */
    public Node(double x, double y, double width, double height, Fill fill) {
        setPosition(new Position(x, y));
        setSize(new Size(width, height));
        setFill(fill);
    }

    /**
     * Creates a new graphical node
     * @param x The position in X direction
     * @param y The position in Y direction
     * @param width
     * @param height
     * @param line
     */
    public Node(double x, double y, double width, double height, Line line) {
        setPosition(new Position(x, y));
        setSize(new Size(width, height));
        setLine(line);
    }

    /**
     * Creates a new graphical node
     * @param x The position in X direction
     * @param y The position in Y direction
     * @param width
     * @param height
     * @param fill
     * @param line
     */
    public Node(double x, double y, double width, double height, Fill fill, Line line) {
        setPosition(new Position(x, y));
        setSize(new Size(width, height));
        setFill(fill);
        setLine(line);
    }

    /**
     * Sets the position of this graphical node
     * @param x The position in X direction
     * @param y The position in Y direction
     * @return A reference to this graphical node
     */
    public Node atPosition(double x, double y) {
        setPosition(new Position(x, y));
        return this;
    }

    /**
     * Sets the size of this graphical node
     * @param width
     * @param height
     * @return A reference to this graphical node
     */
    public Node ofSize(double width, double height) {
        setSize(new Size(width, height));
        return this;
    }

    /**
     * Sets the fill of this graphical node
     * @param fill
     * @return A reference to this graphical node
     */
    public Node withFill(Fill fill) {
        setFill(fill);
        return this;
    }

    /**
     * Defines the fill of this graphical node
     * @param color The fill color
     * @param gradientColor The gradient color
     * @param gradientRotation The gradient rotation
     * @return A reference to this graphical node
     */
    public Node withFill(String color, String gradientColor, GradientRotation gradientRotation) {
        setFill(new Fill(color, gradientColor, gradientRotation));
        return this;
    }

    /**
     * Sets the fill of this graphical node to an image
     * @param image
     * @return A reference to this graphical node
     */
    public Node withFill(URI image) {
        setFill(new Fill(image));
        return this;
    }

    /**
     * Sets the line of this graphical node
     * @param line
     * @return A reference to this graphical node
     */
    public Node withLine(Line line) {
        setLine(line);
        return this;
    }

    /**
     * Defines the line of this graphical node
     * @param color The line color
     * @param width The line width
     * @param shape The line shape
     * @param style The line style
     * @return A reference to this graphical node
     */
    public Node withLine(String color, double width, LineShape shape, LineStyle style) {
        setLine(new Line(color, width, shape, style));
        return this;
    }

    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(position)
            .collect(size)
            .collect(fill)
            .collect(line)
            .build();
    }
}
