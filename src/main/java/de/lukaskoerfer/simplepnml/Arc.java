package de.lukaskoerfer.simplepnml;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
@Builder
@NoArgsConstructor
public class Arc implements Identifiable {

    @Attribute
    @Getter @Setter
    private String id;

    @Attribute
    @Getter @Setter
    private String source;

    @Attribute
    @Getter @Setter
    private String target;

    @Element(required = false)
    @Getter @Setter
    private Label inscription;

    public void connect(Connectable source, Connectable target) {
        this.source = source.getId();
        this.target = target.getId();
    }

}
