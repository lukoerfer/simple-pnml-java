package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class NodeGraphics {

    @XmlElement(required = true)
    @Getter @Setter
    private Coordinates position = new Coordinates();

    @XmlElement
    @Getter @Setter
    private Dimension dimension;

    @XmlElement
    @Getter @Setter
    private Fill fill;

    @XmlElement
    @Getter @Setter
    private Line line;

}
