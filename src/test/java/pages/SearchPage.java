package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Item;

public class SearchPage extends BasePage {
    /* ELEMENTS */

    @FindBy(xpath = "//h2[contains(text(),'Results')]")
    private WebElement resultLabelText;

    //WebElement itemFromList;

    /* CONSTRUCTOR */

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    /* METHODS */

    public void waitForResultsDisplayed() {
        waitToBeDisplayed(resultLabelText);
    }


    private WebElement getSpecificItemFromList(String numberOnList) {
        WebElement itemFromList = webDriver.findElement(By.xpath("//div[contains(@class, 'widgetId=search-results_"+numberOnList+"')]"));
        scrollToElement(itemFromList);
        return itemFromList;
    }

    public void addToCart(String numberOnList) {
        WebElement itemToBeAdded = getSpecificItemFromList(numberOnList);
        waitToBeDisplayed(itemToBeAdded);
        WebElement addToCartButton = itemToBeAdded.findElement(By.xpath(".//button[@name='submit.addToCart']"));
        addToCartButton.click();
    }

    public Item getDataFromItem(String numberOnList) {
        WebElement itemToExtract = getSpecificItemFromList(numberOnList);
        WebElement priceTag =  itemToExtract.findElement(By.xpath(".//span[@class = 'a-price-whole']"));
        WebElement nameTag =  itemToExtract.findElement(By.xpath(".//div[(@data-cy = 'title-recipe')]"));
        waitToBeDisplayed(priceTag);
        waitToBeDisplayed(nameTag);
        Item item = new Item();
        item.setName(nameTag.getText());
        item.setPrice(Integer.parseInt(priceTag.getText()));
        return item;
    }
}
