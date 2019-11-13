package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Defines the supported font alignments
 */
@XmlEnum
public enum FontAlign {
    /**
     * Align left
     */
    @XmlEnumValue("left")
    LEFT,
    /**
     * Align centered
     */
    @XmlEnumValue("center")
    CENTER,
    /**
     * Align right
     */
    @XmlEnumValue("right")
    RIGHT
}
