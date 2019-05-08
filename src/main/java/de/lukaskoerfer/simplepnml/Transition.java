package de.lukaskoerfer.simplepnml;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.UUID;

@Root
@NoArgsConstructor
public class Transition implements Connectable {

    @Attribute
    @Getter @Setter
    private String id;

    @Element(required = false)
    @Getter @Setter
    private Label name;

    @Element(required = false)
    @Getter @Setter
    private Graphics graphics;

    /**
     *
     * @param id
     * @param name
     * @param graphics
     * @return
     */
    public static Transition create(String id, Label name, Graphics graphics) {
        Transition transition = new Transition();
        transition.setId(id != null ? id : UUID.randomUUID().toString());
        transition.setName(name);
        transition.setGraphics(graphics);
        return transition;
    }

}
