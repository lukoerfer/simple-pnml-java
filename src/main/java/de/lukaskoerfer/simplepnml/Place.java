package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
public class Place extends Connectable {

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
    private List<ToolData> toolData = new ArrayList<>();

    public Place() {
        this(null);
    }

    public Place(String id) {
        setId(id);
    }

}
