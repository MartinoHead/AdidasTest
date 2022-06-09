package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PDP {
    WebDriver webDriver;

    @FindBy(css = "a[onclick*='addToCart']")
    WebElement addToCart;

    public PDP(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void sleep(long miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void PDPIsDisplayed() {
        sleep(2000);
        addToCart.isDisplayed();
        webDriver.getCurrentUrl().contains("https://www.demoblaze.com/prod.html");
    }

    public void clickAddToCart() {
        addToCart.click();
    }

    public void handleAlert() {
        try {
            new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
            webDriver.switchTo().alert().accept();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
