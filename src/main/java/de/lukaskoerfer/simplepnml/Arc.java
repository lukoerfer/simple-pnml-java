package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.UUID;

/**
 *
 */
@Root
@NoArgsConstructor
@EqualsAndHashCode
public class Arc implements Identifiable {

    @Attribute
    @Getter @Setter
    private String id;

    @Attribute
    @Getter
    private String source;

    @Attribute
    @Getter
    private String target;

    @Element(required = false)
    @Getter @Setter
    private Label inscription;

    public static Arc create() {
        return create(null);
    }

    public static Arc create(String id) {
        return create(id, null, null, null);
    }

    public static Arc create(String id, Connectable source, Connectable target, Label inscription) {
        if (id == null || id.trim().length() < 1) {
            id = UUID.randomUUID().toString();
        }
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
