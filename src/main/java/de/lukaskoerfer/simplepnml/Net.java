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
public class Net implements Identifiable {

    @Attribute
    @Getter @Setter
    private String id;

    @Attribute
    @Getter @Setter
    private String type;

    @Element(required = false)
    @Getter @Setter
    private Label name;

    @ElementList(required = false, inline = true)
    @Getter
    private List<Page> pages = new ArrayList<>();

    public static Net create() {
        return create((String) null);
    }

    public static Net create(String id) {
        return create(id, null, null);
    }

    public static Net create(Label name) {
        return create(null, null, name);
    }

    public static Net create(String id, String type) {
        return create(id, type, null);
    }

    public static Net create(String id, String type, Label name) {
        id = StringUtil.isEmptyOrWhitespace(id) ? UUID.randomUUID().toString() : id;
        Net net = new Net();
        net.setId(id);
        net.setType(type);
        net.setName(name);
        return net;
    }

    public Net withPages(Page... pages) {
        this.pages.addAll(Arrays.asList(pages));
        return this;
    }

}
