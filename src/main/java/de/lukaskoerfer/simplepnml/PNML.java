package de.lukaskoerfer.simplepnml;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import lombok.SneakyThrows;

/**
 * Provides utility functions to work with PNML documents
 */
@lombok.experimental.UtilityClass
public class PNML {

    /**
     * Reads a PNML document from a stream
     * @param stream A stream providing a PNML document in textual form
     * @return A PNML document
     */
    @SneakyThrows(JAXBException.class)
    public Document read(InputStream stream) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        return (Document) context.createUnmarshaller().unmarshal(stream);
    }

    /**
     * Reads a PNML document from a string
     * @param content A string containing a PNML document in textual form
     * @return A PNML document
     */
    @SneakyThrows(JAXBException.class)
    public Document read(String content) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        return (Document) context.createUnmarshaller().unmarshal(new StringReader(content));
    }

    /**
     * Reads a PNML document from a file
     * @param file A file containing a PNML document in textual form
     * @return A PNML document
     */
    @SneakyThrows(JAXBException.class)
    public Document read(File file) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        return (Document) context.createUnmarshaller().unmarshal(file);
    }

    /**
     * Reads a PNML document from an URI
     * @param uri An URI pointing to a PNML document in textual form
     * @return A PNML document
     */
    @SneakyThrows(JAXBException.class)
    public Document read(URI uri) {
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
    public Document write(Document document, OutputStream stream) {
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
    public Document write(Document document, StringWriter writer) {
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
    public Document write(Document document, File file) {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        context.createMarshaller().marshal(document, file);
        return document;
    }
}
