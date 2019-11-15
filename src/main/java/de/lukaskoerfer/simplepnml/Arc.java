package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Describes a PNML arc
 */
@EqualsAndHashCode(callSuper = true)
public class Arc extends Identifiable {

    @XmlAttribute
    @Getter
    private String source;

    @XmlAttribute
    @Getter
    private String target;

    @XmlElement
    @Getter @Setter
    private Edge graphics;

    @XmlElement
    @Getter @Setter
    private Label inscription;

    public Arc() {
        this(null);
    }

    public Arc(String id) {
        this(id, null, null);
    }

    public Arc(String id, Connectable source, Connectable target) {
        this(id, source, target, null, null);
    }

    public Arc(String id, Connectable source, Connectable target, Label inscription, Edge graphic) {
        setId(id);
        setSource(source);
        setTarget(target);
        setInscription(inscription);
        setGraphics(graphic);
    }

    /**
     *
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     *
     * @param source
     */
    public void setSource(Connectable source) {
        String sourceId = (source != null) ? source.getId() : null;
        setSource(sourceId);
    }

    /**
     *
     * @param target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     *
     * @param target
     */
    public void setTarget(Connectable target) {
        String targetId = (target != null) ? target.getId() : null;
        setTarget(targetId);
    }

    /**
     * Sets both the source and the target
     * @param source
     * @param target
     */
    public void connect(Connectable source, Connectable target) {
        setSource(source);
        setTarget(target);
    }

    public Arc withSource(String source) {
        setSource(source);
        return this;
    }

    public Arc withSource(Connectable source) {
        setSource(source);
        return this;
    }

    public Arc withTarget(String target) {
        setTarget(target);
        return this;
    }

    public Arc withTarget(Connectable target) {
        setTarget(target);
        return this;
    }

    public Arc connecting(String source, String target) {
        setSource(source);
        setTarget(target);
        return this;
    }

    public Arc connecting(Connectable source, Connectable target) {
        setSource(source);
        setTarget(target);
        return this;
    }
}
