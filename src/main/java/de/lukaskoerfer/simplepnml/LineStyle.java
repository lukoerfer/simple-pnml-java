package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Defines the supported line styles
 */
@XmlEnum
public enum LineStyle implements Defaultable {
    /**
     * Solid line
     */
    @XmlEnumValue("solid")
    SOLID,
    /**
     * Dashed line
     */
    @XmlEnumValue("dash")
    DASH,
    /**
     * Dotted line
     */
    @XmlEnumValue("dot")
    DOT;

    @Override
    public boolean isDefault() {
        return equals(SOLID);
    }
}
