package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Describes a text at a specific position
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Label implements Collectable, AnnotationElement {

    /**
     * -- GETTER --
     * Gets the text of this label
     * @return The text
     * -- SETTER --
     * Sets the text of this label
     * @param text The text
     */
    @Getter @Setter
    @XmlElement
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
    @XmlElement
    private Annotation graphics;

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
