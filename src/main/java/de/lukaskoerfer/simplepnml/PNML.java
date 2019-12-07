package de.lukaskoerfer.simplepnml;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.URI;

/**
 * Provides utility functions to work with PNML documents in a fluent style
 */
@UtilityClass
public class PNML {

    /**
     * Creates an empty PNML document
     * @return An empty PNML document
     */
    public static Document create() {
        return new Document();
    }

    /**
     * Reads a PNML document from a stream
     * @param stream A stream providing a PNML document in textual form
     * @return A PNML document
     */
    @SneakyThrows(JAXBException.class)
    public static Document read(InputStream stream) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        return (Document) context.createUnmarshaller().unmarshal(stream);
    }

    /**
     * Reads a PNML document from a string
     * @param content A string containing a PNML document in textual form
     * @return A PNML document
     */
    @SneakyThrows(JAXBException.class)
    public static Document read(String content) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        return (Document) context.createUnmarshaller().unmarshal(new StringReader(content));
    }

    /**
     * Reads a PNML document from a file
     * @param file A file containing a PNML document in textual form
     * @return A PNML document
     */
    @SneakyThrows(JAXBException.class)
    public static Document read(File file) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        return (Document) context.createUnmarshaller().unmarshal(file);
    }

    /**
     * Reads a PNML document from an URI
     * @param uri An URI pointing to a PNML document in textual form
     * @return A PNML document
     */
    @SneakyThrows(JAXBException.class)
    public static Document read(URI uri) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        throw new UnsupportedOperationException();
    }

    /**
     * Writes a PNML document to a stream
     * @param document A PNML document
     * @param stream A writable stream
     * @return A reference to the specified PNML document
     */
    @SneakyThrows(JAXBException.class)
    public static Document write(Document document, OutputStream stream) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        context.createMarshaller().marshal(document, stream);
        return document;
    }

    /**
     * Writes a PNML document to a string
     * @param document A PNML document
     * @param writer A target string
     * @return A reference to the specified PNML document
     */
    @SneakyThrows(JAXBException.class)
    public static Document write(Document document, StringWriter writer) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        context.createMarshaller().marshal(document, writer);
        return document;
    }

    /**
     * Writes a PNML document to a file
     * @param document A PNML document
     * @param file A writable file
     * @return A reference to the specified PNML document
     */
    @SneakyThrows(JAXBException.class)
    public static Document write(Document document, File file) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        context.createMarshaller().marshal(document, file);
        return document;
    }
}
