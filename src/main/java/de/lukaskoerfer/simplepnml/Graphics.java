package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simpleframework.xml.Element;

/**
 *
 */
@NoArgsConstructor
@EqualsAndHashCode
public class Graphics {

    @Element(required = false)
    @Getter @Setter
    private Coordinates position;

    @Element(required = false)
    @Getter @Setter
    private Coordinates offset;
    
    /**
     *
     * @param x
     * @param y
     * @return
     */
    public static Graphics absolute(int x, int y) {
        Graphics graphics = new Graphics();
        graphics.setPosition(new Coordinates(x, y));
        return graphics;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public static Graphics relative(int x, int y) {
        Graphics graphics = new Graphics();
        graphics.setOffset(new Coordinates(x, y));
        return graphics;
    }

}
