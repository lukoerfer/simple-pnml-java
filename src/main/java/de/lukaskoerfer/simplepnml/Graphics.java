package de.lukaskoerfer.simplepnml;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simpleframework.xml.Element;

@NoArgsConstructor
public class Graphics {

    @Element(required = false)
    @Getter @Setter
    private Coordinates position;

    @Element(required = false)
    @Getter @Setter
    private Coordinates offset;

    public Graphics absolute(int x, int y) {
        Graphics graphics = new Graphics();
        graphics.setPosition(new Coordinates(x, y));
        return graphics;
    }

    public Graphics relative(int x, int y) {
        Graphics graphics = new Graphics();
        graphics.setOffset(new Coordinates(x, y));
        return graphics;
    }

}
