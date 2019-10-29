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
    private Node graphics;

    public Label(String text) {
        setText(text);
    }

    public Label withGraphic(Node graphic) {
        setGraphics(graphic);
        return this;
    }



}
