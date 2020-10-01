package de.lukaskoerfer.simplepnml;

import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;

/**
 * Describes a graphical line element
 */
@EqualsAndHashCode
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
        return color.isEmpty()
            && width == 0.0
            && shape == LineShape.LINE
            && style == LineStyle.SOLID;
    }

    @XmlAttribute(name = "color")
    private String getColorXml() {
        return requireNonDefaultElseNull(color);
    }

    private void setColorXml(String color) {
        this.color = color;
    }

    @XmlAttribute(name = "width")
    private Double getWidthXml() {
        return requireNonDefaultElseNull(width);
    }

    private void setWidthXml(Double width) {
        this.width = width;
    }

    @XmlAttribute(name = "shape")
    private LineShape getShapeXml() {
        return requireNonDefaultElseNull(shape);
    }

    private void setShapeXml(LineShape shape) {
        this.shape = shape;
    }

    @XmlAttribute(name = "style")
    private LineStyle getStyleXml() {
        return requireNonDefaultElseNull(style);
    }

    private void setStyleXml(LineStyle style) {
        this.style = style;
    }

}
