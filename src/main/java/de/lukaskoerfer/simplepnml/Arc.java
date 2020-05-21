package de.lukaskoerfer.simplepnml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Singular;

import static de.lukaskoerfer.simplepnml.Defaults.requireNonDefaultElseNull;
import static java.util.Objects.requireNonNullElseGet;

/**
 * Represents an arc in a place/transition net
 */
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class Arc implements Identifiable, Collectable, Edge, ToolExtendable {

    private String id;
    private String source = "";
    private String target = "";
    private EdgeGraphics graphics;
    private Label inscription;
    private List<ToolSpecific> toolSpecifics;

    /**
     * Creates a new arc using a random identifier
     */
    public Arc() { }

    /**
     *
     * @param id
     */
    public Arc(String id) {
        setId(id);
    }

    @Builder
    private Arc(String id, String source, String target, EdgeGraphics graphics,
                Label inscription, @Singular List<ToolSpecific> toolSpecifics) {
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

    @XmlAttribute(name = "id", required = true)
    public String getId() {
        return requireNonNullElseGet(id, () -> id = Identifiable.randomId());
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute(name = "source", required = true)
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @XmlAttribute(name = "target", required = true)
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public EdgeGraphics getGraphics() {
        return requireNonNullElseGet(graphics, () -> graphics = new EdgeGraphics());
    }

    public void setGraphics(EdgeGraphics graphics) {
        this.graphics = graphics;
    }

    public Label getInscription() {
        return requireNonNullElseGet(inscription, () -> inscription = new Label());
    }

    public void setInscription(Label inscription) {
        this.inscription = inscription;
    }

    @XmlElement(name = "toolspecific")
    public List<ToolSpecific> getToolSpecifics() {
        return requireNonNullElseGet(toolSpecifics, () -> toolSpecifics = new ArrayList<>());
    }

    public void setToolSpecifics(List<ToolSpecific> toolSpecificData) {
        this.toolSpecifics = new ArrayList<>(toolSpecificData);
    }

    @XmlElement(name = "graphics")
    @SuppressWarnings("unused")
    private EdgeGraphics getGraphicsXml() {
        return requireNonDefaultElseNull(getGraphics());
    }

    @SuppressWarnings("unused")
    private void setGraphicsXml(EdgeGraphics graphics) {
        setGraphics(graphics);
    }

    @SuppressWarnings("unused")
    @XmlElement(name = "inscription")
    private Label getInscriptionXml() {
        return requireNonDefaultElseNull(getInscription());
    }

    @SuppressWarnings("unused")
    private void setInscriptionXml(Label inscription) {
        setInscription(inscription);
    }

}
