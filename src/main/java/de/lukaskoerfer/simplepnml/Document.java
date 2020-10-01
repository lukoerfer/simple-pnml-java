package de.lukaskoerfer.simplepnml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;

/**
 * Provides a container for petri nets
 */
@EqualsAndHashCode
@XmlRootElement(name = "pnml")
public class Document implements Collectable {

    public static final String PNML_NAMESPACE = "http://www.pnml.org/version-2009/grammar/pnml";

    @Getter
    @XmlElement(name = "net")
    private List<Net> nets = new ArrayList<>();

    /**
     * Creates a new document for petri nets
     */
    public Document() { }

    @lombok.Builder
    private Document(@Singular List<Net> nets) {
        this.nets = new ArrayList<>(nets);
    }

    /**
     * Sets the petri nets in this document
     * @param nets A list of petri nets
     */
    public void setNets(@NonNull List<Net> nets) {
        this.nets = new ArrayList<>(nets);
    }

    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(nets)
            .collect();
    }

}
