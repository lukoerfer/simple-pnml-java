package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNullElse;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Describes a graphical line element
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Line implements Collectable, Defaults {

    private String color = "";
    private double width = 0.0;
    private LineShape shape = LineShape.LINE;
    private LineStyle style = LineStyle.SOLID;

    /**
     * Creates a new line
     */
    public Line() { }

    @Builder
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public LineShape getShape() {
        return shape;
    }

    public void setShape(LineShape shape) {
        this.shape = shape;
    }

    public LineStyle getStyle() {
        return style;
    }

    public void setStyle(LineStyle style) {
        this.style = style;
    }

    @XmlAttribute(name = "color")
    @SuppressWarnings("unused")
    private String getColorXml() {
        return Defaults.requireNonDefaultElseNull(getColor());
    }

    @SuppressWarnings("unused")
    private void setColorXml(String color) {
        setColor(color);
    }

    @XmlAttribute(name = "width")
    @SuppressWarnings("unused")
    private Double getWidthXml() {
        return Defaults.requireNonDefaultElseNull(getWidth());
    }

    @SuppressWarnings("unused")
    private void setWidthXml(Double value) {
        setWidth(value);
    }

    @XmlAttribute(name = "shape")
    @SuppressWarnings("unused")
    private LineShape getShapeXml() {
        return Defaults.requireNonDefaultElseNull(getShape());
    }

    @SuppressWarnings("unused")
    private void setShapeXml(LineShape shape) {
        setShape(shape);
    }

    @XmlAttribute(name = "style")
    @SuppressWarnings("unused")
    private LineStyle getStyleXml() {
        return Defaults.requireNonDefaultElseNull(getStyle());
    }

    @SuppressWarnings("unused")
    private void setStyleXml(LineStyle style) {
        setStyle(style);
    }

}
