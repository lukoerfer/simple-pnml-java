package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Dimension {

    @XmlAttribute
    @Getter @Setter
    private int x;

    @XmlAttribute
    @Getter @Setter
    private int y;

}
