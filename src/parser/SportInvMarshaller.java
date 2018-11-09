package parser;

import entity.SportShop;

import java.io.IOException;

public interface SportInvMarshaller {

    void marshal(SportShop sportShop, String filePath) throws IOException;
}
