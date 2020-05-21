package de.lukaskoerfer.simplepnml;

import java.io.File;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Singular;

import static java.util.Objects.requireNonNullElseGet;

/**
 * Container for place/transition nets (in PNML)
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "pnml", namespace = "http://www.pnml.org/version-2009/grammar/pnml")
public class Document implements Collectable {

    private List<Net> nets;

    /**
     * Creates a new PNML document
     */
    public Document() { }

    @Builder
    private Document(@Singular List<Net> nets) {
        this.nets = new ArrayList<>(nets);
    }

    @XmlElement(name = "net")
    public List<Net> getNets() {
        return requireNonNullElseGet(nets, () -> nets = new ArrayList<>());
    }

    public void setNets(List<Net> nets) {
        this.nets = new ArrayList<>(nets);
    }

    /**
     * Collects the child elements of this document recursively
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(getNets())
            .collect();
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
