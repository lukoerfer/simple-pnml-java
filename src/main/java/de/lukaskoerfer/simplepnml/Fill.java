package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.stream.Stream;

/**
 * Describes the fill of a graphical element
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Fill implements Collectable, Defaults {

    /**
     * -- GETTER --
     * Gets the fill color
     * @return A string describing a color
     * -- SETTER --
     * Sets the fill color
     * @param color A string describing a color
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private String color = "";

    /**
     * -- GETTER --
     * Gets the gradient color
     * @return A string describing a color
     * -- SETTER --
     * Sets the gradient color
     * @param gradientColor A string describing a color
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private String gradientColor = "";

    /**
     * -- GETTER --
     * Gets the gradient rotation
     * @return A gradient rotation
     * -- SETTER --
     * Sets the gradient rotation
     * @param gradientRotation A gradient rotation
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private GradientRotation gradientRotation = GradientRotation.NONE;

    /**
     * -- GETTER --
     * Gets the fill image
     * @return An URI pointing to the fill image
     * -- SETTER --
     * Sets the fill image
     * @param image An URI pointing to the fill image
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private String image = "";

    /**
     * Creates a new fill
     */
    public Fill() { }

    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }

    @Override
    public boolean isDefault() {
        return color.isEmpty()
            && gradientColor.isEmpty()
            && gradientRotation.isDefault()
            && image.isEmpty();
    }

    //region Internal serialization

    @XmlAttribute(name = "color")
    @SuppressWarnings("unused")
    private String getColorXml() {
        return Defaults.requireNonDefault(color);
    }

    @SuppressWarnings("unused")
    private void setColorXml(String color) {
        this.color = color;
    }

    @XmlAttribute(name = "gradient-color")
    @SuppressWarnings("unused")
    private String getGradientColorXml() {
        return Defaults.requireNonDefault(gradientColor);
    }

    @SuppressWarnings("unused")
    private void setGradientColorXml(String gradientColor) {
        this.gradientColor = gradientColor;
    }

    @XmlAttribute(name = "gradient-rotation")
    @SuppressWarnings("unused")
    private GradientRotation getGradientRotationXml() {
        return Defaults.requireNonDefault(gradientRotation);
    }

    @SuppressWarnings("unused")
    private void setGradientRotationXml(GradientRotation gradientRotation) {
        this.gradientRotation = gradientRotation;
    }

    @XmlAttribute(name = "image")
    @SuppressWarnings("unused")
    private String getImageXml() {
        return Defaults.requireNonDefault(image);
    }

    @SuppressWarnings("unused")
    private void setImageXml(String image) {
        this.image = image;
    }

    //endregion
}
