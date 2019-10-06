package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum LineShape {
    @XmlEnumValue("line")
    LINE,
    @XmlEnumValue("curve")
    CURVE
}
