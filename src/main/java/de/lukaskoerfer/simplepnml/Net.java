package de.lukaskoerfer.simplepnml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Represents a petri net
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Net implements Identifiable, Named, Collectable, ToolExtendable {

    /**
     * Defines the identifier for Place-Transition (PT) nets
     */
    public static final String PLACE_TRANSITION_TYPE = "http://www.pnml.org/version-2009/grammar/ptnet";

    @Setter
    @NonNull
    private String id;

    @Setter
    @NonNull
    private String type;

    @Getter @Setter
    @NonNull
    private Label name = new Label();

    @Getter
    private List<Page> pages = new ArrayList<>();

    @Getter
    private List<ToolSpecific> toolSpecifics = new ArrayList<>();

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

    @lombok.Builder
    private Net(String id, String type, Label name,
                @lombok.Singular List<Page> pages,
                @lombok.Singular List<ToolSpecific> toolSpecifics) {
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

    /**
     * Gets the identifier of this net
     * @return
     */
    @XmlAttribute(name = "id", required = true)
    public String getId() {
        return requireNonNullElseGet(id, () -> id = Identifiable.randomId());
    }

    /**
     * Gets the type identifier of this net
     * @return
     */
    @XmlAttribute(name = "type", required = true)
    public String getType() {
        return requireNonNullElseGet(type, () -> type = PLACE_TRANSITION_TYPE);
    }

    /**
     * Sets the pages of this net
     * @param pages
     */
    public void setPages(@NonNull List<Page> pages) {
        this.pages = new ArrayList<>(pages);
    }

    /**
     *
     * @param toolSpecificData
     */
    public void setToolSpecifics(@NonNull List<ToolSpecific> toolSpecificData) {
        this.toolSpecifics = new ArrayList<>(toolSpecificData);
    }

    @XmlElement(name = "name")
    private Label getNameXml() {
        return requireNonDefaultElseNull(name);
    }

    private void setNameXml(Label name) {
        this.name = name;
    }

}
