package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
public class Net extends Identifiable {

    /**
     *
     */
    public static final String PLACE_TRANSITION_NET_TYPE = "";

    @XmlAttribute(required = true)
    @Getter @Setter
    private String id;

    @XmlAttribute(required = true)
    @Getter @Setter
    private String type;

    @XmlElement
    @Getter @Setter
    private Label name;

    @XmlElement
    @Getter
    private List<Page> pages = new ArrayList<>();

    @XmlElement
    @Getter
    private List<ToolSpecific> toolSpecific = new ArrayList<>();

    public Net() {
        this(null, null, null);
    }

    public Net(String id) {
        this(id, null, null);
    }

    public Net(String id, String type) {
        this(id, type, null);
    }

    public Net(String id, String type, Label name) {
        setId(StringUtil.isEmptyOrWhitespace(id) ? UUID.randomUUID().toString() : id);
        setType(StringUtil.isEmptyOrWhitespace(type) ? PLACE_TRANSITION_NET_TYPE : type);
        setName(name);
    }

    public Net withName(Label name) {
        setName(name);
        return this;
    }

    public Net withName(String name) {
        setName(new Label(name));
        return this;
    }

    public Net withPages(Page... pages) {
        this.pages.addAll(Arrays.asList(pages));
        return this;
    }

    public Net withToolSpecific(ToolSpecific... toolSpecifics) {
        this.toolSpecific.addAll(Arrays.asList(toolSpecifics));
        return this;
    }

}
