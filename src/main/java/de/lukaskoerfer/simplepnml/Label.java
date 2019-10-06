package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 */
@NoArgsConstructor
@EqualsAndHashCode
public class Label {

    @XmlElement
    @Getter @Setter
    private String text;

    @XmlElement
    @Getter @Setter
    private NodeGraphics graphics;

}
