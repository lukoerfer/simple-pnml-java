package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;

@NoArgsConstructor
@AllArgsConstructor
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
    private GradientRotation rotation;

    @XmlAttribute
    @Getter @Setter
    private String image;

}
