package me.rnatest.entity.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "CD")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cd extends me.rnatest.entity.Cd {

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
