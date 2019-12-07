package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.UUID;

/**
 * Encapsulates elements in place/transition nets that can be identified
 */
@EqualsAndHashCode
public abstract class Identifiable {

    /**
     * -- GETTER --
     * Gets the identifier
     * @return The identifier
     */
    @XmlAttribute(required = true)
    @Getter
    private String id;

    /**
     * Sets the identifier, defaults to a random UUID if null, empty or whitespace
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     */
    public void setId(String id) {
        this.id = StringUtil.isEmptyOrWhitespace(id) ? UUID.randomUUID().toString() : id;
    }

}
