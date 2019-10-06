package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum FontDecoration {
    @XmlEnumValue("underline")
    UNDERLINE,
    @XmlEnumValue("overline")
    OVERLINE,
    @XmlEnumValue("line-through")
    LINE_THROUGH
}
