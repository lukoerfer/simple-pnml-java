package de.lukaskoerfer.simplepnml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
