package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum LineStyle {
    @XmlEnumValue("solid")
    SOLID,
    @XmlEnumValue("dash")
    DASH,
    @XmlEnumValue("dot")
    DOT
}
