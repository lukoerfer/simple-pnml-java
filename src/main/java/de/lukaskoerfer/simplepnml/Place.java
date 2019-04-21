package de.lukaskoerfer.simplepnml;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.UUID;

@Root
@NoArgsConstructor
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

    public static Place create(String id, Label name, Graphics graphics, Label initialMarking) {
        Place place = new Place();
        place.setId(id != null ? id : UUID.randomUUID().toString());
        place.setName(name);
        place.setGraphics(graphics);
        place.setInitialMarking(initialMarking);
        return place;
    }

}
