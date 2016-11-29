package me.rnatest.service;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import me.rnatest.entity.Catalog;
import me.rnatest.entity.Cd;
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

    public static final Map<String, Cd> doc = Collections.synchronizedMap(new LinkedHashMap<String, Cd>());
    static Logger log = LoggerFactory.getLogger(DocService.class);


    public static void add(MultipartFile file){
        try {

            ByteArrayInputStream input = new ByteArrayInputStream (file.getBytes());
            Unmarshaller u = JAXBContext.newInstance(Cd.class, Catalog.class).createUnmarshaller();
            Catalog cat = (Catalog) u.unmarshal(input);
            log.info("adding "+ cat);
            for (Cd cd : cat.cds){
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
            Marshaller m = JAXBContext.newInstance(Cd.class, Catalog.class).createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            m.marshal(cat, out);

            return out.toByteArray();
        } catch (JAXBException e) {
            throw  new RuntimeException(e);
        }
    }
}
