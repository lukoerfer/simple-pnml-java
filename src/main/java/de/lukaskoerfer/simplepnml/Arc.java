package de.lukaskoerfer.simplepnml;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Represents an arc in a place/transition net
 */
@Builder
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Arc implements Identifiable, Collectable, Edge, ToolExtendable {

    /**
     * -- GETTER --
     * Gets the identifier
     * @return The identifier
     * --- SETTER --
     * Sets the source of this arc
     * @param source A string containing the identifier of the source of this arc
     */
    @NonNull
    @Getter @Setter
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
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlAttribute(name = "source", required = true)
    private String source = "";

    /**
     * -- GETTER --
     * Gets the identifier of the target of this arc
     * @return A string containing the identifier
     * -- SETTER --
     * Sets the target of this arc
     * @param target A string containing the identifier of the target of this arc
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    @XmlAttribute(name = "target", required = true)
    private String target = "";

    /**
     * -- GETTER --
     * Gets how to visualize this arc
     * @return The graphics of this arc
     * -- SETTER --
     * Sets how to visualize this arc
     * @param graphics The graphics of this arc
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private EdgeGraphics graphics = new EdgeGraphics();

    /**
     * -- GETTER --
     * Gets the inscription of this arc
     * @return A label containing the inscription
     * -- SETTER --
     * Sets the inscription of this arc
     * @param inscription A label containing the inscription
     */
    @NonNull
    @Getter @Setter
    @Builder.Default
    private Label inscription = new Label();

    /**
     * -- GETTER --
     * Gets a list containing tool-specific data
     * @return A list of tool-specific data
     */
    @NonNull
    @Getter @Setter
    @Singular("toolSpecific")
    @XmlElement(name = "toolSpecific")
    private List<ToolSpecific> toolSpecificData;

    /**
     * Creates a new arc using a random identifier
     */
    public Arc() {
        this(null);
    }

    /**
     *
     * @param id
     */
    public Arc(String id) {
        this.id = Objects.requireNonNullElseGet(id, Identifiable::randomId);
        this.toolSpecificData = new ArrayList<>();
    }

    // Internal constructor for builder
    @SuppressWarnings("unused")
    private Arc(String id, String source, String target, EdgeGraphics graphics, Label inscription, List<ToolSpecific> toolSpecificData) {
        this.id = Objects.requireNonNullElseGet(id, Identifiable::randomId);
        this.source = source;
        this.target = target;
        this.graphics = graphics;
        this.inscription = inscription;
        this.toolSpecificData = new ArrayList<>(toolSpecificData);
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
        return new Collector(this)
            .include(graphics)
            .include(inscription)
            .include(toolSpecificData)
            .collect();
    }

    //region Internal serialization

    @XmlElement(name = "graphics")
    @SuppressWarnings("unused")
    private EdgeGraphics getGraphicsXml() {
        return Defaults.requireNonDefault(graphics);
    }

    @SuppressWarnings("unused")
    private void setGraphicsXml(EdgeGraphics graphics) {
        this.graphics = graphics;
    }

    @SuppressWarnings("unused")
    @XmlElement(name = "inscription")
    private Label getInscriptionXml() {
        return Defaults.requireNonDefault(inscription);
    }

    @SuppressWarnings("unused")
    private void setInscriptionXml(Label inscription) {
        this.inscription = inscription;
    }

    //endregion

}
