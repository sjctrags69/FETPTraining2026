package org.fujitsu.training.codes.itemB;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Volume {

    private int volume;
    private int number;

    public Volume() {}

    public Volume(int volume, int number) {
        this.volume = volume;
        this.number = number;
    }
}