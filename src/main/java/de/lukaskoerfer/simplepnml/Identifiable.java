package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.UUID;

/**
 * Encapsulates elements in place/transition nets that can be identified
 */
public interface Identifiable {

    String getId();

    void setId(String id);

    static String randomId() {
        return UUID.randomUUID().toString();
    }

}
