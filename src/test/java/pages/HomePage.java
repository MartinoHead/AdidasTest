package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    WebDriver webDriver;

    @FindBy(id = "nava")
    WebElement websiteLogo;

    @FindBy(id = "cat")
    WebElement categories;

    @FindBy(css = "a[onclick*='notebook']")
    WebElement laptopsCat;

    @FindBy(css = "a[onclick*='phone']")
    WebElement phonesCat;

    @FindBy(css = "a[onclick*='monitor']")
    WebElement monitorsCat;

    @FindBy(css = ".card-title")
    WebElement productList;

    @FindBy(css = "button[id='next2']")
    WebElement nextButton;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void homePageIsDisplayed() {
        websiteLogo.isDisplayed();
        categories.isDisplayed();
        webDriver.getCurrentUrl().equalsIgnoreCase("https://www.demoblaze.com/index.html");
    }

    public void clickWebsiteLogo(){
        websiteLogo.click();
    }

    public void selectCat(String cat) {
        switch (cat) {
            case "laptop":
                laptopsCat.click();
                System.out.println("Selected category :" + cat);
                break;
            case "phones":
                phonesCat.click();
                System.out.println("Selected category :" + cat);
                break;
            case "monitors":
                monitorsCat.click();
                System.out.println("Selected category :" + cat);
                break;
            default:
                System.out.println("Category is not available");
        }
    }

    public void sleep(long miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnProduct(String product) {
        waitForAjaxtoComplete();
//        waitForElementToLoad(By.cssSelector("img[src*='jpg']"), 10);
        List<WebElement> allProducts = webDriver.findElements(By.cssSelector(".card-title"));
        for (WebElement element : allProducts) {
            sleep(1000);
            System.out.println("Check product by product in the grid. \nCurrent element is " + element.getText());
            String perm = element.getText();
            if (perm.equalsIgnoreCase(product)) {
                element.click();
                return;
            }
        }
        if (nextButton.isDisplayed()) {
            System.out.println("Product is not found on page one. \nLet's click on Next button and go to page 2 and try to find the product!");
            nextButton.click();
            sleep(1000);
            List<WebElement> allProductsPage2 = webDriver.findElements(By.cssSelector(".card-title"));
            for (WebElement element : allProductsPage2) {
                sleep(1000);
                System.out.println("Current element is " + element.getText());
                String perm = element.getText();
                if (perm.equalsIgnoreCase(product)) {
                    element.click();
                    return;
                }
            }
        }
    }

    public boolean waitForAjaxtoComplete() {
        JavascriptExecutor je = (JavascriptExecutor) webDriver;
        String jQueryActiveScript = "return typeof jQuery != 'undefined'?jQuery.active:document.readyState=='complete'?0:100;";
        long activeQueries;
        int i = 0;
        do {
            i++;
            try {
                activeQueries = (long) je.executeScript(jQueryActiveScript);
            } catch (Exception e) {
                e.printStackTrace();
                activeQueries = 100L;
                i = i + 5;
            }
            sleep(1000);
        } while (activeQueries > 0 && i < 30);

        // in case after the request is complete something on the page needs to be updated
        sleep(1000);

        return activeQueries == 0L;
    }
}
