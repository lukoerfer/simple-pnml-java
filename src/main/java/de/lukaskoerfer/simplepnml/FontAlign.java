package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum FontAlign {
    @XmlEnumValue("left")
    LEFT,
    @XmlEnumValue("center")
    CENTER,
    @XmlEnumValue("right")
    RIGHT
}
