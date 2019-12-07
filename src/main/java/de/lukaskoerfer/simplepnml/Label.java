package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Describes a text at a specific position
 */
@EqualsAndHashCode
public class Label implements Collectable, AnnotationElement {

    /**
     * -- GETTER --
     * Gets the text of this label
     * @return The text
     * -- SETTER --
     * Sets the text of this label
     * @param text The text
     */
    @XmlElement
    @Getter @Setter
    private String text;

    /**
     * -- GETTER --
     * Gets the graphics of this label
     * @return The graphics description
     * -- SETTER --
     * Sets the graphics of this label
     * @param graphics The graphics description
     */
    @XmlElement
    @Getter @Setter
    private Annotation graphics;

    /**
     * Creates an empty label
     */
    public Label() {}

    /**
     * Creates a new label
     * @param value The value to use as text
     */
    public Label(int value) {
        setText(Integer.toString(value));
    }

    /**
     * Creates a new label
     * @param value The value to use as text
     */
    public Label(double value) {
        setText(Double.toString(value));
    }

    /**
     * Creates a new label
     * @param text The label text
     */
    public Label(String text) {
        setText(text);
    }

    /**
     * Sets the text of this label
     * @param text A string
     * @return A reference to this label
     */
    public Label withText(String text) {
        setText(text);
        return this;
    }

    /**
     * Sets the graphics of this label
     * @param graphics
     * @return A reference to this label
     */
    public Label withGraphics(Annotation graphics) {
        setGraphics(graphics);
        return this;
    }

    /**
     * Defines the graphics of this label
     * @param x The offset in X direction
     * @param y The offset in Y direction
     * @return A reference to this label
     */
    public Label withGraphics(double x, double y) {
        setGraphics(new Annotation(x, y));
        return this;
    }

    /**
     * Defines the graphics of this label
     * @param x The offset in X direction
     * @param y The offset in Y direction
     * @param fill
     * @param line
     * @param font
     * @return A reference to this label
     */
    public Label withGraphics(double x, double y, Fill fill, Line line, Font font) {
        setGraphics(new Annotation(x, y, fill, line, font));
        return this;
    }


    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(graphics)
            .build();
    }
}
