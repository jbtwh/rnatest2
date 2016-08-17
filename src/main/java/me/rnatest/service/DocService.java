package me.rnatest.service;

import me.rnatest.entity.Catalog;
import me.rnatest.entity.test.Cd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.*;


public class DocService {

    public static final Map<String, me.rnatest.entity.Cd> doc = Collections.synchronizedMap(new LinkedHashMap<String, me.rnatest.entity.Cd>());
    static Logger log = LoggerFactory.getLogger(DocService.class);


    public static void add(MultipartFile file){
        try {

            ByteArrayInputStream input = new ByteArrayInputStream (file.getBytes());
            Unmarshaller u = JAXBContext.newInstance(me.rnatest.entity.Cd.class, Catalog.class).createUnmarshaller();
            Catalog cat = (Catalog) u.unmarshal(input);
            log.info("adding "+ cat);
            for (me.rnatest.entity.Cd cd : cat.cds){
                doc.put(cd.title, cd);
            }
            log.info("current doc="+ doc);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Catalog getDoc() {
            Catalog cat = new Catalog();
            cat.cds.addAll(doc.values());

            return cat;
    }

    public static byte[] cat2Ba(Catalog cat){
        try {
            JAXBContext ctx = JAXBContext.newInstance(me.rnatest.entity.Cd.class, Catalog.class);
            System.out.println(ctx);
            Marshaller m = ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            m.marshal(cat, out);

            return out.toByteArray();
        } catch (JAXBException e) {
            throw  new RuntimeException(e);
        }
    }

    public static void main(String... args) throws JAXBException {
        Catalog cat = new Catalog();
        cat.cds.add(new me.rnatest.entity.Cd());
        cat.cds.add(new me.rnatest.entity.test.Cd());

        JAXBContext ctx = JAXBContext.newInstance(me.rnatest.entity.Cd.class, Catalog.class, Cd.class);
        System.out.println(ctx);
        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        m.marshal(cat, System.out);
    }
}
