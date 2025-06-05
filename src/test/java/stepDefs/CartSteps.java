package stepDefs;

import base.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPage;
import utils.Item;
import utils.TestContext;

public class CartSteps {

    private final TestContext testContext;

    public CartSteps(TestContext context) {
        this.testContext = context;
    }

    @Then("I go to my cart")
    public void iGoToMyCart() {
        CartPage cartPage = testContext.getPageObjectManager().getCartPage(WebDriverFactory.getDriver());
        cartPage.waitForMenu();
        cartPage.goToMyCart();
        cartPage.waitForCart();
    }

    @And("I validate the displayed {string} in the cart")
    public void iValidateTheDisplayedPriceInTheCart(String option) {
        CartPage cartPage = testContext.getPageObjectManager().getCartPage(WebDriverFactory.getDriver());
        Item item = (Item) testContext.getScenarioContext().getContext("item");
        cartPage.getSpecificItemPrice(item);
    }

    @And("I expect the search price is the same as the cart price")
    public void iExpectTheSearchPriceIsTheSameAsTheCartPrice() {
    }

}
