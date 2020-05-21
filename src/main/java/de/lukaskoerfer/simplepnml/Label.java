package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNullElseGet;

/**
 * Describes a text at a specific position
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Label implements Collectable, Defaults, Annotation {

    private String text = "";
    private AnnotationGraphics graphics;

    /**
     * Creates an empty label
     */
    public Label() { }

    /**
     *
     * @param text
     */
    public Label(String text) {
        this.text = text;
    }

    @Builder
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

    @XmlElement(name = "text", required = true)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @XmlElement(name = "graphics")
    public AnnotationGraphics getGraphics() {
        return requireNonNullElseGet(graphics, () -> graphics = new AnnotationGraphics());
    }

    public void setGraphics(AnnotationGraphics graphics) {
        this.graphics = graphics;
    }
}
