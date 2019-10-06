package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode
public class Page implements Identifiable {

    @XmlAttribute(required = true)
    @Getter @Setter
    private String id;

    @XmlElement
    @Getter @Setter
    private Label name;

    @XmlElement
    @Getter
    private List<Page> pages = new ArrayList<>();

    @XmlElement
    @Getter
    private List<Place> places = new ArrayList<>();

    @XmlElement
    @Getter
    private List<Transition> transitions = new ArrayList<>();

    @XmlElement
    @Getter
    private List<Arc> arcs = new ArrayList<>();

    @XmlElement
    @Getter
    private List<ToolSpecific> toolSpecific = new ArrayList<>();

    public static Page create() {
        return create((String) null);
    }

    public static Page create(String id) {
        return create(id, null);
    }

    public static Page create(Label name) {
        return create(null, name);
    }

    public static Page create(String id, Label name) {
        id = StringUtil.isEmptyOrWhitespace(id) ? UUID.randomUUID().toString() : id;
        Page page = new Page();
        page.setId(id);
        page.setName(name);
        return page;
    }

    public Page withPages(Page... pages) {
        this.pages.addAll(Arrays.asList(pages));
        return this;
    }

    public Page withPlaces(Place... places) {
        this.places.addAll(Arrays.asList(places));
        return this;
    }

    public Page withTransitions(Transition... transitions) {
        this.transitions.addAll(Arrays.asList(transitions));
        return this;
    }
    
    public Page withArcs(Arc... arcs) {
        this.arcs.addAll(Arrays.asList(arcs));
        return this;
    }
}
