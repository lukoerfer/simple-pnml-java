package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Label {

    @XmlElement
    @Getter @Setter
    private String text;

    @XmlElement
    @Getter @Setter
    private Annotation graphics;

    public Label(int value) {
        setText(Integer.toString(value));
    }

    public Label(double value) {
        setText(Double.toString(value));
    }

    public Label(String text) {
        setText(text);
    }

    public Label withText(String text) {
        setText(text);
        return this;
    }

    public Label withGraphics(Annotation graphics) {
        setGraphics(graphics);
        return this;
    }

    public Label withGraphics(double x, double y, Fill fill, Line line, Font font) {
        setGraphics(new Annotation(x, y, fill, line, font));
        return this;
    }


}
