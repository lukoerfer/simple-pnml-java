package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EdgeGraphics {

    @XmlElement
    @Getter
    private List<Coordinates> positions = new ArrayList<>();

    @XmlElement
    @Getter @Setter
    private Line line;

}
