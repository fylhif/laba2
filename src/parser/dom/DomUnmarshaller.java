package parser.dom;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import entity.SportInv;
import entity.SportShop;
import entity.Category;
import parser.SportInvUnmarshaller;

public class DomUnmarshaller implements SportInvUnmarshaller {

	private static final String SS_NS = "http://www.example.org/first";

    public static void main(String[] arg) {
    	SportInvUnmarshaller parser = new DomUnmarshaller();
        SportShop sportShop = parser.unmarshal("first.xml");
        System.out.println(sportShop);
    }

    @Override
    public SportShop unmarshal(String filePath) {
    	SportShop sportShop = new SportShop();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));
            if (doc != null) {
                Element sportShopElement = doc.getDocumentElement();
                if (sportShopElement != null) {
                    NodeList sportinvNodeList = sportShopElement.getChildNodes();
                    for (int i = 0; i < sportinvNodeList.getLength(); i++) {
                        if (sportinvNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                            SportInv sportinv = parseSportInv((Element) sportinvNodeList.item(i));
                            if (sportinv != null) {
                                sportShop.getSportinv().add(sportinv);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sportShop;
    }

    private SportInv parseSportInv(Element sportinvElement) {
    	SportInv sportinv = new SportInv();
    	sportinv.setId(Integer.parseInt(sportinvElement.getAttribute("id")));
    	sportinv.setName(getValue(sportinvElement, "name"));
    	sportinv.setCompany(getValue(sportinvElement, "company"));
    	sportinv.setDescription(getValue(sportinvElement, "description"));
    	sportinv.setPrice(Double.parseDouble(getValue(sportinvElement, "price")));
    	sportinv.setCategory(Category.fromValue(getValue(sportinvElement, "category")));
    	sportinv.setCodeTovars(getValue(sportinvElement, "CodeTovars"));
        return sportinv;
    }

    private List<String> getValues(Element parent, String nodeName) {
        List<String> values = new ArrayList<>();
        NodeList elements = parent.getElementsByTagNameNS(SS_NS, nodeName);
        for (int i = 0; i < elements.getLength(); i++) {
            Node node = elements.item(i);
            if (node != null) {
                values.add(node.getTextContent());
            } else {
                values.add("");
            }
        }
        return values;
    }

    private String getValue(Element parent, String nodeName) {
        return getValues(parent, nodeName).get(0);
    }
}

