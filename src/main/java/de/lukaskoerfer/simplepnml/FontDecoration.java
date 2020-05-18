package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Defines the supported font decorations
 */
@XmlEnum
public enum FontDecoration implements Defaults {
    /**
     *
     */
    NONE,
    /**
     * Underlined text
     */
    @XmlEnumValue("underline")
    UNDERLINE,
    /**
     * Overlined text
     */
    @XmlEnumValue("overline")
    OVERLINE,
    /**
     * Strikethrough text
     */
    @XmlEnumValue("line-through")
    LINE_THROUGH;

    @Override
    public boolean isDefault() {
        return equals(NONE);
    }
}
