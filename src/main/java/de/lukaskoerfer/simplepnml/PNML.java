package de.lukaskoerfer.simplepnml;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.net.URI;

@UtilityClass
public class PNML {

    public static Document create() {
        return new Document();
    }

    public static Document read(String content) {
        // TODO: Implementation
        throw new UnsupportedOperationException();
    }

    public static Document read(File file) {
        // TODO: Implementation
        throw new UnsupportedOperationException();
    }

    public static Document read(URI uri) {
        // TODO: Implementation
        throw new UnsupportedOperationException();
    }

    public static String write(Document document) {
        // TODO: Implementation
        throw new UnsupportedOperationException();
    }

    public static String write(Document document, File file) {
        // TODO: Implementation
        throw new UnsupportedOperationException();
    }
}
