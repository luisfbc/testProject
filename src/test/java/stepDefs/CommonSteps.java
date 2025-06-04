package stepDefs;

import base.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.SearchPage;

public class CommonSteps {

    private SearchPage searchPage;

    @Given("I go to Amazon web page")
    public void iGoToAmazonWebPage() {
        WebDriverFactory.initDriver().get("https://www.amazon.com");
        WebDriverFactory.getDriver().get("https://www.amazon.com ");
    }


    @When("I search for {string} in the search bar")
    public void iSearchForInTheSearchBar(String product) {
        BasePage basePage = new BasePage(WebDriverFactory.getDriver());
        basePage.waitForMenu();
        basePage.searchProduct(product);
    }

    @And("I validate the option {string} from the list")
    public void iSelectTheOption(String optionNumber) {
        searchPage = new SearchPage(WebDriverFactory.getDriver());
        searchPage.waitForResultsDisplayed();
        searchPage.getDataFromItem(optionNumber);
    }

    @And("I add the product {string} to my cart")
    public void iAddTheResultToMyCart(String optionNumber) {
        searchPage.addToCart(optionNumber);
        searchPage.scrollTo("top");
    }

}
