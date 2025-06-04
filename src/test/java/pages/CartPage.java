package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{

    @FindBy(id = "sc-active-items-header")
    private static WebElement shoppingCartLabel;
    @FindBy(id = "sc-subtotal-amount-activecart")
    private static WebElement subTotalPriceLabel;
    @FindBy(xpath = "//*[contains(@role, 'listitem')]")
    private static List<WebElement> allItems;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void waitForCart() {
        waitToBeDisplayed(shoppingCartLabel);
    }

    public int getTotalPrice() {
        return Integer.parseInt(subTotalPriceLabel.getText());
    }

    public ArrayList<String> allItemsList() {
        ArrayList<String> list = new ArrayList<String>();
        allItems.forEach(e -> {
            list.add(e.getText());
        });
        return list;
    }

}
