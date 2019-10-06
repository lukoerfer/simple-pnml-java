package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Line {

    @XmlAttribute
    @Getter @Setter
    private LineShape shape;

    @XmlAttribute
    @Getter @Setter
    private String color;

    @XmlAttribute
    @Getter @Setter
    private double width;

    @XmlAttribute
    @Getter @Setter
    private LineStyle style;

}
