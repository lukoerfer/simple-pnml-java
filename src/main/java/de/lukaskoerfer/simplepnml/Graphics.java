package de.lukaskoerfer.simplepnml;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simpleframework.xml.Element;

@Builder
@NoArgsConstructor
public class Graphics {

    @Element(required = false)
    @Getter @Setter
    private Coordinates position;

    @Element(required = false)
    @Getter @Setter
    private Coordinates offset;

    public Graphics absolute(int x, int y) {
        return Graphics.builder()
            .position(new Coordinates(x, y))
            .build();
    }

    public Graphics relative(int x, int y) {
        return Graphics.builder()
            .offset(new Coordinates(x, y))
            .build();
    }

}
