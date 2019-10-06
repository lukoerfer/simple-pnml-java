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
@NoArgsConstructor
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

    @XmlElement
    @Getter @Setter
    private Label inscription;

    public static Arc create() {
        return create(null);
    }

    public static Arc create(String id) {
        return create(id, null, null, null);
    }

    public static Arc create(Connectable source, Connectable target, Label inscription) {
        return create(null, source, target, inscription);
    }

    public static Arc create(String id, Connectable source, Connectable target, Label inscription) {
        id = StringUtil.isEmptyOrWhitespace(id) ? UUID.randomUUID().toString() : id;
        Arc arc = new Arc();
        arc.setId(id);
        arc.setSource(source);
        arc.setTarget(target);
        arc.setInscription(inscription);
        return arc;
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
        if (source != null) {
            this.source = source.getId();
        }
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
        if (target != null) {
            this.target = target.getId();
        }
    }

    /**
     *
     * @param source
     * @param target
     */
    public void connect(Connectable source, Connectable target) {
        setSource(source);
        setTarget(target);
    }

}
