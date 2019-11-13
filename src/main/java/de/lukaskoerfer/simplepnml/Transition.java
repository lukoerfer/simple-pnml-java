package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
public class Transition extends Connectable {

    @XmlElement
    @Getter @Setter
    private Label name;

    @XmlElement
    @Getter @Setter
    private Node graphics;

    @XmlElement
    @Getter
    private List<ToolSpecific> toolSpecific = new ArrayList<>();

    public Transition() {
        this(null);
    }

    public Transition(String id) {
        setId(id);
    }

    public Transition withName(String name) {
        setName(new Label(name));
        return this;
    }

    public Transition withName(Label name) {
        setName(name);
        return this;
    }

    public Transition withGraphics(Node graphics) {
        setGraphics(graphics);
        return this;
    }

    public Transition withGraphics(double x, double y, double width, double height) {
        setGraphics(new Node(x, y, width, height));
        return this;
    }

}
