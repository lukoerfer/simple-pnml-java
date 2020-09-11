package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.UUID;

/**
 * Encapsulates petri net elements that can be identified
 */
public interface Identifiable {

    /**
     * Gets the element identifier
     * @return
     */
    String getId();

    void setId(String id);

    static String randomId() {
        return UUID.randomUUID().toString();
    }

}
