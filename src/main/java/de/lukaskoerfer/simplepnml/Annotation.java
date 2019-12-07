package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.net.URI;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Describes the graphics of an annotation element
 */
@EqualsAndHashCode
public class Annotation implements Collectable, Filled, Lined {

    /**
     * -- GETTER --
     * Gets the offset of this annotation graphics
     * @return A set of relative coordinates
     * -- SETTER --
     * Sets the offsets of this annotation graphics
     * @param offset A set of relative coordinates
     */
    @XmlElement
    @Getter @Setter
    private Position offset = new Position();

    /**
     * -- GETTER --
     * Gets the fill of this annotation graphics
     * @return
     * -- SETTER --
     * Sets the fill of this annotation graphics
     * @param fill
     */
    @XmlElement
    @Getter @Setter
    private Fill fill;

    /**
     * -- GETTER --
     * Gets the line of this annotation graphics
     * @return
     * -- SETTER --
     * Sets the line of this annotation graphics
     * @param line
     */
    @XmlElement
    @Getter @Setter
    private Line line;

    /**
     * -- GETTER --
     * Gets the font of this annotation graphics
     * @return
     * -- SETTER --
     * Sets the font of this annotation graphics
     * @param font
     */
    @XmlElement
    @Getter @Setter
    private Font font;

    /**
     * Creates a new annotation graphics
     */
    public Annotation() {}

    /**
     * Creates a new annotation graphics
     * @param x The offset in X direction
     * @param y The offset in Y direction
     */
    public Annotation(double x, double y) {
        setOffset(new Position(x, y));
    }

    /**
     * Creates a new annotation graphics
     * @param x The offset in X direction
     * @param y The offset in Y direction
     * @param fill
     */
    public Annotation(double x, double y, Fill fill) {
        setOffset(new Position(x, y));
        setFill(fill);
    }

    /**
     * Creates a new annotation graphics
     * @param x The offset in X direction
     * @param y The offset in Y direction
     * @param line
     */
    public Annotation(double x, double y, Line line) {
        setOffset(new Position(x, y));
        setLine(line);
    }

    /**
     * Creates a new annotation graphics
     * @param x The offset in X direction
     * @param y The offset in Y direction
     * @param font
     */
    public Annotation(double x, double y, Font font) {
        setOffset(new Position(x, y));
        setFont(font);
    }

    /**
     * Creates a new annotation graphics
     * @param x The offset in X direction
     * @param y The offset in Y direction
     * @param fill
     * @param line
     */
    public Annotation(double x, double y, Fill fill, Line line) {
        setOffset(new Position(x, y));
        setFill(fill);
        setLine(line);
    }

    /**
     * Creates a new annotation graphics
     * @param x The offset in X direction
     * @param y The offset in Y direction
     * @param fill
     * @param font
     */
    public Annotation(double x, double y, Fill fill, Font font) {
        setOffset(new Position(x, y));
        setFill(fill);
        setFont(font);
    }

    /**
     * Creates a new annotation graphics
     * @param x The offset in X direction
     * @param y The offset in Y direction
     * @param line
     * @param font
     */
    public Annotation(double x, double y, Line line, Font font) {
        setOffset(new Position(x, y));
        setLine(line);
        setFont(font);
    }

    /**
     * Creates a new annotation graphics
     * @param x The offset in X direction
     * @param y The offset in Y direction
     * @param fill
     * @param line
     * @param font
     */
    public Annotation(double x, double y, Fill fill, Line line, Font font) {
        setOffset(new Position(x, y));
        setFill(fill);
        setLine(line);
        setFont(font);
    }

    /**
     * Sets the offset of this annotation graphics
     * @param x The offset in X direction
     * @param y The offset in Y direction
     * @return A reference to this annotation graphics
     */
    public Annotation offset(double x, double y) {
        setOffset(new Position(x, y));
        return this;
    }

    /**
     * Sets the fill of this annotation graphics
     * @param fill The fill description
     * @return A reference to this annotation graphics
     */
    public Annotation withFill(Fill fill) {
        setFill(fill);
        return this;
    }

    /**
     * Defines the  fill of this annotation
     * @param color The fill color
     * @param gradientColor An optional gradient color
     * @param gradientRotation An optional gradient rotation
     * @return A reference to this annotation graphics
     */
    public Annotation withFill(String color, String gradientColor, GradientRotation gradientRotation) {
        setFill(new Fill(color, gradientColor, gradientRotation));
        return this;
    }

    /**
     * Sets the fill of this annotation to an image
     * @param image The URI to the image
     * @return A reference to this annotation graphics
     */
    public Annotation withFill(URI image) {
        setFill(new Fill(image));
        return this;
    }

    /**
     * Sets the annotation line
     * @param line The line description
     * @return A reference to this annotation graphics
     */
    public Annotation withLine(Line line) {
        setLine(line);
        return this;
    }

    /**
     * Defines the line of this annotation
     * @param color The line color
     * @param width The line width
     * @param shape The line shape
     * @param style The line style
     * @return A reference to this annotation graphics
     */
    public Annotation withLine(String color, double width, LineShape shape, LineStyle style) {
        setLine(new Line(color, width, shape, style));
        return this;
    }

    /**
     * Sets the font of this annotation
     * @param font The annotation font
     * @return A reference to this annotation graphics
     */
    public Annotation withFont(Font font) {
        setFont(font);
        return this;
    }

    @Override
    public Stream<Collectable> collect() {
        return null;
    }
}
