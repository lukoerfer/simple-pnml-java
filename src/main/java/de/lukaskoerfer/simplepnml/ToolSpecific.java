package de.lukaskoerfer.simplepnml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Getter;
import lombok.Setter;

import static java.util.Objects.requireNonNullElseGet;

/**
 * Describes tool-specific data
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class ToolSpecific implements Collectable {

    @Getter @Setter
    @XmlAttribute(name = "tool", required = true)
    private String tool = "";

    @Getter @Setter
    @XmlAttribute(name = "version", required = true)
    private String version = "";

    @Getter @Setter
    @XmlAnyElement(lax = true)
    private List<Object> contents = new ArrayList<>();

    /**
     * Creates a new tool-specific element
     */
    public ToolSpecific(String tool, String version) {
        this.tool = tool;
        this.version = version;
    }

    @lombok.Builder
    private ToolSpecific(String tool, String version,
                         @lombok.Singular List<Object> contents) {
        this.tool = tool;
        this.version = version;
        this.contents = new ArrayList<>(contents);
    }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }

    /**
     * Sets the contents of this element
     * @param contents
     */
    public void setContents(List<Object> contents) {
        this.contents = new ArrayList<>(contents);
    }

}
