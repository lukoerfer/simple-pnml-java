package de.lukaskoerfer.simplepnml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;

import static de.lukaskoerfer.simplepnml.Defaultable.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Represents an arc in a petri net
 */
@EqualsAndHashCode
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
     * @param id An identifier, should be unique
     */
    public Arc(String id) {
        this.id = id;
    }

    @lombok.Builder
    private Arc(String id, String source, String target, EdgeGraphics graphics,
                Label inscription, @Singular List<ToolSpecific> toolSpecifics) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.graphics = graphics;
        this.inscription = inscription;
        this.toolSpecifics = new ArrayList<>(toolSpecifics);
    }

    @Override
    public Stream<Collectable> collect() {
        return new Collector(this)
            .include(graphics)
            .include(inscription)
            .include(toolSpecifics)
            .collect();
    }

    /**
     * Gets the identifier of this arc
     * @return An identifier, either defined or a generated UUID
     */
    @XmlAttribute(name = "id", required = true)
    public String getId() {
        return requireNonNullElseGet(id, () -> id = Identifiable.randomId());
    }

    /**
     * Sets the tool-specific elements describing this arc
     * @param toolSpecifics A list of tool-specific elements
     */
    public void setToolSpecifics(@NonNull List<ToolSpecific> toolSpecifics) {
        this.toolSpecifics = new ArrayList<>(toolSpecifics);
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
