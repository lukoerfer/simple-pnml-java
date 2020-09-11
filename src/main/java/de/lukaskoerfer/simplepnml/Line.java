package de.lukaskoerfer.simplepnml;

import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Describes a graphical line element
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Line implements Collectable, Defaultable {

    @Getter @Setter
    @NonNull
    private String color = "";

    @Getter @Setter
    private double width = 0.0;

    @Getter @Setter
    @NonNull
    private LineShape shape = LineShape.LINE;

    @Getter @Setter
    @NonNull
    private LineStyle style = LineStyle.SOLID;

    /**
     * Creates a new line
     */
    public Line() { }

    @lombok.Builder
    private Line(String color, double width, LineShape shape, LineStyle style) {
        this.color = color;
        this.width = width;
        this.shape = shape;
        this.style = style;
    }

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

    @XmlAttribute(name = "color")
    private String getColorXml() {
        return Defaultable.requireNonDefaultElseNull(getColor());
    }

    private void setColorXml(String color) {
        setColor(color);
    }

    @XmlAttribute(name = "width")
    private Double getWidthXml() {
        return Defaultable.requireNonDefaultElseNull(getWidth());
    }

    private void setWidthXml(Double value) {
        setWidth(value);
    }

    @XmlAttribute(name = "shape")
    private LineShape getShapeXml() {
        return Defaultable.requireNonDefaultElseNull(getShape());
    }

    private void setShapeXml(LineShape shape) {
        setShape(shape);
    }

    @XmlAttribute(name = "style")
    private LineStyle getStyleXml() {
        return Defaultable.requireNonDefaultElseNull(getStyle());
    }

    private void setStyleXml(LineStyle style) {
        setStyle(style);
    }

}
