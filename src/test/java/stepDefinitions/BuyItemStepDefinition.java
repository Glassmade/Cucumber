package stepDefinitions;

import cucumber.api.java.en.Given;
import models.StaticDataEnum;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuyItemStepDefinition {

    private WebDriver driver = null;

    public BuyItemStepDefinition(BasicStepDefinition basicStepDefinition) {
        this.driver = basicStepDefinition.driver;
    }

    @Given("Customer is logged in")
    public void logging_in_a_customer() throws InterruptedException {
        String customerName = StaticDataEnum.CUSTOMER_FIRSTNAME.toString() + " " + StaticDataEnum.CUSTOMER_LASTNAME.toString();
        WebElement loggedUser = driver.findElement(By.className("account"));
        Assert.assertEquals(customerName,loggedUser.getText());
        BasicStepDefinition.fourSecondsPause();
    }
}
