package parser.sax;

public enum SportTagEnum {

    SPORT_SHOP("SportShop"),
    SPORT("sportinv"),
    SPORT_NAME("name"),
    SPORT_COMPANY("company"),
    SPORT_CATEGORY("category"),
    SPORT_DESCRIPTION("description"),
    SPORT_PRICE("price"),
    SPORT_CODETOVARS("CodeTovars"),
    NULL("");

    private String tagName;
    private String nameSpace;

    public static SportTagEnum getInstance(String tag, String nameSpace) {
        for (SportTagEnum e : SportTagEnum.values()) {
            if (e.getNameSpace().equals(nameSpace) && e.getTagName().equals(tag)) {
                return e;
            }
        }
        return NULL;
    }

    SportTagEnum(String tagName) {
        this.tagName = tagName;
        this.nameSpace = "http://nure.ua/SPORTShop";
    }

    public boolean isSportShop() {
        return this == SPORT_SHOP;
    }

    public boolean isSport() {
        return this == SPORT;
    }

    public boolean isSportName() {
        return this == SPORT_NAME;
    }

    public boolean isCompany() {
        return this == SPORT_COMPANY;
    }

    public boolean isCodeTovars() {
        return this == SPORT_CODETOVARS;
    }

    public boolean isSportCategory() {
        return this == SPORT_CATEGORY;
    }

    public boolean isSportPrice() {
        return this == SPORT_PRICE;
    }
    
    public boolean isSportDescription() {
        return this == SPORT_DESCRIPTION;
    }

    public String getTagName() {
        return tagName;
    }

    public String getNameSpace() {
        return nameSpace;
    }

}
