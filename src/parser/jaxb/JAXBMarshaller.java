package parser.jaxb;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import entity.SportShop;
import parser.SportInvMarshaller;
import parser.Util;

public class JAXBMarshaller implements SportInvMarshaller {

    public void marshal(SportShop sportShop, String filePath) throws IOException {
        OutputStream os = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(SportShop.class);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,"http://www.example.org/first first.xsd");
            os = new FileOutputStream(filePath);
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(sportShop, os);
            m.marshal(sportShop, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            os.close();
        }
    }

    public static void main(String[] arg) throws Exception {
    	SportInvMarshaller jaxbMarshaller = new JAXBMarshaller();
        jaxbMarshaller.marshal(Util.createSportShop(), "jaxb.xml");
    }
}
