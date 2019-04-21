package de.lukaskoerfer.simplepnml;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
@NoArgsConstructor
public class Arc implements Identifiable {

    @Attribute
    @Getter @Setter
    private String id;

    @Attribute
    @Getter
    private String source;

    @Attribute
    @Getter
    private String target;

    @Element(required = false)
    @Getter @Setter
    private Label inscription;

    public void setSource(String source) {
        this.source = source;
    }
    
    public void setSource(Connectable source) {
        this.source = source.getId();
    }
    
    public void setTarget(String target) {
        this.target = target;
    }
    
    public void setTarget(Connectable target) {
        this.target = target.getId();
    }
    
    public void connect(Connectable source, Connectable target) {
        this.source = source.getId();
        this.target = target.getId();
    }

}
