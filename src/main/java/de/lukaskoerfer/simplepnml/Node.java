package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.net.URI;

/**
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Node {

    @XmlElement(name = "position", required = true)
    @Getter @Setter
    private Coordinates position = new Coordinates();

    @XmlElement(name = "dimension")
    @Getter @Setter
    private Dimension size;

    @XmlElement(name = "fill")
    @Getter @Setter
    private Fill fill;

    @XmlElement(name = "line")
    @Getter @Setter
    private Line line;

    /**
     * Creates a new graphical node
     * @param x
     * @param y
     */
    public Node(double x, double y) {
        setPosition(new Coordinates(x, y));
    }

    public Node(double x, double y, Fill fill) {
        setPosition(new Coordinates(x, y));
        setFill(fill);
    }

    public Node(double x, double y, Line line) {
        setPosition(new Coordinates(x, y));
        setLine(line);
    }

    public Node(double x, double y, Fill fill, Line line) {
        setPosition(new Coordinates(x, y));
        setFill(fill);
        setLine(line);
    }

    /**
     * Creates a new graphical node
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Node(double x, double y, double width, double height) {
        setPosition(new Coordinates(x, y));
        setSize(new Dimension(width, height));
    }

    public Node(double x, double y, double width, double height, Fill fill) {
        setPosition(new Coordinates(x, y));
        setSize(new Dimension(width, height));
        setFill(fill);
    }

    public Node(double x, double y, double width, double height, Line line) {
        setPosition(new Coordinates(x, y));
        setSize(new Dimension(width, height));
        setLine(line);
    }

    public Node(double x, double y, double width, double height, Fill fill, Line line) {
        setPosition(new Coordinates(x, y));
        setSize(new Dimension(width, height));
        setFill(fill);
        setLine(line);
    }

    /**
     * Sets the position
     * @param x
     * @param y
     * @return A reference to itself
     */
    public Node atPosition(double x, double y) {
        setPosition(new Coordinates(x, y));
        return this;
    }

    /**
     * Sets the size
     * @param width
     * @param height
     * @return A reference to itself
     */
    public Node ofSize(double width, double height) {
        setSize(new Dimension(width, height));
        return this;
    }

    /**
     * Sets the fill
     * @param fill
     * @return A reference to itself
     */
    public Node withFill(Fill fill) {
        setFill(fill);
        return this;
    }

    /**
     * Sets the fill
     * @param color
     * @param gradientColor
     * @param gradientRotation
     * @return A reference to itself
     */
    public Node withFill(String color, String gradientColor, GradientRotation gradientRotation) {
        setFill(new Fill(color, gradientColor, gradientRotation));
        return this;
    }

    /**
     * Sets the fill to an image
     * @param image
     * @return A reference to itself
     */
    public Node withFill(URI image) {
        setFill(new Fill(image));
        return this;
    }

    /**
     * Sets the line
     * @param line
     * @return A reference to itself
     */
    public Node withLine(Line line) {
        setLine(line);
        return this;
    }

    /**
     * Sets the line
     * @param color
     * @param width
     * @param shape
     * @param style
     * @return A reference to itself
     */
    public Node withLine(String color, double width, LineShape shape, LineStyle style) {
        setLine(new Line(color, width, shape, style));
        return this;
    }

}
