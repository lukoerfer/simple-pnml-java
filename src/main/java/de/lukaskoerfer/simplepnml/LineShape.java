package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import lombok.EqualsAndHashCode;

/**
 * Defines the supported line shapes
 */
@XmlEnum
public enum LineShape {
    /**
     * Straight line
     */
    @XmlEnumValue("line")
    LINE,
    /**
     * Curved line
     */
    @XmlEnumValue("curve")
    CURVE
}
