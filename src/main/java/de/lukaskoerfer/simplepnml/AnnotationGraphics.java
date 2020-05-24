package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.stream.Stream;

import static de.lukaskoerfer.simplepnml.Defaults.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Describes the graphical representation of an annotation element
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class AnnotationGraphics implements Collectable, Defaults, Filled, Lined {

    private Offset offset;
    private Fill fill;
    private Line line;
    private Font font;

    /**
     * Creates a new graphical description for an annotation element
     */
    public AnnotationGraphics() { }

    @Builder
    private AnnotationGraphics(Offset offset, Fill fill, Line line, Font font) {
        this.offset = offset;
        this.fill = fill;
        this.line = line;
        this.font = font;
    }

    /**
     * Collects the child elements of this annotation recursively
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

    /**
     * Gets the offset of the described annotation
     * @return A set of relative coordinates
     */
    @XmlElement(name = "offset", required = true)
    public Offset getOffset() {
        return requireNonNullElseGet(offset, () -> offset = new Offset());
    }

    /**
     * Sets the offset of the described annotation
     * @param offset A set of relative coordinates
     */
    public void setOffset(Offset offset) {
        this.offset = offset;
    }


    public Fill getFill() {
        return requireNonNullElseGet(fill, () -> fill = new Fill());
    }

    public void setFill(Fill fill) {
        this.fill = fill;
    }

    public Line getLine() {
        return requireNonNullElseGet(line, () -> line = new Line());
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Font getFont() {
        return requireNonNullElseGet(font, () -> font = new Font());
    }

    public void setFont(Font font) {
        this.font = font;
    }

    @XmlElement(name = "fill")
    @SuppressWarnings("unused")
    private Fill getFillXml() {
        return requireNonDefaultElseNull(getFill());
    }

    @SuppressWarnings("unused")
    private void setFillXml(Fill fill) {
        setFill(fill);
    }

    @XmlElement(name = "line")
    @SuppressWarnings("unused")
    private Line getLineXml() {
        return requireNonDefaultElseNull(getLine());
    }

    @SuppressWarnings("unused")
    private void setLineXml(Line line) {
        this.line = line;
    }

    @XmlElement(name = "font")
    @SuppressWarnings("unused")
    private Font getFontXml() {
        return requireNonDefaultElseNull(font);
    }

    @SuppressWarnings("unused")
    private void setFontXml(Font font) {
        this.font = font;
    }

}
