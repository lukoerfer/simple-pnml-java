package de.lukaskoerfer.simplepnml;

import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;

/**
 * Describes a textual annotation
 */
@EqualsAndHashCode
@XmlType(propOrder = { "text", "graphicsXml" })
public class Label implements Collectable, Defaultable, Annotation {

    @Getter @Setter
    @NonNull
    @XmlElement(name = "text", required = true)
    private String text = "";

    @Getter @Setter
    @NonNull
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
            .include(graphics)
            .collect();
    }

    @Override
    public boolean isDefault() {
        return text.isEmpty()
            && graphics.isDefault();
    }

    @XmlElement(name = "graphics")
    private AnnotationGraphics getGraphicsXml() {
        return requireNonDefaultElseNull(graphics);
    }

    private void setGraphicsXml(AnnotationGraphics graphics) {
        this.graphics = graphics;
    }
}
