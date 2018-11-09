package parser.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import entity.SportInv;
import entity.SportShop;
import entity.Category;
import parser.SportInvMarshaller;
import parser.Util;

public class DomMarshaller implements SportInvMarshaller {

	private static final String SS_NS = "http://www.example.org/first";

	public static void main(String[] arg) throws IOException {
		SportInvMarshaller parser = new DomMarshaller();
		parser.marshal(Util.createSportShop(), "first1.xml");

	}

	@Override
	public void marshal(SportShop sportShop, String filePath) throws IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setValidating(true);

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			Schema schema = sf.newSchema(new File("first.xsd"));
			factory.setSchema(schema);
			factory.setNamespaceAware(true);
		} catch (SAXException e) {
			e.printStackTrace();
		}

		try {
			DocumentBuilder builder = null;
			builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			Element sportShopElement = doc.createElementNS(SS_NS, "SportShop");
			doc.appendChild(sportShopElement);

			sportShop.getSportinv().forEach(SportInv -> {
				sportShopElement.appendChild(getSportinvElement(SportInv, doc));
			});

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filePath));
			transformer.transform(source, result);

		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}

	private Element getSportinvElement(SportInv sportinv, Document doc) {
		Element bookShopElement = doc.createElementNS(SS_NS, "sportinv");
		bookShopElement.setAttribute("id", String.valueOf(sportinv.getId()));
		bookShopElement.appendChild(getSimpleElement(doc, SS_NS, "name", sportinv.getName()));
		bookShopElement.appendChild(getSimpleElement(doc, SS_NS, "company", sportinv.getCompany()));
		bookShopElement.appendChild(getSimpleElement(doc, SS_NS, "description",sportinv.getDescription()));
		bookShopElement.appendChild(getSimpleElement(doc, SS_NS, "price", sportinv.getPrice()));
		bookShopElement.appendChild(getSimpleElement(doc, SS_NS, "category", sportinv.getCategory().value()));
		bookShopElement.appendChild(getSimpleElement(doc, SS_NS, "codetovars", sportinv.getCodeTovars()));
		return bookShopElement;
	}

	private Element getSimpleElement(Document doc, String ns, String tagName, Object value) {
		Element element = doc.createElementNS(ns, tagName);
		element.setTextContent(String.valueOf(value));
		return element;
	}

}
