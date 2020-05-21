package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNullElse;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Specifies a font
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Font implements Collectable, Defaults {

    private String family = "";
    private String style = "";
    private String weight = "";
    private String size = "";
    private FontDecoration decoration = FontDecoration.NONE;
    private FontAlign align = FontAlign.LEFT;
    private double rotation = 0.0;

    /**
     * Creates a new font
     */
    public Font() { }

    @Builder
    private Font(String family, String style, String weight, String size,
                FontDecoration decoration, FontAlign align, double rotation) {
        this.family = family;
        this.style = style;
        this.weight = weight;
        this.size = size;
        this.decoration = decoration;
        this.align = align;
        this.rotation = rotation;
    }

    /**
     *
     * @return
     */
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }

    /**
     *
     * @return
     */
    public boolean isDefault() {
        return getFamily().isEmpty()
            && getStyle().isEmpty()
            && getWeight().isEmpty()
            && getSize().isEmpty()
            && getDecoration().isDefault()
            && getAlign().isDefault()
            && getRotation() == 0.0;
    }

    @XmlAttribute(name = "family")
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @XmlAttribute(name = "style")
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @XmlAttribute(name = "weight")
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @XmlAttribute(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @XmlAttribute(name = "decoration")
    public FontDecoration getDecoration() {
        return decoration;
    }

    public void setDecoration(FontDecoration decoration) {
        this.decoration = decoration;
    }

    @XmlAttribute(name = "align")
    public FontAlign getAlign() {
        return align;
    }

    public void setAlign(FontAlign align) {
        this.align = align;
    }

    @XmlAttribute(name = "rotation")
    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
}
