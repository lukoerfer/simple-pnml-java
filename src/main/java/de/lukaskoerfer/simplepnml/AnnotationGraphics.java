package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.stream.Stream;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;

/**
 * Describes the graphical representation of an annotation element
 */
@EqualsAndHashCode
@XmlType(propOrder = { "offset", "fillXml", "lineXml", "fontXml" })
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

    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(offset)
            .include(fill)
            .include(line)
            .include(font)
            .collect();
    }

    @Override
    public boolean isDefault() {
        return offset.isDefault()
            && fill.isDefault()
            && line.isDefault()
            && font.isDefault();
    }

    @XmlElement(name = "fill")
    private Fill getFillXml() {
        return requireNonDefaultElseNull(fill);
    }

    private void setFillXml(Fill fill) {
        this.fill = fill;
    }

    @XmlElement(name = "line")
    private Line getLineXml() {
        return requireNonDefaultElseNull(line);
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
