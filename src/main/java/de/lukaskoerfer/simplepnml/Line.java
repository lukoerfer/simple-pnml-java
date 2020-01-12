package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Describes a graphical line element
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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
    @Getter @Setter
    @XmlAttribute(name = "color")
    private String color;

    /**
     * -- GETTER --
     * Gets the line width
     * @return
     * -- SETTER --
     * Sets the line width
     * @param width
     */
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
    @NonNull
    @Getter @Setter
    @Builder.Default
    private LineShape shape = LineShape.LINE;

    /**
     * -- GETTER --
     * Gets the line style
     * @return
     * -- SETTER --
     * Sets the line style
     * @param style
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private LineStyle style = LineStyle.SOLID;

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

    @XmlAttribute(name = "width")
    private Double getWidthXml() {
        return Objects.equals(getWidth(), 0.0) ? null : getWidth();
    }

    private void setWidthXml(Double width) {
        setWidth(width != null ? width : 0.0);
    }

    @XmlAttribute(name = "shape")
    private LineShape getShapeXml() {
        return Objects.equals(getShape(), LineShape.LINE) ? null : getShape();
    }

    private void setShapeXml(LineShape shape) {
        setShape(shape);
    }

    @XmlAttribute(name = "style")
    private LineStyle getStyleXml() {
        return Objects.equals(getStyle(), LineStyle.SOLID) ? null : getStyle();
    }

    private void setStyleXml(LineStyle style) {
        setStyle(style);
    }
}
