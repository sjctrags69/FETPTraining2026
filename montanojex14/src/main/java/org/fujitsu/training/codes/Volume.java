package org.fujitsu.training.codes;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlMixed;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Volume {
    private List<Object> content;
    
    @XmlMixed
    @XmlElementRefs({
        @XmlElementRef(name="number", type=Number.class)
    })
    public List<Object> getContent() { return content; }
    public void setContent(List<Object> content) { this.content = content; }
}
