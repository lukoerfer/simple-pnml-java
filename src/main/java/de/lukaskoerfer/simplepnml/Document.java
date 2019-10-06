package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "pnml", namespace = "http://www.pnml.org/version-2009/grammar/pnml")
@EqualsAndHashCode
public class Document {

    @XmlElement(name = "net")
    @Getter
    private List<Net> nets = new ArrayList<>();

}
