package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum GradientRotation {
    @XmlEnumValue("vertical")
    VERTICAL,
    @XmlEnumValue("horizontal")
    HORIZONTAL,
    @XmlEnumValue("diagonal")
    DIAGONAL
}
