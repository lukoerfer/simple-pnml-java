package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    private List<ToolSpecific> toolSpecific = new ArrayList<>();

    public Place() {

    }

}
