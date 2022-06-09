package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CartPage {
    WebDriver webDriver;

    @FindBy(css = "a[href='cart.html']")
    WebElement cartHeaderLink;

    @FindBy(css = "button[class*='btn-success']")
    WebElement placeOrderButton;

    @FindBy(css = "div[class*='show'] h5[id='orderModalLabel']")
    WebElement placeOrderModal;

    @FindBy(id = "name")
    WebElement nameInputField;

    @FindBy(id = "country")
    WebElement countryInputField;

    @FindBy(id = "city")
    WebElement cityInputField;

    @FindBy(id = "card")
    WebElement creditCardInputField;

    @FindBy(id = "month")
    WebElement month;

    @FindBy(id = "year")
    WebElement year;

    @FindBy(css = "button[onclick='purchaseOrder()']")
    WebElement purchaseButton;

    @FindBy(css = "div[class*='sweet-alert'] h2")
    WebElement orderConfirmationMessage;

    @FindBy(css = "button[class*='confirm']")
    WebElement confirmButton;

    @FindBy(css = "p[class*='lead text']")
    WebElement orderSummarySection;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void goToCartPage() {
        cartHeaderLink.click();
    }

    public void cartPageIsDisplayed() {
        webDriver.getCurrentUrl().contains("https://www.demoblaze.com/cart.html");
    }

    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }

    public void placeOrderModalIsDisplayed() {
        waitForElementToLoad(By.cssSelector("div[class*='show'] h5[id='orderModalLabel']"), 5);
        placeOrderModal.isDisplayed();
    }

    public void deleteProduct(String product) {
        waitForElementToLoad(By.cssSelector("a[onclick*='deleteItem']"), 10);
        List<WebElement> productsInCart = webDriver.findElements(By.cssSelector("tr[class='success']"));
        for (WebElement productToBeDeleted : productsInCart) {
            if (productToBeDeleted.getText().contains(product)) {
                productToBeDeleted.findElement(By.cssSelector("a[onclick*='deleteItem']")).click();
                System.out.println("Deleted product: " + product);
                sleep(5000);
                return;
            }
        }
    }

    public void applyOrderForm(String name, String country, String city, String cardNumber, String month, String year) {
        nameInputField.sendKeys(name);
        countryInputField.sendKeys(country);
        cityInputField.sendKeys(city);
        creditCardInputField.sendKeys(cardNumber);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        /**
         * Just an example of usage of "this" keyword
         * */
    }

    public void clickOnPurchaseButton() {
        purchaseButton.click();
    }

    public void orderConfirmationMessageIsDisplayed() {
        waitForElementToLoad(By.cssSelector("div[class*='sweet-alert'] h2"), 10);
        orderConfirmationMessage.getText().equalsIgnoreCase("Thank you for your purchase!");
        String[] orderId = orderSummarySection.getText().split("\n");
        System.out.println("Order details :\n" + orderId[0] + "\n" + orderId[1]);
    }

    public void takeScreenshot() {
        //Take the screenshot
        File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        String timestamp = new java.text.SimpleDateFormat("MM.dd.yyyy h.mm.ss a").format(new Date());
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("C:/Automation/Merkle Projects/Adidas_Test/screenShot" + timestamp + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickConfirmButton(){
        confirmButton.click();
    }

    public boolean waitForElementToLoad(By locator, long timeOutInSeconds) {
        boolean result = true;
        try {
            new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            result = false;
        }
        return result;
    }

    public void sleep(long miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
