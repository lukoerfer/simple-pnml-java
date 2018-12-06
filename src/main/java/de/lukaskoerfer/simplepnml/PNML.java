package de.lukaskoerfer.simplepnml;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Root(name = "pnml")
@Namespace(reference = "http://www.pnml.org/version-2009/grammar/pnml")
public class PNML {

    @ElementList(required = false, inline = true)
    private List<Net> nets = new ArrayList<>();
     
    public void write(OutputStream target) throws Exception {
    	buildSerializer().write(this, target);
    }
    
    public void write(Writer target) throws Exception {
    	buildSerializer().write(this, target);
    }
    
    public void write(File target) throws Exception {
    	buildSerializer().write(this, target);
    }
    
    public String write() throws Exception {
    	try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
    		write(stream);
    		return new String(stream.toByteArray(), StandardCharsets.UTF_8);
    	}
    }

    public static PNML read(InputStream source) throws Exception {
        return buildSerializer().read(PNML.class, source);
    }

    public static PNML read(Reader source) throws Exception {
        return buildSerializer().read(PNML.class, source);
    }
    
    public static PNML read(File source) throws Exception {
        return buildSerializer().read(PNML.class, source);
    }
    
    public static PNML read(String source) throws Exception {
        return buildSerializer().read(PNML.class, source);
    }
    
    protected static Serializer buildSerializer() {
        Persister persister = new Persister();
        return persister;
    }
}
