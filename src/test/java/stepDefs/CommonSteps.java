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

    @Given("I go to Amazon web page in {string} browser")
    public void iGoToAmazonWebPage(String browser) {
        WebDriverFactory.initDriver(browser);
        WebDriverFactory.getDriver().get("https://www.amazon.com");
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
        testContext.getScenarioContext().setContext("item", item);
    }

    @And("I add the product {string} to my cart")
    public void iAddTheProduct(String optionNumber) {
        SearchPage searchPage = testContext.getPageObjectManager().getSearchPage(WebDriverFactory.getDriver());
        searchPage.addToCart(optionNumber);
        searchPage.scrollTo("top");
    }

}
