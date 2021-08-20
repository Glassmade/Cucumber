package models;

public enum StaticDataEnum {

    SIGN_IN_PAGE_LINK("http://automationpractice.com/index.php?controller=authentication&back=my-account"),
    T_SHIRT_PAGE_LINK("http://automationpractice.com/index.php?id_category=5&controller=category"),
    ELEMENT_EMAIL_FIELD("email_create"),
    ELEMENT_CREATE_ACCOUNT("SubmitCreate"),
    ELEMENT_MALE_RADIO("id_gender1"),
    ELEMENT_FORM_FIRSTNAME("customer_firstname"),
    ELEMENT_FORM_LASTNAME("customer_lastname"),
    ELEMENT_FORM_PASSWORD("passwd"),
    ELEMENT_FORM_ADDRESS("address1"),
    ELEMENT_FORM_CITY("city"),
    ELEMENT_FORM_STATE_ID("id_state"),
    ELEMENT_FORM_COUNTRY_ID("id_country"),
    ELEMENT_FORM_POSTCODE("postcode"),
    ELEMENT_FORM_MOBILE_PHONE("phone_mobile"),
    ELEMENT_FORM_SUBMIT_BUTTON("submitAccount"),
    COMPLETE("complete"),
    READY_STATE_SCRIPT("return document.readyState"),
    ONE("1"),
    THREE("3"),
    THIRTY_SECONDS("30"),
    TWO_MILLISECONDS("2000"),
    FOUR_MILLISECONDS("4000"),
    SEVEN_MILLISECONDS("7000"),
    CUSTOMER_FIRSTNAME("John"),
    CUSTOMER_LASTNAME("Smith"),
    CUSTOMER_PASSWORD("00000"),
    CUSTOMER_ADDRESS("26 High Street"),
    CUSTOMER_CITY("Glasgow"),
    CUSTOMER_PHONE_NUMBER("555555"),
    PROPER_EMAIL("proper"+giveRandomNumberPrefix()+"@mail.com");

    private final String reference;

    StaticDataEnum(String inputtedText) {
        this.reference = inputtedText;
    }

    private static String giveRandomNumberPrefix(){
        int random_int = (int)Math.floor(Math.random()*(1000000-1+1)+1);
        return Integer.toString(random_int);
    }
    @Override
    public String toString() {
        return reference;
    }
}
