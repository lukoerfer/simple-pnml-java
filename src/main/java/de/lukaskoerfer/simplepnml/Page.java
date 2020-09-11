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
 * Represents a page of a petri net
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Page implements Identifiable, Collectable, Named, ToolExtendable {

    @Setter
    @NonNull
    private String id;

    @Getter @Setter
    @NonNull
    @XmlElement(name = "name")
    private Label name = new Label();

    @Getter
    @XmlElement(name = "page")
    private List<Page> pages = new ArrayList<>();

    @Getter
    @XmlElement(name = "place")
    private List<Place> places = new ArrayList<>();

    @Getter
    @XmlElement(name = "transition")
    private List<Transition> transitions  = new ArrayList<>();

    @Getter
    @XmlElement(name = "arc")
    private List<Arc> arcs = new ArrayList<>();

    @Getter
    @XmlElement(name = "toolspecific")
    private List<ToolSpecific> toolSpecifics = new ArrayList<>();

    /**
     * Creates a new page
     */
    public Page() { }

    /**
     * Creates a new page
     * @param id A unique page identifier
     */
    public Page(String id) {
        this.id = id;
    }

    @lombok.Builder
    private Page(String id, Label name,
                 @lombok.Singular List<Page> pages,
                 @lombok.Singular List<Place> places,
                 @lombok.Singular List<Transition> transitions,
                 @lombok.Singular List<Arc> arcs,
                 @lombok.Singular List<ToolSpecific> toolSpecifics) {
        this.id = id;
        this.name = name;
        this.pages = new ArrayList<>(pages);
        this.places = new ArrayList<>(places);
        this.transitions = new ArrayList<>(transitions);
        this.arcs = new ArrayList<>(arcs);
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
            .include(getPlaces())
            .include(getTransitions())
            .include(getArcs())
            .include(getToolSpecifics())
            .collect();
    }

    /**
     * Gets the identifier of this page
     * @return
     */
    @XmlAttribute(name = "id", required = true)
    public String getId() {
        return requireNonNullElseGet(id, () -> id = Identifiable.randomId());
    }

    /**
     * Sets the sub-pages of this page
     * @param pages
     */
    public void setPages(@NonNull List<Page> pages) {
        this.pages = new ArrayList<>(pages);
    }

    /**
     * Sets the places on this page
     * @param places
     */
    public void setPlaces(@NonNull List<Place> places) {
        this.places = new ArrayList<>(places);
    }

    /**
     * Sets the transitions on this page
     * @param transitions
     */
    public void setTransitions(@NonNull List<Transition> transitions) {
        this.transitions = new ArrayList<>(transitions);
    }

    /**
     * Sets the arcs on this page
     * @param arcs
     */
    public void setArcs(@NonNull List<Arc> arcs) {
        this.arcs = new ArrayList<>(arcs);
    }

    /**
     * Sets the tool-specific elements related to this page
     * @param toolSpecificData
     */
    public void setToolSpecifics(@NonNull List<ToolSpecific> toolSpecificData) {
        this.toolSpecifics = new ArrayList<>(toolSpecificData);
    }

    @XmlElement(name = "name")
    private Label getNameXml() {
        return requireNonDefaultElseNull(getName());
    }

    private void setNameXml(Label name) {
        setName(name);
    }

}
