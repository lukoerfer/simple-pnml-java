package de.lukaskoerfer.simplepnml;

import lombok.*;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.UUID;

@Root
@NoArgsConstructor
@EqualsAndHashCode
public class Place implements Connectable {

    @Attribute
    @Getter @Setter
    private String id;

    @Element(required = false)
    @Getter @Setter
    private Label name;

    @Element(required = false)
    @Getter @Setter
    private Graphics graphics;

    @Element(required = false)
    @Getter @Setter
    private Label initialMarking;

    public static Place create() {
        return create(null);
    }

    public static Place create(String id) {
        return create(id, null, null, null);
    }

    public static Place create(Label name, Graphics graphics, Label initialMarking) {
        return create(null, name, graphics, initialMarking);
    }

    public static Place create(String id, Label name, Graphics graphics, Label initialMarking) {
        id = StringUtil.isEmptyOrWhitespace(id) ? UUID.randomUUID().toString() : id;
        Place place = new Place();
        place.setId(id);
        place.setName(name);
        place.setGraphics(graphics);
        place.setInitialMarking(initialMarking);
        return place;
    }

}
