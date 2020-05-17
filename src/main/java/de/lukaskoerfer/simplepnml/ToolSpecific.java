package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import lombok.*;

/**
 * Describes tool-specific data
 */
@Builder
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class ToolSpecific implements Collectable {

    /**
     * -- GETTER --
     * Gets the name of the tool
     * @return The name
     * -- SETTER --
     * Sets the name of the tool
     * @param tool The name
     */
    @NonNull
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
    @NonNull
    @Getter @Setter
    @XmlAttribute(name = "version")
    private String version;

    /**
     * -- GETTER --
     * Gets a list of
     * @return
     */
    @NonNull
    @Getter @Setter
    @Singular
    @XmlAnyElement(lax = true)
    private List<Object> contents;

    /**
     * Creates new tool-specific data
     */
    public ToolSpecific(String tool, String version) {
        this.tool = tool;
        this.version = version;
        this.contents = new ArrayList<>();
    }

    // Internal constructor for builder
    @SuppressWarnings("unused")
    private ToolSpecific(String tool, String version, List<Object> contents) {
        this.tool = Objects.requireNonNull(tool);
        this.version = Objects.requireNonNull(version);
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
}
