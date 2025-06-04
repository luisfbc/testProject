package pages;

import io.cucumber.java.be.I;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utils.Item;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    /* ELEMENTS */

    @FindBy(xpath = "//h2[contains(text(),'Results')]")
    private WebElement resultLabelText;
    @FindBy(xpath = "//div[@class ='a-changeover-inner']")
    private WebElement itemAddedBanner;

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
        waitToInvisible(itemAddedBanner);
    }

    public Item getDataFromItem(String numberOnList) {
        WebElement itemToExtract = getSpecificItemFromList(numberOnList);
        Item item = new Item();
        item.setName(itemToExtract.findElement(By.xpath(".//div[(@data-cy = 'title-recipe')]")).getText());
        item.setPrice(Integer.parseInt(itemToExtract.findElement(By.xpath(".//span[@class = 'a-price-whole']")).getText()));
        return item;
    }
}
