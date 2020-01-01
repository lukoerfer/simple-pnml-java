package de.lukaskoerfer.simplepnml;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Represents an arc in a place/transition net
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class Arc extends Identifiable implements Collectable, EdgeElement {

    /**
     * -- GETTER --
     * Gets the identifier of the source of this arc
     * @return A string containing the identifier
     */
    @Getter
    @XmlAttribute
    private String source;

    /**
     * -- GETTER --
     * Gets the identifier of the target of this arc
     * @return A string containing the identifier
     */
    @Getter
    @XmlAttribute
    private String target;

    /**
     * -- GETTER --
     * Gets how to visualize this arc
     * @return The graphics of this arc
     * -- SETTER --
     * Sets how to visualize this arc
     * @param graphics The graphics of this arc
     */
    @Getter @Setter
    @XmlElement
    private Edge graphics;

    /**
     * -- GETTER --
     * Gets the inscription of this arc
     * @return A label containing the inscription
     * -- SETTER --
     * Sets the inscription of this arc
     * @param inscription A label containing the inscription
     */

    @Getter @Setter
    @XmlElement
    private Label inscription;

    /**
     * Creates a new arc using a random identifier
     */
    public Arc() {
        this(null);
    }

    /**
     * Creates a new arc
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     */
    public Arc(String id) {
        this(id, null, null);
    }

    /**
     * Creates a new arc
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     * @param source The source element of this arc
     * @param target The target element of this arc
     */
    public Arc(String id, Connectable source, Connectable target) {
        this(id, source, target, null, null);
    }

    /**
     * Creates a new arc
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     * @param source The source element of this arc
     * @param target The target element of this arc
     * @param graphics The graphics of this arc
     * @param inscription A label containing the inscription
     */
    public Arc(String id, Connectable source, Connectable target, Edge graphics, Label inscription) {
        setId(id);
        setSource(source);
        setTarget(target);
        setGraphics(graphics);
        setInscription(inscription);
    }

    /**
     * Sets the source of this arc
     * @param source A string containing the identifier of the source of this arc
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Sets the source of this arc
     * @param source The source element of this arc
     */
    public void setSource(Connectable source) {
        String sourceId = (source != null) ? source.getId() : null;
        setSource(sourceId);
    }

    /**
     * Sets the target of this arc
     * @param target A string containing the identifier of the target of this arc
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * Sets the target of this arc
     * @param target The target element of this arc
     */
    public void setTarget(Connectable target) {
        String targetId = (target != null) ? target.getId() : null;
        setTarget(targetId);
    }

    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(getGraphics())
            .collect(getInscription())
            .build();
    }
}
