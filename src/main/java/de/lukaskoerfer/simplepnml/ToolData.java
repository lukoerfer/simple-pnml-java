package de.lukaskoerfer.simplepnml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.Element;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Describes tool-specific data
 */
public class ToolData implements Collectable {

    /**
     * -- GETTER --
     * Gets the name of the tool
     * @return The name
     * -- SETTER --
     * Sets the name of the tool
     * @param tool The name
     */
    @XmlAttribute
    @Getter @Setter
    private String tool;

    /**
     * -- GETTER --
     * Gets the version of the tool
     * @return The version
     * -- SETTER --
     * Sets the version of the tool
     * @param version The version
     */
    @XmlAttribute
    @Getter @Setter
    private String version;

    /**
     * -- GETTER --
     * Gets a list of
     * @return
     */
    @XmlAnyElement
    @Getter
    private List<Element> content = new ArrayList<>();

    /**
     * Creates new tool-specific data
     */
    public ToolData() {}

    /**
     * Collects the child elements of this tool data element recursively
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }
}
