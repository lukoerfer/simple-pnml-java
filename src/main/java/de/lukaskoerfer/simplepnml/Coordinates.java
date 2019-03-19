package de.lukaskoerfer.simplepnml;

import lombok.*;
import org.simpleframework.xml.Attribute;

@NoArgsConstructor
@AllArgsConstructor
public class Coordinates {

    @Attribute
    @Getter @Setter
    private int x;

    @Attribute
    @Getter @Setter
    private int y;

}
