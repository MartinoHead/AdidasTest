package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.HomePage;
import pages.PDP;

public class Steps {
    WebDriver webDriver = null;
    HomePage homePage;
    PDP pdp;
    CartPage cartPage;

    @Before
    public void setup(){
        System.out.println("New Test!!!");
    }

    @After
    public void tearDown() {
        System.out.println("Closing Browser Window...");
        webDriver.close();
        webDriver.quit();
    }

    /**
     * Home Page Steps
     */

    @Given("The user is navigated to {word}")
    public void theUserIsNavigatedToURL(String url) {
        webDriver = new ChromeDriver();
        webDriver.navigate().to(url);
        webDriver.manage().window().maximize();
    }

    @When("The user go back to Home Page")
    public void goBackToHomePage() {
        homePage.clickWebsiteLogo();
    }

    @Then("The Home Page is displayed")
    public void homePageIsDisplayed() {
        homePage = new HomePage(webDriver);
        homePage.homePageIsDisplayed();
    }

    @When("Select category {word}")
    public void selectCat(String cat) {
        homePage.selectCat(cat);
    }

    @When("Click on product {string}")
    public void clickOnProduct(String productName) {
        homePage.clickOnProduct(productName);
    }

    /**
     * Product Description Page steps
     */

    @When("PDP is displayed")
    public void PDPisDisplayed() {
        pdp = new PDP(webDriver);
        pdp.PDPIsDisplayed();
    }

    @When("Click on add to cart link")
    public void clickAddToCart() {
        pdp.clickAddToCart();
    }

    @When("Accept alert")
    public void acceptAlert() {
        pdp.handleAlert();
    }

    /**
     * Cart Page Steps
     * */

    @When("The user navigate to Cart Page")
    public void goToCartPage(){
        cartPage = new CartPage(webDriver);
        cartPage.goToCartPage();
    }

    @Then("Cart Page is displayed")
    public void cartPageIsDisplayed(){
        cartPage.cartPageIsDisplayed();
    }

    @When("The user click on Place Order button")
    public void clickPlaceOrder(){
        cartPage.clickPlaceOrderButton();
    }

    /**
     * Place Order Modal Steps
     * */

    @Then("Place Order modal is displayed")
    public void placeOrderModalIsDisplayed(){
        cartPage.placeOrderModalIsDisplayed();
    }

    @When("The user delete product {string} from cart")
    public void deleteProduct(String productName){
        cartPage.deleteProduct(productName);
    }

    @When("The user apply {word}, {word}, {word}, {word}, {word} and {word} in order form")
    public void enterUserData(String name, String country, String city, String card, String month, String year){
        cartPage.applyOrderForm(name, country, city, card, month, year);
    }

    @When("The user click on purchase button")
    public void completeOrder(){
        cartPage.clickOnPurchaseButton();
    }

    /**
     * Order Confirmation Modal Steps
     * */

    @Then("Order Confirmation message is displayed")
    public void orderConfirmationMessageIsDisplayed(){
        cartPage.orderConfirmationMessageIsDisplayed();
    }

    @When("Take screenshot! (Ka-chick)!")
    public void takeScreenshot(){
        cartPage.takeScreenshot();
    }

    @When("The user click on Order Confirm OK button")
    public void clickConfirmOrderButton(){
        cartPage.clickConfirmButton();
    }
}
