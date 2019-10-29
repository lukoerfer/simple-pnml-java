package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Line {

    @XmlAttribute
    @Getter @Setter
    private String color;

    @XmlAttribute
    @Getter @Setter
    private double width;

    @XmlAttribute
    @Getter @Setter
    private LineShape shape;

    @XmlAttribute
    @Getter @Setter
    private LineStyle style;

    /**
     *
     * @param shape
     * @return
     */
    public Line withShape(LineShape shape) {
        setShape(shape);
        return this;
    }

    /**
     *
     * @param style
     * @return
     */
    public Line withStyle(LineStyle style) {
        setStyle(style);
        return this;
    }

}
