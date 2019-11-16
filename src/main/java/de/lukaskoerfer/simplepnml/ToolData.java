package de.lukaskoerfer.simplepnml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.Element;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ToolData {

    @XmlAttribute
    @Getter @Setter
    private String tool;

    @XmlAttribute
    @Getter @Setter
    private String version;

    @XmlAnyElement
    @Getter
    private List<Element> content = new ArrayList<>();

    public ToolData(String tool, String version, Element... content) {
        setTool(tool);
        setVersion(version);
        this.content = Arrays.asList(content);
    }

}
