package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Edge {

    @XmlElement
    @Getter
    private List<Coordinates> positions = new ArrayList<>();

    @XmlElement
    @Getter @Setter
    private Line line;

    public Edge(Coordinates... positions) {
        this.positions = Arrays.asList(positions);
    }

}
