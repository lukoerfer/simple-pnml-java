package de.lukaskoerfer.simplepnml;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Represents an arc in a place/transition net
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Arc implements Identifiable, Collectable, Edge {

    /**
     * -- GETTER --
     * Gets the identifier
     * @return The identifier
     */
    @Getter
    @XmlAttribute(name = "id", required = true)
    private String id;

    /**
     * -- GETTER --
     * Gets the identifier of the source of this arc
     * @return A string containing the identifier
     * -- SETTER --
     * Sets the source of this arc
     * @param source A string containing the identifier of the source of this arc
     */
    @Getter @Setter
    @XmlAttribute(name = "source")
    private String source;

    /**
     * -- GETTER --
     * Gets the identifier of the target of this arc
     * @return A string containing the identifier
     * -- SETTER --
     * Sets the target of this arc
     * @param target A string containing the identifier of the target of this arc
     */
    @Getter @Setter
    @XmlAttribute(name = "target")
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
    @XmlElement(name = "graphics")
    private EdgeGraphics graphics;

    /**
     * -- GETTER --
     * Gets the inscription of this arc
     * @return A label containing the inscription
     * -- SETTER --
     * Sets the inscription of this arc
     * @param inscription A label containing the inscription
     */
    @Getter @Setter
    @XmlElement(name = "inscription")
    private Label inscription;

    /**
     * -- GETTER --
     * Gets a list containing tool-specific data
     * @return A list of tool-specific data
     */
    @Getter @Setter
    @XmlElement
    private List<ToolData> toolData;

    /**
     * Creates a new arc using a random identifier
     */
    public Arc() {
        this(null);
    }

    public Arc(String id) {
        setId(id);
    }

    /**
     * Sets the identifier, defaults to a random UUID if null, empty or whitespace
     * @param id An unique identifier, defaults to a random UUID if null, empty or whitespace
     */
    public void setId(String id) {
        this.id = id != null ? id : UUID.randomUUID().toString();
    }


    /**
     * Sets the source of this arc
     * @param source The source element of this arc
     */
    @Tolerate
    public void setSource(Connectable source) {
        String sourceId = (source != null) ? source.getId() : null;
        setSource(sourceId);
    }

    /**
     * Sets the target of this arc
     * @param target The target element of this arc
     */
    @Tolerate
    public void setTarget(Connectable target) {
        String targetId = (target != null) ? target.getId() : null;
        setTarget(targetId);
    }

    @Override
    public Stream<Collectable> collect() {
        return Collector.create(this)
            .collect(getGraphics())
            .collect(getInscription())
            .collect(getToolData())
            .build();
    }
}
