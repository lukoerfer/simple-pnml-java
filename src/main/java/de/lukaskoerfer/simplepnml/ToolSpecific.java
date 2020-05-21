package de.lukaskoerfer.simplepnml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Singular;

import static java.util.Objects.requireNonNullElseGet;

/**
 * Describes tool-specific data
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class ToolSpecific implements Collectable {

    private String tool = "";
    private String version = "";
    private List<Object> contents;

    /**
     * Creates new tool-specific data
     */
    public ToolSpecific(String tool, String version) {
        this.tool = tool;
        this.version = version;
    }

    @Builder
    private ToolSpecific(String tool, String version,
                         @Singular List<Object> contents) {
        this.tool = tool;
        this.version = version;
        this.contents = new ArrayList<>(contents);
    }

    /**
     * Collects the child elements of this tool data element recursively
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }

    @XmlAttribute(name = "tool", required = true)
    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    @XmlAttribute(name = "version", required = true)
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlAnyElement
    public List<Object> getContents() {
        return requireNonNullElseGet(contents, () -> contents = new ArrayList<>());
    }

    public void setContents(List<Object> contents) {
        this.contents = new ArrayList<>(contents);
    }

}
