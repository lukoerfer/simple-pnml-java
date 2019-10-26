package de.lukaskoerfer.simplepnml;

import lombok.experimental.UtilityClass;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.net.URI;

@UtilityClass
public class PNML {

    public static Document create() {
        return new Document();
    }

    public static Document read(String content) {
        // TODO: Implementation
        throw new NotImplementedException();
    }

    public static Document read(File file) {
        // TODO: Implementation
        throw new NotImplementedException();
    }

    public static Document read(URI uri) {
        // TODO: Implementation
        throw new NotImplementedException();
    }

    public static String write(Document document) {
        // TODO: Implementation
        throw new NotImplementedException();
    }

    public static String write(Document document, File file) {
        // TODO: Implementation
        throw new NotImplementedException();
    }
}
