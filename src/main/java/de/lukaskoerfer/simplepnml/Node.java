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
    public Node(int x, int y) {
        setPosition(new Coordinates(x, y));
    }

    /**
     * Creates a new graphical node
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Node(int x, int y, int width, int height) {
        setPosition(new Coordinates(x, y));
        setSize(new Dimension(width, height));
    }

    /**
     * Sets the position in a fluent style
     * @param x
     * @param y
     * @return A reference to itself
     */
    public Node atPosition(int x, int y) {
        setPosition(new Coordinates(x, y));
        return this;
    }

    /**
     * Sets the size in a fluent style
     * @param width
     * @param height
     * @return A reference to itself
     */
    public Node ofSize(int width, int height) {
        setSize(new Dimension(width, height));
        return this;
    }

    /**
     * Sets the fill in a fluent style
     * @param fill
     * @return A reference to itself
     */
    public Node withFill(Fill fill) {
        setFill(fill);
        return this;
    }

    /**
     * Sets the fill in a fluent style
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
     * Sets the fill to an image in a fluent style
     * @param image
     * @return A reference to itself
     */
    public Node withFill(URI image) {
        setFill(new Fill(image));
        return this;
    }

    /**
     * Sets the line in a fluent style
     * @param line
     * @return A reference to itself
     */
    public Node withLine(Line line) {
        setLine(line);
        return this;
    }

    /**
     * Sets the line in a fluent style
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
