package de.lukaskoerfer.simplepnml;

import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;

/**
 * Specifies a font in PNML
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Font implements Collectable, Defaultable {

    @Getter @Setter
    @NonNull
    private String family = "";

    @Getter @Setter
    @NonNull
    private String style = "";

    @Getter @Setter
    @NonNull
    private String weight = "";

    @Getter @Setter
    @NonNull
    private String size = "";

    @Getter @Setter
    @NonNull
    private FontDecoration decoration = FontDecoration.NONE;

    @Getter @Setter
    @NonNull
    private FontAlign align = FontAlign.LEFT;

    @Getter @Setter
    private double rotation = 0.0;

    /**
     * Creates a new font
     */
    public Font() { }

    @lombok.Builder
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
    private String getFamilyXml() {
        return requireNonDefaultElseNull(family);
    }

    private void setFamilyXml(String family) {
        this.family = family;
    }

    @XmlAttribute(name = "style")
    private String getStyleXml() {
        return requireNonDefaultElseNull(style);
    }

    private void setStyleXml(String style) {
        this.style = style;
    }

    @XmlAttribute(name = "weight")
    private String getWeightXml() {
        return requireNonDefaultElseNull(weight);
    }

    private void setWeightXml(String weight) {
        this.weight = weight;
    }

    @XmlAttribute(name = "size")
    private String getSizeXml() {
        return requireNonDefaultElseNull(size);
    }

    private void setSizeXml(String size) {
        this.size = size;
    }

    @XmlAttribute(name = "decoration")
    private FontDecoration getDecorationXml() {
        return requireNonDefaultElseNull(decoration);
    }

    private void setDecorationXml(FontDecoration decoration) {
        this.decoration = decoration;
    }

    @XmlAttribute(name = "align")
    private FontAlign getAlignXml() {
        return requireNonDefaultElseNull(align);
    }

    private void setAlignXml(FontAlign align) {
        this.align = align;
    }

    @XmlAttribute(name = "rotation")
    private Double getRotationXml() {
        return requireNonDefaultElseNull(rotation);
    }

    private void setRotationXml(Double rotation) {
        this.rotation = rotation;
    }
}
