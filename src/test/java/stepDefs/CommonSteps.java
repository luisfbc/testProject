package stepDefs;

import base.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.SearchPage;
import utils.Item;
import utils.TestContext;

public class CommonSteps {

    private final TestContext testContext;

    public CommonSteps(TestContext context) {
        this.testContext = context;
    }

    @Given("I go to Amazon web page")
    public void iGoToAmazonWebPage() {
        WebDriverFactory.initDriver().get("https://www.amazon.com");
        WebDriverFactory.getDriver().get("https://www.amazon.com ");
    }


    @When("I search for {string} in the search bar")
    public void iSearchForInTheSearchBar(String product) {
        SearchPage searchPage = testContext.getPageObjectManager().getSearchPage(WebDriverFactory.getDriver());
        searchPage.waitForMenu();
        searchPage.searchProduct(product);
    }

    @And("I validate the option {string} from the list")
    public void iSelectTheOption(String optionNumber) {
        SearchPage searchPage = testContext.getPageObjectManager().getSearchPage(WebDriverFactory.getDriver());
        searchPage.waitForResultsDisplayed();
        Item item = searchPage.getDataFromItem(optionNumber);
        testContext.getScenarioContext().setContext("price", item.getPrice());
    }

    @And("I add the product {string} to my cart")
    public void iAddTheResultToMyCart(String optionNumber) {
        SearchPage searchPage = testContext.getPageObjectManager().getSearchPage(WebDriverFactory.getDriver());
        searchPage.addToCart(optionNumber);
        searchPage.scrollTo("top");
    }

}
