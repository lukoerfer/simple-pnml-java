package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Defines the supported gradient rotations
 */
@XmlEnum
public enum GradientRotation implements Defaults {
    /**
     *
     */
    NONE,
    /**
     * Vertical rotation
     */
    @XmlEnumValue("vertical")
    VERTICAL,
    /**
     * Horizontal rotation
     */
    @XmlEnumValue("horizontal")
    HORIZONTAL,
    /**
     * Diagonal rotation
     */
    @XmlEnumValue("diagonal")
    DIAGONAL;

    @Override
    public boolean isDefault() {
        return equals(NONE);
    }
}
