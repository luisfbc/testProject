package pages;

import base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends Base {
    /* ELEMENTS */

    @FindBy(id = "nav-belt")
    private WebElement navigationBar;

    @FindBy(id = "nav-logo")
    private WebElement homeButton;

    @FindBy(id = "nav-global-location-popover-link")
    private WebElement locationButton;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBarTextField;

    @FindBy(id = "nav-search-submit-button")
    private WebElement submitSearchButton;

    @FindBy(id = "icp-nav-flyout")
    private WebElement regionButton;

    @FindBy(id = "nav-link-accountList")
    private WebElement accountButton;

    @FindBy(id = "nav-orders")
    private WebElement ordersButton;

    @FindBy(id = "nav-cart")
    private WebElement cartButton;

    @FindBy(xpath = "//div[@class ='a-changeover-inner']")
    private WebElement itemAddedBanner;

    /* CONSTRUCTOR */
    public BasePage (WebDriver webDriver) {
        super(webDriver);
    }

    /* METHODS */

    public void waitForMenu() {
        waitToBeDisplayed(navigationBar);
    }

    public void goToHome() {
        click(homeButton);
    }

    public void goToMyCart() {
        scrollTo("top");
        waitToBeClickable(cartButton);
        waitToInvisible(itemAddedBanner);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", cartButton);
    }

    public void search(String productName) {
        click(searchBarTextField);
        type(searchBarTextField, productName);
    }

    public void submitSearch() {
        click(submitSearchButton);
    }

    public void searchProduct (String productName) {
        search(productName);
        submitSearch();
    }
}
