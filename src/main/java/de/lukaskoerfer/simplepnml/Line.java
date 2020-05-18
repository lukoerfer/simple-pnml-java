package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.stream.Stream;

/**
 * Describes a graphical line element
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Line implements Collectable, Defaults {

    /**
     * -- GETTER --
     * Gets the line color
     * @return
     * -- SETTER --
     * Sets the line color
     * @param color
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private String color = "";

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

    @Override
    public boolean isDefault() {
        return getColor().isEmpty()
            && getWidth() == 0.0
            && getShape() == LineShape.LINE
            && getStyle() == LineStyle.SOLID;
    }

    //region Internal serialization

    @XmlAttribute(name = "color")
    @SuppressWarnings("unused")
    private String getColorXml() {
        return Defaults.requireNonDefault(getColor());
    }

    @SuppressWarnings("unused")
    private void setColorXml(String color) {
        setColor(color);
    }

    @XmlAttribute(name = "width")
    @SuppressWarnings("unused")
    private Double getWidthXml() {
        return Defaults.requireNonDefault(getWidth());
    }

    @SuppressWarnings("unused")
    private void setWidthXml(Double value) {
        setWidth(value);
    }

    @XmlAttribute(name = "shape")
    @SuppressWarnings("unused")
    private LineShape getShapeXml() {
        return Defaults.requireNonDefault(getShape());
    }

    @SuppressWarnings("unused")
    private void setShapeXml(LineShape shape) {
        setShape(shape);
    }

    @XmlAttribute(name = "style")
    @SuppressWarnings("unused")
    private LineStyle getStyleXml() {
        return Defaults.requireNonDefault(getStyle());
    }

    @SuppressWarnings("unused")
    private void setStyleXml(LineStyle style) {
        setStyle(style);
    }

    //endregion

}
