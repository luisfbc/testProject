package managers;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.SearchPage;

public class PageObjectManager {

    private final WebDriver webDriver;
    private SearchPage searchPage;
    private CartPage cartPage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public SearchPage getSearchPage(WebDriver webDriver) {
        if(searchPage == null) {
            searchPage = new SearchPage(webDriver);
        }
        return searchPage;
    }

    public CartPage getCartPage(WebDriver webDriver) {
        if(cartPage == null) {
            cartPage = new CartPage(webDriver);
        }
        return cartPage;
    }
}
