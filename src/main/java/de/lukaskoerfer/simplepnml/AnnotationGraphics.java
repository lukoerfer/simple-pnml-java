package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AnnotationGraphics {

    @XmlElement
    @Getter @Setter
    private Coordinates offset = new Coordinates();

    @XmlElement
    @Getter @Setter
    private Fill fill;

    @XmlElement
    @Getter @Setter
    private Line line;

    @XmlElement
    @Getter @Setter
    private Font font;

}
