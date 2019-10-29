package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.UUID;

/**
 *
 */
@EqualsAndHashCode
public class Arc implements Identifiable {

    @XmlAttribute
    @Getter @Setter
    private String id;

    @XmlAttribute
    @Getter
    private String source;

    @XmlAttribute
    @Getter
    private String target;

    @XmlElement(name = "graphics")
    @Getter @Setter
    private Edge graphic;

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
        setSource(source);
        setTarget(target);
        setInscription(inscription);
        setGraphic(graphic);
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
}
