package models;

public enum StaticDataEnum {


    BLOUSE("Blouse"),
    REFERENCE("Model demo_2"),
    CONDITION("Condition New"),
    DESCRIPTION("Short sleeved blouse with feminine draped sleeve detail."),
    BLOUSE_LINK("http://automationpractice.com/index.php?id_product=2&controller=product"),
    WEBSITE_LINK("http://automationpractice.com/index.php"),
    PARTIAL_SING_UP("Sign"),
    SIGN_IN_PAGE_LINK("http://automationpractice.com/index.php?controller=authentication&back=my-account"),
    PAGE_PRODUCT_REFERENCE("product_reference"),
    PAGE_PRODUCT_CONDITION("product_condition"),
    ELEMENT_EMAIL_FIELD("email_create"),
    PAGE_PRODUCT_DESCRIPTION("short_description_block"),
    PROPER_EMAIL("proper"+giveRandomNumberPrefix()+"@email.com"),
    VALUE("value"),
    ELEMENT_CREATE_ACCOUNT("SubmitCreate"),
    EMPTY(""),
    COMPLETE("complete"),
    READY_STATE_SCRIPT("return document.readyState"),
    ELEMENT_MALE_RADIO("id_gender1"),
    TAG_H1("H1"),
    THIRTY_SECONDS("30"),
    TWO_MILLISECONDS("2000"),
    FOUR_MILLISECONDS("4000"),
    SEVEN_MILLISECONDS("7000"),
    ELEMENT_FORM_FIRSTNAME("customer_firstname"),
    CUSTOMER_FIRSTNAME("John"),
    ELEMENT_FORM_LASTNAME("customer_lastname"),
    CUSTOMER_LASTNAME("Smith"),
    ELEMENT_FORM_PASSWORD("passwd"),
    CUSTOMER_PASSWORD("00000");

    private final String reference;

    StaticDataEnum(String inputtedText) {
        this.reference = inputtedText;
    }

    private static String giveRandomNumberPrefix(){
        int random_int = (int)Math.floor(Math.random()*(1000-1+1)+1);
        return Integer.toString(random_int);
    }
    @Override
    public String toString() {
        return reference;
    }
}
