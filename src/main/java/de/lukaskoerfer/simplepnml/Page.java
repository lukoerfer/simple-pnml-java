package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Root
@NoArgsConstructor
@EqualsAndHashCode
public class Page implements Identifiable {

    @Attribute
    @Getter @Setter
    private String id;

    @Element(required = false)
    @Getter @Setter
    private Label name;

    @ElementList(required = false, inline = true)
    @Getter
    private List<Page> pages = new ArrayList<>();

    @ElementList(required = false, inline = true)
    @Getter
    private List<Place> places = new ArrayList<>();

    @ElementList(required = false, inline = true)
    @Getter
    private List<Transition> transitions = new ArrayList<>();

    @ElementList(required = false, inline = true)
    @Getter
    private List<Arc> arcs = new ArrayList<>();

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
