package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.util.stream.Stream;

/**
 * Describes a text at a specific position
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Label implements Collectable, Annotation {

    /**
     * -- GETTER --
     * Gets the text of this label
     * @return The text
     * -- SETTER --
     * Sets the text of this label
     * @param text The text
     */
    @Getter @Setter
    @XmlElement(name = "text")
    private String text;

    /**
     * -- GETTER --
     * Gets the graphics of this label
     * @return The graphics description
     * -- SETTER --
     * Sets the graphics of this label
     * @param graphics The graphics description
     */
    @Getter @Setter
    @XmlElement(name = "graphics")
    private AnnotationGraphics graphics;

    /**
     * Creates an empty label
     */
    public Label() { }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(getGraphics())
            .build();
    }
}
