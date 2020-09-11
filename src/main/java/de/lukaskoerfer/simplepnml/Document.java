package de.lukaskoerfer.simplepnml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.NonNull;

/**
 * Provides a container for petri nets
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "pnml", namespace = "http://www.pnml.org/version-2009/grammar/pnml")
public class Document implements Collectable {

    @Getter
    @XmlElement(name = "net")
    private List<Net> nets = new ArrayList<>();

    /**
     * Creates a new document for petri nets
     */
    public Document() { }

    @lombok.Builder
    private Document(@lombok.Singular List<Net> nets) {
        this.nets = new ArrayList<>(nets);
    }

    /**
     * Sets the petri nets in this document
     * @param nets
     */
    public void setNets(@NonNull List<Net> nets) {
        this.nets = new ArrayList<>(nets);
    }

    /**
     * Recursively collects all elements in this document
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(getNets())
            .collect();
    }

}
