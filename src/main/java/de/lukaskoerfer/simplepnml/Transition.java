package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode
public class Transition implements Connectable {

    @XmlAttribute(required = true)
    @Getter @Setter
    private String id;

    @XmlElement
    @Getter @Setter
    private Label name;

    @XmlElement
    @Getter @Setter
    private NodeGraphics graphics;

    @XmlElement
    @Getter
    private List<ToolSpecific> toolSpecific = new ArrayList<>();

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
    public static Transition create(Label name, NodeGraphics graphics) {
        return create(null, name, graphics);
    }

    /**
     *
     * @param id
     * @param name
     * @param graphics
     * @return
     */
    public static Transition create(String id, Label name, NodeGraphics graphics) {
        id = StringUtil.isEmptyOrWhitespace(id) ? UUID.randomUUID().toString() : id;
        Transition transition = new Transition();
        transition.setId(id);
        transition.setName(name);
        transition.setGraphics(graphics);
        return transition;
    }

}
