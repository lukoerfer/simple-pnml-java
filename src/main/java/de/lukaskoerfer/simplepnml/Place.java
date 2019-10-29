package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode
public class Place implements Connectable {

    @XmlAttribute(required = true)
    @Getter @Setter
    private String id;

    @XmlElement
    @Getter @Setter
    private Label name;

    @XmlElement
    @Getter @Setter
    private Node graphics;

    @XmlElement
    @Getter @Setter
    private Label initialMarking;

    @XmlElement
    @Getter
    private List<ToolSpecific> toolSpecific = new ArrayList<>();

    public static Place create() {
        return create(null);
    }

    public static Place create(String id) {
        return create(id, null, null, null);
    }

    public static Place create(Label name, Node graphics, Label initialMarking) {
        return create(null, name, graphics, initialMarking);
    }

    public static Place create(String id, Label name, Node graphics, Label initialMarking) {
        id = StringUtil.isEmptyOrWhitespace(id) ? UUID.randomUUID().toString() : id;
        Place place = new Place();
        place.setId(id);
        place.setName(name);
        place.setGraphics(graphics);
        place.setInitialMarking(initialMarking);
        return place;
    }

}
