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
@XmlRootElement(name = "pnml", namespace = "http://www.pnml.org/version-2009/grammar/pnml")
@Builder
@EqualsAndHashCode
public class Document implements Collectable {

    /**
     * -- GETTER --
     * Gets the nets in this document
     * @return A list of nets
     */
    @XmlElement(name = "net")
    @Getter @Setter
    private List<Net> nets = new ArrayList<>();

    /**
     * Creates a new PNML document
     */
    public Document() {}

    /**
     * Creates a new PNML document
     * @param net
     * @param nets
     */
    public Document(Net net, Net... nets) {
        getNets().add(net);
        getNets().addAll(Arrays.asList(nets));
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
