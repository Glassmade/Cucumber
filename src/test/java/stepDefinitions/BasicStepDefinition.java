package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import models.StaticDataEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import services.DriverService;



public class BasicStepDefinition {

    public WebDriver driver = null;
    long timeoutDuration;

    @Before
    public void initialize() throws Exception {
        DriverService myDriverUtilities = new DriverService();
        driver = myDriverUtilities.getDriver();
        createCustomer();
    }


    private void createCustomer() throws InterruptedException {
        driver.get(StaticDataEnum.SIGN_IN_PAGE_LINK.toString());
        driver.manage().window().maximize();
        fourSecondsPause();
        WebElement userNameField = driver.findElement(By.id(StaticDataEnum.ELEMENT_EMAIL_FIELD.toString()));
        userNameField.sendKeys(StaticDataEnum.PROPER_EMAIL.toString());
        WebElement submitButton = driver.findElement(By.name(StaticDataEnum.ELEMENT_CREATE_ACCOUNT.toString()));
        submitButton.click();
        waitOnPageLoad(driver);
        sevenSecondsPause();
        fourSecondsPause();
        WebElement titleRadioButton = driver.findElement(By.id(StaticDataEnum.ELEMENT_MALE_RADIO.toString()));
        titleRadioButton.click();
        WebElement requiredField = driver.findElement(By.id(StaticDataEnum.ELEMENT_FORM_FIRSTNAME.toString()));
        requiredField.sendKeys(StaticDataEnum.CUSTOMER_FIRSTNAME.toString());
        requiredField = driver.findElement(By.id(StaticDataEnum.ELEMENT_FORM_LASTNAME.toString()));
        requiredField.sendKeys(StaticDataEnum.CUSTOMER_LASTNAME.toString());
        requiredField = driver.findElement(By.id(StaticDataEnum.ELEMENT_FORM_PASSWORD.toString()));
        requiredField.sendKeys(StaticDataEnum.CUSTOMER_PASSWORD.toString());
        requiredField = driver.findElement(By.id("address1"));
        requiredField.sendKeys("26 High Street");
        requiredField = driver.findElement(By.id("city"));
        requiredField.sendKeys("Glasgow");
        Select requiredSelect = new Select(driver.findElement(By.id("id_state")));
        requiredSelect.selectByIndex(3);
        requiredField = driver.findElement(By.id("postcode"));
        requiredField.sendKeys(StaticDataEnum.CUSTOMER_PASSWORD.toString());
        requiredSelect = new Select(driver.findElement(By.id("id_country")));
        requiredSelect.selectByIndex(1);
        requiredField = driver.findElement(By.id("phone_mobile"));
        requiredField.sendKeys("555555");
        requiredField = driver.findElement(By.id("submitAccount"));
        requiredField.click();
        sevenSecondsPause();
        sevenSecondsPause();

    }

    private void sevenSecondsPause() throws InterruptedException {
        long forSevenSeconds = Long.parseLong(StaticDataEnum.SEVEN_MILLISECONDS.toString());
        Thread.sleep(forSevenSeconds);
    }

    public static void fourSecondsPause() throws InterruptedException {
        long forFourSeconds = Long.parseLong(StaticDataEnum.FOUR_MILLISECONDS.toString());
        Thread.sleep(forFourSeconds);
    }

    private void waitOnPageLoad(WebDriver inputtedWebDriver) {
        timeoutDuration = Long.parseLong(StaticDataEnum.THIRTY_SECONDS.toString().toString());
        new WebDriverWait(inputtedWebDriver, timeoutDuration).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript(StaticDataEnum.READY_STATE_SCRIPT.toString())
                        .equals(StaticDataEnum.COMPLETE.toString()));
    }


    @After
    public void terminate() throws InterruptedException {
        long sleepTime = Long.parseLong(StaticDataEnum.TWO_MILLISECONDS.toString());
        Thread.sleep(sleepTime);
        driver.quit();
    }

}
