package me.rnatest.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "CATALOG")
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog {

    @XmlElement(name = "CD", required = true)
    public List<Cd> cds  =new ArrayList<Cd>();

    @Override
    public String toString() {
        return "Catalog{" +
                "cds=" + cds +
                '}';
    }
}
