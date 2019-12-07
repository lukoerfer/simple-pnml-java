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
     * Creates new tool-specific data
     * @param tool
     */
    public ToolData(String tool) {
        setTool(tool);
    }

    /**
     * Creates new tool-specific data
     * @param tool The tool name
     * @param version The tool version
     * @param content
     */
    public ToolData(String tool, String version, Element... content) {
        setTool(tool);
        setVersion(version);
        this.content = Arrays.asList(content);
    }

    /**
     * Sets the tool name of this tool-specific data
     * @param tool The tool name
     * @return A reference to this tool-specific data
     */
    public ToolData forTool(String tool) {
        setTool(tool);
        return this;
    }

    /**
     * Sets the tool name and version of this tool-specific data
     * @param tool The tool name
     * @param version The tool version
     * @return A reference to this tool-specific data
     */
    public ToolData forTool(String tool, String version) {
        setTool(tool);
        setVersion(version);
        return this;
    }

    /**
     * Adds content to this tool-specific data
     * @param content
     * @return A reference to this tool-specific data
     */
    public ToolData withContent(Element... content) {
        getContent().addAll(Arrays.asList(content));
        return this;
    }

    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }
}
