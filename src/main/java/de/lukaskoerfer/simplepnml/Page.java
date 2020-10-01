package de.lukaskoerfer.simplepnml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Represents a page of a petri net
 */
@EqualsAndHashCode
@XmlType(propOrder = { "nameXml", "pages", "places", "transitions", "arcs", "toolSpecifics" })
public class Page implements Identifiable, Collectable, Named, ToolExtendable {

    @Setter
    @NonNull
    private String id;

    @Getter @Setter
    @NonNull
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
                 @Singular List<Page> pages,
                 @Singular List<Place> places,
                 @Singular List<Transition> transitions,
                 @Singular List<Arc> arcs,
                 @Singular List<ToolSpecific> toolSpecifics) {
        this.id = id;
        this.name = name;
        this.pages = new ArrayList<>(pages);
        this.places = new ArrayList<>(places);
        this.transitions = new ArrayList<>(transitions);
        this.arcs = new ArrayList<>(arcs);
        this.toolSpecifics = new ArrayList<>(toolSpecifics);
    }

    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(name)
            .include(pages)
            .include(places)
            .include(transitions)
            .include(arcs)
            .include(toolSpecifics)
            .collect();
    }

    @XmlAttribute(name = "id", required = true)
    public String getId() {
        return requireNonNullElseGet(id, () -> id = Identifiable.randomId());
    }

    public void setPages(@NonNull List<Page> pages) {
        this.pages = new ArrayList<>(pages);
    }

    public void setPlaces(@NonNull List<Place> places) {
        this.places = new ArrayList<>(places);
    }

    public void setTransitions(@NonNull List<Transition> transitions) {
        this.transitions = new ArrayList<>(transitions);
    }

    public void setArcs(@NonNull List<Arc> arcs) {
        this.arcs = new ArrayList<>(arcs);
    }

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
