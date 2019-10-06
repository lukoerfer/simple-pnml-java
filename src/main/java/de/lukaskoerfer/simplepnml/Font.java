package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Font {

    @XmlAttribute
    @Getter @Setter
    private String family;

    @XmlAttribute
    @Getter @Setter
    private String style;

    @XmlAttribute
    @Getter @Setter
    private String weight;

    @XmlAttribute
    @Getter @Setter
    private String size;

    @XmlAttribute
    @Getter @Setter
    private FontDecoration decoration;

    @XmlAttribute
    @Getter @Setter
    private FontAlign align;

    @XmlAttribute
    @Getter @Setter
    private double rotation;

}
