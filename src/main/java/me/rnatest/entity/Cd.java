package me.rnatest.entity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;


@XmlRootElement(name = "CD")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cd {

    @XmlElement(name = "TITLE", required = true, nillable = false)
    public String title;
    @XmlElement(name = "ARTIST", required = true, nillable = false)
    public String artist;
    @XmlElement(name = "COUNTRY", required = true, nillable = false)
    public String country;
    @XmlElement(name = "COMPANY", required = true, nillable = false)
    public String company;
    @XmlElement(name = "PRICE", required = true, nillable = false)
    public String price;
    @XmlElement(name = "YEAR", required = true, nillable = false)
    public String year;

    @Override
    public String toString() {
        return "Cd{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", country='" + country + '\'' +
                ", company='" + company + '\'' +
                ", price='" + price + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
