package de.lukaskoerfer.simplepnml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import lombok.SneakyThrows;

import com.thaiopensource.validate.ValidationDriver;
import static com.thaiopensource.validate.ValidationDriver.fileInputSource;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import static org.jeasy.random.FieldPredicates.inClass;
import static org.jeasy.random.FieldPredicates.named;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class XmlTest {

    static EasyRandom random;

    static Marshaller marshaller;

    static Unmarshaller unmarshaller;

    @TempDir
    static File tempDirectory;

    static ValidationDriver validator;

    @BeforeAll
    @SneakyThrows
    static void setup() {
        random = new EasyRandom(new EasyRandomParameters()
            .overrideDefaultInitialization(true)
            .collectionSizeRange(1, 2)
            .randomize(Double.class, () -> random.nextInt(100) / 10.0)
            .randomize(inClass(Net.class).and(named("type")), () -> Net.PLACE_TRANSITION_TYPE)
            .excludeField(inClass(Arc.class).and(named("inscription")))
            .excludeField(inClass(Place.class).and(named("initialMarking")))
            .excludeField(inClass(Page.class).and(named("pages")))
            .excludeField(inClass(ToolSpecific.class).and(named("contents")))
        );

        var context = JAXBContext.newInstance(Document.class);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        unmarshaller = context.createUnmarshaller();

        validator = new ValidationDriver();
        validator.loadSchema(fileInputSource(new File("src/test/resources/schema/pnmlcoremodel.rng")));
        validator.loadSchema(fileInputSource(new File("src/test/resources/schema/conventions.rng")));
        validator.loadSchema(fileInputSource(new File("src/test/resources/schema/ptnet.rng")));
    }

    @Test
    @SneakyThrows
    void toXml_generatedDocument_matchesSchema() {
        File tempFile = File.createTempFile("generated", ".pnml", tempDirectory);
        Document document = random.nextObject(Document.class);

        marshaller.marshal(document, System.out);
        marshaller.marshal(document, tempFile);

        assertTrue(validator.validate(fileInputSource(tempFile)));
    }

    @Test
    void toXmlAndFromXml_generatedDocument_equals() {
        Document document = random.nextObject(Document.class);


    }

    @ParameterizedTest
    @ValueSource(strings = {
        "src/test/resources/example/philo.pnml",
        "src/test/resources/example/piscine.pnml",
        "src/test/resources/example/token-ring.pnml"
    })
    @SneakyThrows
    void fromXmlAndToXml_exampleDocument_equals(File original) {
        var document = (Document) unmarshaller.unmarshal(original);

    }

}
