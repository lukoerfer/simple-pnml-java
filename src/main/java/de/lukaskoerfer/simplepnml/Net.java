package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents a place/transition net
 */
@EqualsAndHashCode(callSuper = true)
public class Net extends Identifiable implements Named, Collectable {

    /**
     * Defines the identifier for Place-Transition (PT) nets
     */
    public static final String PLACE_TRANSITION_NET_TYPE = "http://www.pnml.org/version-2009/grammar/ptnet";

    /**
     * -- GETTER --
     * Gets the net type
     * @return
     */
    @XmlAttribute(required = true)
    @Getter
    private String type;

    /**
     * -- GETTER --
     * Gets the label containing the name
     * @return A label containing the name
     * -- SETTER --
     * Sets the label containing the name
     * @param name A label containing the name
     */
    @XmlElement
    @Getter @Setter
    private Label name;

    /**
     * -- GETTER --
     * Gets the pages of the net
     * @return A list of pages
     */
    @XmlElement
    @Getter
    private List<Page> pages = new ArrayList<>();

    /**
     * -- GETTER --
     * Gets tool-specific data related to the net
     * @return A list of tool data definitions
     */
    @XmlElement
    @Getter
    private List<ToolData> toolData = new ArrayList<>();

    /**
     * Creates a new net using a random identifier
     */
    public Net() {
        this(null);
    }

    /**
     * Creates a new net
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     */
    public Net(String id) {
        this(id, null, null);
    }

    /**
     * Creates a new net
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     * @param type
     */
    public Net(String id, String type) {
        this(id, type, null);
    }

    /**
     * Creates a new net
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     * @param type
     * @param name
     */
    public Net(String id, String type, Label name) {
        setId(id);
        setType(type);
        setName(name);
    }

    /**
     * Sets the type of this net, defaults to a Place-Transition (PT) net if null, empty or whitespace
     * @param type A string containing a net type identifier
     */
    public void setType(String type) {
        this.type = StringUtil.isEmptyOrWhitespace(type) ? PLACE_TRANSITION_NET_TYPE : type;
    }

    /**
     * Sets the name of the net
     * @param name A label containing the name
     * @return A reference to itself
     */
    public Net withName(Label name) {
        setName(name);
        return this;
    }

    /**
     * Sets the name of the net
     * @param name A string containing the name
     * @return A reference to itself
     */
    public Net withName(String name) {
        setName(new Label(name));
        return this;
    }

    /**
     * Adds pages to the net
     * @param pages A list of pages
     * @return A reference to itself
     */
    public Net withPages(Page... pages) {
        getPages().addAll(Arrays.asList(pages));
        return this;
    }

    /**
     * Adds tool data definitions to the net
     * @param toolData
     * @return A reference to itself
     */
    public Net withToolData(ToolData... toolData) {
        getToolData().addAll(Arrays.asList(toolData));
        return this;
    }

    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(name)
            .collect(pages)
            .collect(toolData)
            .build();
    }
}
