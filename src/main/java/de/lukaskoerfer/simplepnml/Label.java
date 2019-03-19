package de.lukaskoerfer.simplepnml;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simpleframework.xml.Element;

@NoArgsConstructor
public class Label {

    @Element
    @Getter @Setter
    private String text;

    @Element(required = false)
    @Getter @Setter
    private Graphics graphics;

}
