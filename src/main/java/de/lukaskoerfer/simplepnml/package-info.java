@XmlSchema(
    namespace = Document.PNML_NAMESPACE,
    elementFormDefault = XmlNsForm.QUALIFIED,
    xmlns = {
        @XmlNs(prefix = "", namespaceURI = Document.PNML_NAMESPACE)
    }
)
@XmlAccessorType(XmlAccessType.NONE)
package de.lukaskoerfer.simplepnml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;