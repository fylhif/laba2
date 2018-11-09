package parser.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import entity.SportShop;
import parser.SportInvUnmarshaller;

public class JAXBUnmarshaller implements SportInvUnmarshaller {

	public SportShop unmarshal(String filePath) {
		try {
			File file=new File(filePath);
			JAXBContext jaxbContext = JAXBContext.newInstance(SportShop.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (SportShop) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] arg) {
		JAXBUnmarshaller jaxbUnmarshaller = new JAXBUnmarshaller();
		SportShop sportShop = jaxbUnmarshaller.unmarshal("jaxb.xml");
		System.out.println(sportShop.toString());
	}
}
