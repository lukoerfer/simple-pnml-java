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
 * Describes the fill of a graphical element
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Fill implements Collectable, Defaultable {

    @Getter @Setter
    @NonNull
    private String color = "";

    @Getter @Setter
    @NonNull
    private String gradientColor = "";

    @Getter @Setter
    @NonNull
    private GradientRotation gradientRotation = GradientRotation.NONE;

    @Getter @Setter
    @NonNull
    private String image = "";

    /**
     * Creates a new fill
     */
    public Fill() { }

    @lombok.Builder
    private Fill(String color, String gradientColor, GradientRotation gradientRotation, String image) {
        this.color = color;
        this.gradientColor = gradientColor;
        this.gradientRotation = gradientRotation;
        this.image = image;
    }

    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }

    @Override
    public boolean isDefault() {
        return getColor().isEmpty()
            && getGradientColor().isEmpty()
            && getGradientRotation().isDefault()
            && getImage().isEmpty();
    }

    @XmlAttribute(name = "color")
    private String getColorXml() {
        return requireNonDefaultElseNull(color);
    }

    private void setColorXml(String color) {
        this.color = color;
    }

    @XmlAttribute(name = "gradient-color")
    private String getGradientColorXml() {
        return requireNonDefaultElseNull(gradientColor);
    }

    private void setGradientColorXml(String gradientColor) {
        this.gradientColor = gradientColor;
    }

    @XmlAttribute(name = "gradient-rotation")
    private GradientRotation getGradientRotationXml() {
        return requireNonDefaultElseNull(gradientRotation);
    }

    private void setGradientRotationXml(GradientRotation gradientRotation) {
        this.gradientRotation = gradientRotation;
    }

    @XmlAttribute(name = "image")
    private String getImageXml() {
        return requireNonDefaultElseNull(image);
    }

    private void setImageXml(String image) {
        this.image = image;
    }

}
