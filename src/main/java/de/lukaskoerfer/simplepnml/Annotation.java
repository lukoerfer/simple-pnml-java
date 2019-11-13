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
public class Annotation {

    /**
     *
     */
    @XmlElement
    @Getter @Setter
    private Coordinates offset = new Coordinates();

    /**
     *
     */
    @XmlElement
    @Getter @Setter
    private Fill fill;

    /**
     *
     */
    @XmlElement
    @Getter @Setter
    private Line line;

    /**
     *
     */
    @XmlElement
    @Getter @Setter
    private Font font;

    /**
     * Creates a new annotation graphics
     * @param x The offset in X direction
     * @param y The offset in Y direction
     */
    public Annotation(double x, double y) {
        setOffset(new Coordinates(x, y));
    }

    /**
     * Creates a new annotation graphics
     * @param x The offset in X direction
     * @param y The offset in Y direction
     * @param fill
     */
    public Annotation(double x, double y, Fill fill) {
        setOffset(new Coordinates(x, y));
        setFill(fill);
    }

    public Annotation(double x, double y, Line line) {
        setOffset(new Coordinates(x, y));
        setLine(line);
    }

    public Annotation(double x, double y, Font font) {
        setOffset(new Coordinates(x, y));
        setFont(font);
    }

    public Annotation(double x, double y, Fill fill, Line line) {
        setOffset(new Coordinates(x, y));
        setFill(fill);
        setLine(line);
    }

    public Annotation(double x, double y, Fill fill, Font font) {
        setOffset(new Coordinates(x, y));
        setFill(fill);
        setFont(font);
    }

    public Annotation(double x, double y, Line line, Font font) {
        setOffset(new Coordinates(x, y));
        setLine(line);
        setFont(font);
    }

    public Annotation(double x, double y, Fill fill, Line line, Font font) {
        setOffset(new Coordinates(x, y));
        setFill(fill);
        setLine(line);
        setFont(font);
    }

    /**
     * Sets the annotation offset
     * @param x The offset in X direction
     * @param y The offset in Y direction
     * @return A reference to itself
     */
    public Annotation offset(double x, double y) {
        setOffset(new Coordinates(x, y));
        return this;
    }

    public Annotation withFill(Fill fill) {
        setFill(fill);
        return this;
    }

    public Annotation withFill(String color, String gradientColor, GradientRotation gradientRotation) {
        setFill(new Fill(color, gradientColor, gradientRotation));
        return this;
    }

    public Annotation withFill(URI image) {
        setFill(new Fill(image));
        return this;
    }

    public Annotation withLine(Line line) {
        setLine(line);
        return this;
    }

    public Annotation withLine(String color, double width, LineShape shape, LineStyle style) {
        setLine(new Line(color, width, shape, style));
        return this;
    }

    public Annotation withFont(Font font) {
        setFont(font);
        return this;
    }

}
