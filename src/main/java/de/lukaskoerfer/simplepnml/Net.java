package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNullElseGet;

/**
 * Represents a place/transition net
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Net implements Identifiable, Named, Collectable, ToolExtendable {

    /**
     * Defines the identifier for Place-Transition (PT) nets
     */
    public static final String PLACE_TRANSITION_TYPE = "http://www.pnml.org/version-2009/grammar/ptnet";

    private String id;
    private String type;
    private Label name;
    private List<Page> pages;
    private List<ToolSpecific> toolSpecifics;

    /**
     * Creates a new net using a random identifier
     */
    public Net() { }

    /**
     * Creates a new net
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     */
    public Net(String id) {
        this.id = id;
    }

    /**
     * Creates a new net
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     * @param type
     */
    public Net(String id, String type) {
        this.id = id;
        this.type = type;
    }

    @Builder
    private Net(String id, String type, Label name,
                @Singular List<Page> pages,
                @Singular List<ToolSpecific> toolSpecifics) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.pages = new ArrayList<>(pages);
        this.toolSpecifics = new ArrayList<>(toolSpecifics);
    }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(getName())
            .include(getPages())
            .include(getToolSpecifics())
            .collect();
    }

    @XmlAttribute(name = "id", required = true)
    public String getId() {
        return requireNonNullElseGet(id, () -> id = Identifiable.randomId());
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute(name = "type", required = true)
    public String getType() {
        return requireNonNullElseGet(type, () -> type = PLACE_TRANSITION_TYPE);
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the label containing the name
     * @return A label containing the name
     */
    @Override
    public Label getName() {
        return requireNonNullElseGet(name, () -> name = new Label());
    }

    public void setName(Label name) {
        this.name = name;
    }

    public List<Page> getPages() {
        return requireNonNullElseGet(pages, () -> pages = new ArrayList<>());
    }

    public void setPages(List<Page> pages) {
        this.pages = new ArrayList<>(pages);
    }

    public List<ToolSpecific> getToolSpecifics() {
        return requireNonNullElseGet(toolSpecifics, () -> toolSpecifics = new ArrayList<>());
    }

    public void setToolSpecifics(List<ToolSpecific> toolSpecifics) {
        this.toolSpecifics = new ArrayList<>(toolSpecifics);
    }

}
