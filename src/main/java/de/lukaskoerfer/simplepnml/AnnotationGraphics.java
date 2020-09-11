package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Describes the graphical representation of an annotation element
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class AnnotationGraphics implements Collectable, Defaultable, Filled, Lined {

    @Getter @Setter
    @NonNull
    @XmlElement(name = "offset", required = true)
    private Offset offset = new Offset();

    @Getter @Setter
    @NonNull
    private Fill fill = new Fill();

    @Getter @Setter
    @NonNull
    private Line line = new Line();

    @Getter @Setter
    @NonNull
    private Font font = new Font();

    /**
     * Creates a new graphical description for an annotation element
     */
    public AnnotationGraphics() { }

    @lombok.Builder
    private AnnotationGraphics(Offset offset, Fill fill, Line line, Font font) {
        this.offset = offset;
        this.fill = fill;
        this.line = line;
        this.font = font;
    }

    /**
     * Collects the child elements
     * @return
     */
    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(getOffset())
            .include(getFill())
            .include(getLine())
            .include(getFont())
            .collect();
    }

    @Override
    public boolean isDefault() {
        return getOffset().isDefault()
            && getFill().isDefault()
            && getLine().isDefault()
            && getFont().isDefault();
    }

    @XmlElement(name = "fill")
    private Fill getFillXml() {
        return requireNonDefaultElseNull(getFill());
    }

    private void setFillXml(Fill fill) {
        setFill(fill);
    }

    @XmlElement(name = "line")
    private Line getLineXml() {
        return requireNonDefaultElseNull(getLine());
    }

    private void setLineXml(Line line) {
        this.line = line;
    }

    @XmlElement(name = "font")
    private Font getFontXml() {
        return requireNonDefaultElseNull(font);
    }

    private void setFontXml(Font font) {
        this.font = font;
    }

}
