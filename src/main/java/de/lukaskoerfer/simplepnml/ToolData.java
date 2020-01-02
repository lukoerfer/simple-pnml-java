package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

/**
 * Describes tool-specific data
 */
@Builder
@EqualsAndHashCode
public class ToolData implements Collectable {

    /**
     * -- GETTER --
     * Gets the name of the tool
     * @return The name
     * -- SETTER --
     * Sets the name of the tool
     * @param tool The name
     */
    @Getter @Setter
    @XmlAttribute(name = "tool")
    private String tool;

    /**
     * -- GETTER --
     * Gets the version of the tool
     * @return The version
     * -- SETTER --
     * Sets the version of the tool
     * @param version The version
     */
    @Getter @Setter
    @XmlAttribute(name = "version")
    private String version;

    /**
     * -- GETTER --
     * Gets a list of
     * @return
     */
    @Getter @Setter
    @Singular
    @XmlAnyElement(lax = true)
    private List<Object> contents;

    /**
     * Creates new tool-specific data
     */
    public ToolData() {
        setContents(new ArrayList<>());
    }

    // Internal constructor for builder
    private ToolData(String tool, String version, List<Object> contents) {
        setTool(tool);
        setVersion(version);
        setContents(new ArrayList<>(contents));
    }

    /**
     * Collects the child elements of this tool data element recursively
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }
}
