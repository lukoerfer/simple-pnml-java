package de.lukaskoerfer.simplepnml;

import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import static de.lukaskoerfer.simplepnml.Defaults.requireNonDefaultElseNull;

/**
 * Describes the fill of a graphical element
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Fill implements Collectable, Defaults {

    private String color = "";
    private String gradientColor = "";
    private GradientRotation gradientRotation = GradientRotation.NONE;
    private String image = "";

    /**
     * Creates a new fill
     */
    public Fill() { }

    @Builder
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

    /**
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGradientColor() {
        return gradientColor;
    }

    public void setGradientColor(String gradientColor) {
        this.gradientColor = gradientColor;
    }

    public GradientRotation getGradientRotation() {
        return gradientRotation;
    }

    public void setGradientRotation(GradientRotation gradientRotation) {
        this.gradientRotation = gradientRotation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlAttribute(name = "color")
    @SuppressWarnings("unused")
    private String getColorXml() {
        return requireNonDefaultElseNull(getColor());
    }

    @SuppressWarnings("unused")
    private void setColorXml(String color) {
        setColor(color);
    }

    @XmlAttribute(name = "gradient-color")
    @SuppressWarnings("unused")
    private String getGradientColorXml() {
        return requireNonDefaultElseNull(getGradientColor());
    }

    @SuppressWarnings("unused")
    private void setGradientColorXml(String gradientColor) {
        setGradientColor(gradientColor);
    }

    @XmlAttribute(name = "gradient-rotation")
    @SuppressWarnings("unused")
    private GradientRotation getGradientRotationXml() {
        return requireNonDefaultElseNull(getGradientRotation());
    }

    @SuppressWarnings("unused")
    private void setGradientRotationXml(GradientRotation gradientRotation) {
        setGradientRotation(gradientRotation);
    }

    @XmlAttribute(name = "image")
    @SuppressWarnings("unused")
    private String getImageXml() {
        return requireNonDefaultElseNull(getImage());
    }

    @SuppressWarnings("unused")
    private void setImageXml(String image) {
        setImage(image);
    }

    //endregion
}
