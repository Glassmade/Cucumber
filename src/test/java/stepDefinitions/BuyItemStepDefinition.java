package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import models.StaticDataEnum;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class BuyItemStepDefinition {

    private WebDriver driver = null;

    public BuyItemStepDefinition(BasicStepDefinition basicStepDefinition) {
        this.driver = basicStepDefinition.driver;
    }

    /***
     * Test case 4 preconditions.
     * After Basic step definition create a user we check the block on the page that holds that information.
     * @throws InterruptedException
     */
    @Given("Customer is logged in")
    public void customer_is_logged_in() throws InterruptedException {
        String customerName = StaticDataEnum.CUSTOMER_FIRSTNAME.toString() + " " + StaticDataEnum.CUSTOMER_LASTNAME.toString();
        WebElement loggedUser = driver.findElement(By.className("account"));
        Assert.assertEquals(customerName,loggedUser.getText());
        BasicStepDefinition.fourSecondsPause();
    }

    /***
     * Test case Step 1.
     * User clicks on the clothing item link (T-Shirts).
     * We assert that the redirecting page holds at least a single item in display.
     * @throws InterruptedException
     */
    @When("Customer clicks specific clothing item link")
    public void customer_clicks_on_item_link() throws InterruptedException {

        List<WebElement> listElements = driver.findElements(By.tagName("li"));

        for (WebElement webElement : listElements){
            if(webElement.getText().equals("T-SHIRTS")){
                webElement.click();
                break;
            }
        }

        BasicStepDefinition.fourSecondsPause();
        Assert.assertTrue(returnNumberOfProductsOnPage(3)>0);
    }

    /***
     * Grabbing specific information about items showed.
     * @return the first digit of the items showed in int.
     */
    private int returnNumberOfProductsOnPage(int inputtedIndex) {
        WebElement counterOfItems  = driver.findElement(By.className("heading-counter"));
        String counterText = counterOfItems.getText();
        return Integer.parseInt(counterText.substring(counterText.indexOf("is")+inputtedIndex,counterText.indexOf("is")+4));
    }

    /***
     * Step 2
     * @throws InterruptedException
     */
    @And("Customer adds item to cart")
    public void customer_adds_item_to_cart() throws InterruptedException {

        Actions hover = new Actions(driver);
        List<WebElement> imagesOfThePage = driver.findElements(By.tagName("img"));

        for (WebElement image : imagesOfThePage){
            if (image.getAttribute("title").equals("Faded Short Sleeve T-shirts")){
                hover.moveToElement(image).perform();
                BasicStepDefinition.fourSecondsPause();
            }
        }


        List<WebElement> linksOfThePage = driver.findElements(By.tagName("a"));
        Assert.assertTrue(linksOfThePage.size()>0);

        for (WebElement addToCartLink : linksOfThePage){
            if(addToCartLink.getAttribute("title").equals("Add to cart")){
                addToCartLink.click();
                break;
            }
        }
        BasicStepDefinition.fourSecondsPause();
    }


    /***
     * Step 3
     * @throws InterruptedException
     */
    @And("Customer continues shopping")
    public void customer_continues_shopping() throws InterruptedException {
        List<WebElement> linksOfThePage = driver.findElements(By.tagName("span"));
        Assert.assertTrue(linksOfThePage.size()>0);
        for (WebElement continueShopping : linksOfThePage){
            if(continueShopping.getAttribute("title").equals("Continue shopping")){
                continueShopping.click();
                break;
            }
        }
        BasicStepDefinition.fourSecondsPause();
    }


    /***
     * Step 4
     * @throws InterruptedException
     */
    @And("Customer clicks another specific clothing item link")
    public void customer_clicks_for_another_clothing_item() throws InterruptedException {
        List<WebElement> listElements = driver.findElements(By.tagName("li"));

        for (WebElement webElement : listElements){
            if(webElement.getText().equals("DRESSES")){
                BasicStepDefinition.fourSecondsPause();
                webElement.click();
                break;
            }
        }

        BasicStepDefinition.fourSecondsPause();
    }

    /***
     * Step 5
     * @throws InterruptedException
     */
    @And("Customer adds another item to cart")
    public void customer_adds_another_clothing_item_in_the_cart() throws InterruptedException{
        Actions hover = new Actions(driver);
        List<WebElement> imagesOfThePage = driver.findElements(By.tagName("img"));

        for (WebElement image : imagesOfThePage){
            if (image.getAttribute("title").equals("Printed Dress")){
                hover.moveToElement(image).perform();
                BasicStepDefinition.fourSecondsPause();
                break;
            }
        }


        List<WebElement> linksOfThePage = driver.findElements(By.tagName("a"));
        Assert.assertTrue(linksOfThePage.size()>0);

        for (WebElement addToCartLink : linksOfThePage){
            if(addToCartLink.getAttribute("title").equals("View")){
                addToCartLink.click();
                break;
            }
        }
        BasicStepDefinition.fourSecondsPause();

        List<WebElement> buttonList = driver.findElements(By.tagName("button"));

        for (WebElement addToCartButton : buttonList){
            if (addToCartButton.getAttribute("name").equals("Submit")){
                addToCartButton.click();
            }
        }
    }

    /***
     * Step 6
     * @throws InterruptedException
     */
    @And("Customer proceeds to checkout")
    public void customer_proceeds_to_checkout() throws InterruptedException {
        List<WebElement> linksOfThePage = driver.findElements(By.tagName("a"));
        Assert.assertTrue(linksOfThePage.size()>0);
        for (WebElement continueShopping : linksOfThePage){
            if(continueShopping.getAttribute("title").equals("Proceed to checkout")){
                continueShopping.click();
                break;
            }
        }
        BasicStepDefinition.fourSecondsPause();
        BasicStepDefinition.fourSecondsPause();
    }
}