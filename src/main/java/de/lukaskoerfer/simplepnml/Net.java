package de.lukaskoerfer.simplepnml;

import lombok.Builder;
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
@Builder
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
        this(id, null);
    }

    /**
     * Creates a new net
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     * @param type
     */
    public Net(String id, String type) {
        setId(id);
        setType(type);
    }

    /**
     * Sets the type of this net, defaults to a Place-Transition (PT) net if null, empty or whitespace
     * @param type A string containing a net type identifier
     */
    public void setType(String type) {
        this.type = StringUtil.isEmptyOrWhitespace(type) ? PLACE_TRANSITION_NET_TYPE : type;
    }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(getName())
            .collect(getPages())
            .collect(getToolData())
            .build();
    }
}
