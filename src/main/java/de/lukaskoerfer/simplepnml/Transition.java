package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.UUID;

@Root
@NoArgsConstructor
@EqualsAndHashCode
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
     * @return
     */
    public static Transition create() {
        return create(null);
    }

    /**
     *
     * @param id
     * @return
     */
    public static Transition create(String id) {
        return create(id, null, null);
    }

    /**
     *
     * @param name
     * @param graphics
     * @return
     */
    public static Transition create(Label name, Graphics graphics) {
        return create(null, name, graphics);
    }

    /**
     *
     * @param id
     * @param name
     * @param graphics
     * @return
     */
    public static Transition create(String id, Label name, Graphics graphics) {
        id = StringUtil.isEmptyOrWhitespace(id) ? UUID.randomUUID().toString() : id;
        Transition transition = new Transition();
        transition.setId(id);
        transition.setName(name);
        transition.setGraphics(graphics);
        return transition;
    }

}
