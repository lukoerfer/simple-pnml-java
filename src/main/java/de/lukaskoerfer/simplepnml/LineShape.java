package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Defines the supported line shapes
 */
@XmlEnum
public enum LineShape implements Defaults {
    /**
     * Straight line
     */
    @XmlEnumValue("line")
    LINE,
    /**
     * Curved line
     */
    @XmlEnumValue("curve")
    CURVE;

    @Override
    public boolean isDefault() {
        return equals(LINE);
    }
}
