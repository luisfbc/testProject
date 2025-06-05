package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Item;

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

    public void getSpecificItemPrice(Item item) {
        String name = item.getName();
        //Get Parent from element with the same name from the stored price
        List<WebElement> items = webDriver.findElements(By.xpath("//div[@role='listitem']"));
        for (WebElement listItem : items) {
            String nameS = listItem.findElement(By.xpath(".//span[@class='a-truncate " +
                    "sc-grid-item-product-title a-size-base-plus']")).getText();
            System.out.println("NAMES: "+nameS);
            if(name.equals(nameS)){
                String price = listItem.findElement((By.xpath(".//span[contains(@class, 'a-offscreen') and contains (text(), '$')]")))
                        .getAttribute("innerHTML");
                System.out.println("PRECIO:   "+ price);
            }
        }
    }


}
