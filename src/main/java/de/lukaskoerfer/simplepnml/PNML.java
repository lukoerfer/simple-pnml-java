package de.lukaskoerfer.simplepnml;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.URI;

@UtilityClass
public class PNML {

    public static Document create() {
        return new Document();
    }

    @SneakyThrows(JAXBException.class)
    public static Document read(InputStream stream) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        return (Document) context.createUnmarshaller().unmarshal(stream);
    }

    @SneakyThrows(JAXBException.class)
    public static Document read(String content) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        return (Document) context.createUnmarshaller().unmarshal(new StringReader(content));
    }

    @SneakyThrows(JAXBException.class)
    public static Document read(File file) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        return (Document) context.createUnmarshaller().unmarshal(file);
    }

    @SneakyThrows(JAXBException.class)
    public static Document read(URI uri) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        throw new UnsupportedOperationException();
    }

    @SneakyThrows(JAXBException.class)
    public static Document write(Document document, OutputStream stream) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        context.createMarshaller().marshal(document, stream);
        return document;
    }

    @SneakyThrows(JAXBException.class)
    public static Document write(Document document, StringWriter str) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        context.createMarshaller().marshal(document, str);
        return document;
    }

    @SneakyThrows(JAXBException.class)
    public static Document write(Document document, File file) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        context.createMarshaller().marshal(document, file);
        return document;
    }
}
