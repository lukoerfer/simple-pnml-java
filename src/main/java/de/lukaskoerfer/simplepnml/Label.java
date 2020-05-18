package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.stream.Stream;

/**
 * Describes a text at a specific position
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Label implements Collectable, Defaults, Annotation {

    /**
     * -- GETTER --
     * Gets the text of this label
     * @return The text
     * -- SETTER --
     * Sets the text of this label
     * @param text The text
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlElement(name = "text", required = true)
    private String text = "";

    /**
     * -- GETTER --
     * Gets the graphics of this label
     * @return The graphics description
     * -- SETTER --
     * Sets the graphics of this label
     * @param graphics The graphics description
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlElement(name = "graphics")
    private AnnotationGraphics graphics = new AnnotationGraphics();

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
        return new Collector(this)
            .include(graphics)
            .collect();
    }

    @Override
    public boolean isDefault() {
        return getText().isEmpty()
            && getGraphics().isDefault();
    }

}
