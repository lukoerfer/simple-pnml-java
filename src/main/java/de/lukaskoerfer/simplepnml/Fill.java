package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import java.net.URI;

@NoArgsConstructor
@EqualsAndHashCode
public class Fill {

    @XmlAttribute
    @Getter @Setter
    private String color;

    @XmlAttribute
    @Getter @Setter
    private String gradientColor;

    @XmlAttribute
    @Getter @Setter
    private GradientRotation gradientRotation;

    @XmlAttribute
    @Getter @Setter
    private URI image;

    public Fill(String color, String gradientColor, GradientRotation gradientRotation) {
        setColor(color);
        setGradientColor(gradientColor);
        setGradientRotation(gradientRotation);
    }

    public Fill(URI image) {
        setImage(image);
    }

}
