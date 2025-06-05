package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class Base {
    /* ELEMENTS */

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    /* CONSTRUCTOR */

    public Base (WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
        PageFactory.initElements(webDriver, this);
    }

    /* METHODS */

    public String getCurrentTitle() {
        return webDriver.getTitle();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String textInput) {
        element.sendKeys(textInput);
    }

    public void waitToBeDisplayed(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitToBeClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitToInvisible(WebElement element) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
    }

    /*public void scrollToElement(WebElement element) {
        new Actions(webDriver)
                .scrollToElement(element)
                .perform();
    }*/

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollTo(String side) {
        switch (side){
            case "top":
                ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
            break;
            case "bottom":
                ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        }
    }

}
