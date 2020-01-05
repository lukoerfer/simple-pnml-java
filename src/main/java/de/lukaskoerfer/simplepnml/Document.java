package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Container for place/transition nets (in PNML)
 */
@Builder
@EqualsAndHashCode
@XmlRootElement(name = "pnml", namespace = "http://www.pnml.org/version-2009/grammar/pnml")
public class Document implements Collectable {

    /**
     * -- GETTER --
     * Gets the nets in this document
     * @return A list of nets
     */
    @NonNull
    @Getter @Setter
    @Singular
    @XmlElement(name = "net")
    private List<Net> nets;

    /**
     * Creates a new PNML document
     */
    public Document() {
        setNets(new ArrayList<>());
    }

    // Internal constructor for builder
    private Document(List<Net> nets) {
        setNets(new ArrayList<>(nets));
    }

    /**
     * Collects the child elements of this document recursively
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(getNets())
            .build();
    }

    /**
     * Writes this document to a stream
     * @param stream A stream to write to
     * @return A reference to itself
     */
    public Document write(OutputStream stream) {
        return PNML.write(this, stream);
    }

    /**
     * Writes this document to a string
     * @param writer A string to write to
     * @return A reference to itself
     */
    public Document write(StringWriter writer) {
        return PNML.write(this, writer);
    }

    /**
     * Writes this document to a file
     * @param file A file to write to
     * @return A reference to itself
     */
    public Document write(File file) {
        return PNML.write(this, file);
    }

}
