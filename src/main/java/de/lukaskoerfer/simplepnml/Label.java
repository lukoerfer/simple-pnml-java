package de.lukaskoerfer.simplepnml;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simpleframework.xml.Element;

/**
 *
 */
@NoArgsConstructor
public class Label {

    @Element
    @Getter @Setter
    private String text;

    @Element(required = false)
    @Getter @Setter
    private Graphics graphics;

    public static Label simple(String text) {
        Label label = new Label();
        label.setText(text);
        return label;
    }

    public static Label absolute(int x, int y, String text) {
        Label label = new Label();
        label.setGraphics(Graphics.absolute(x, y));
        label.setText(text);
        return label;
    }

    public static Label relative(int x, int y, String text) {
        Label label = new Label();
        label.setGraphics(Graphics.relative(x, y));
        label.setText(text);
        return label;
    }

}
