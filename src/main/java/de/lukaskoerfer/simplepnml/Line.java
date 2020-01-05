package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Describes a graphical line element
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Line implements Collectable {

    /**
     * -- GETTER --
     * Gets the line color
     * @return
     * -- SETTER --
     * Sets the line color
     * @param color
     */
    @Getter @Setter
    @XmlAttribute(name = "color")
    private String color;

    /**
     * -- GETTER --
     * Gets the line width
     * @return
     * -- SETTER --
     * Sets the line width
     * @param width
     */
    @Getter @Setter
    @XmlAttribute(name = "width")
    private double width;

    /**
     * -- GETTER --
     * Gets the line shape
     * @return
     * -- SETTER --
     * Sets the line shape
     * @param shape
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlAttribute(name = "shape")
    private LineShape shape = LineShape.LINE;

    /**
     * -- GETTER --
     * Gets the line style
     * @return
     * -- SETTER --
     * Sets the line style
     * @param style
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlAttribute(name = "style")
    private LineStyle style = LineStyle.SOLID;

    /**
     * Creates a new line
     */
    public Line() { }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Stream.of(this);
    }
}
