package de.lukaskoerfer.simplepnml;

import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Describes a textual annotation
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Label implements Collectable, Defaultable, Annotation {

    @Getter @Setter
    @NonNull
    @XmlElement(name = "text", required = true)
    private String text = "";

    @Getter @Setter
    @NonNull
    @XmlElement(name = "graphics")
    private AnnotationGraphics graphics = new AnnotationGraphics();

    /**
     * Creates an empty label
     */
    public Label() { }

    /**
     * Creates a new label
     * @param text The label text
     */
    public Label(String text) {
        this.text = text;
    }

    @lombok.Builder
    private Label(String text, AnnotationGraphics graphics) {
        this.text = text;
        this.graphics = graphics;
    }

    /**
     *
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(getGraphics())
            .collect();
    }

    @Override
    public boolean isDefault() {
        return getText().isEmpty()
            && getGraphics().isDefault();
    }
}
