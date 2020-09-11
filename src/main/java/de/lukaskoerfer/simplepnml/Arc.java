package de.lukaskoerfer.simplepnml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Represents an arc in a petri net
 */
@lombok.EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Arc implements Identifiable, Collectable, Edge, ToolExtendable {

    @Setter
    @NonNull
    private String id;

    @Getter @Setter
    @NonNull
    @XmlAttribute(name = "source", required = true)
    private String source = "";

    @Getter @Setter
    @NonNull
    @XmlAttribute(name = "target", required = true)
    private String target = "";

    @Getter @Setter
    @NonNull
    private EdgeGraphics graphics = new EdgeGraphics();

    @Getter @Setter
    @NonNull
    private Label inscription = new Label();

    @Getter
    @XmlElement(name = "toolspecific")
    private List<ToolSpecific> toolSpecifics = new ArrayList<>();

    /**
     * Creates a new arc
     */
    public Arc() { }

    /**
     * Creates a new arc
     * @param id
     */
    public Arc(String id) {
        setId(id);
    }

    @lombok.Builder
    private Arc(String id, String source, String target, EdgeGraphics graphics,
                Label inscription, @lombok.Singular List<ToolSpecific> toolSpecifics) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.graphics = graphics;
        this.inscription = inscription;
        this.toolSpecifics = new ArrayList<>(toolSpecifics);
    }

    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(getGraphics())
            .include(getInscription())
            .include(getToolSpecifics())
            .collect();
    }

    /**
     * Gets the identifier of this arc
     * @return
     */
    @XmlAttribute(name = "id", required = true)
    public String getId() {
        return requireNonNullElseGet(id, () -> id = Identifiable.randomId());
    }

    /**
     * Sets the tool-specific elements related to this arc
     * @param toolSpecificData
     */
    public void setToolSpecifics(@NonNull List<ToolSpecific> toolSpecificData) {
        this.toolSpecifics = new ArrayList<>(toolSpecificData);
    }

    @XmlElement(name = "graphics")
    private EdgeGraphics getGraphicsXml() {
        return requireNonDefaultElseNull(graphics);
    }

    private void setGraphicsXml(EdgeGraphics graphics) {
        this.graphics = graphics;
    }

    @XmlElement(name = "inscription")
    private Label getInscriptionXml() {
        return requireNonDefaultElseNull(inscription);
    }

    private void setInscriptionXml(Label inscription) {
        this.inscription = inscription;
    }

}
