package de.lukaskoerfer.simplepnml;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
@Builder
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

}
