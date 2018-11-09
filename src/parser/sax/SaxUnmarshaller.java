package parser.sax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import entity.SportInv;
import entity.SportShop;
import entity.Category;
import parser.SportInvUnmarshaller;

public class SaxUnmarshaller implements ContentHandler, SportInvUnmarshaller {

    private SportShop shop = new SportShop();
    private SportInv currentSportInv;
    private SportTagEnum currentTag;
    private List<SportTagEnum> tags;

    public static void main(String[] arg) {
        SaxUnmarshaller saxUnmarshaller = new SaxUnmarshaller();
        SportShop sportShop = saxUnmarshaller.unmarshal("first1.xml");
        System.out.println(sportShop);
    }

    @Override
    public SportShop unmarshal(String filePath) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(this);
            reader.parse(filePath);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return shop;
    }

    @Override
    public void setDocumentLocator(Locator locator) {
    }

    @Override
    public void startDocument() throws SAXException {
        tags = new ArrayList<SportTagEnum>();
    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        tags.add(SportTagEnum.getInstance(localName, uri));
        currentTag = tags.get(tags.size() - 1);
        if (currentTag.isSport()) {
            this.currentSportInv = new SportInv();
            currentSportInv.setId(Integer.parseInt(atts.getValue("id")));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentTag.isSport()) {
            this.shop.getSportinv().add(currentSportInv);
            this.currentSportInv = null;
        }

        tags.remove(tags.size() - 1);
        currentTag = tags.size() > 0 ? tags.get(tags.size() - 1) : null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        if (currentTag.isSportName()) {
            currentSportInv.setName(str);
        } else if (currentTag.isSportCategory()) {
            currentSportInv.setCategory(Category.fromValue(str));
        } else if (currentTag.isSportDescription()) {
            currentSportInv.setDescription(str);
        } else if (currentTag.isSportPrice()) {
            currentSportInv.setPrice(Double.parseDouble(str));
        } else if (currentTag.isCompany()) {
            currentSportInv.setCompany(str);
        } else if (currentTag.isCodeTovars()) {
            currentSportInv.setCodeTovars(str);
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }

}
