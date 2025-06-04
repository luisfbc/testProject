package stepDefs;

import base.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

public class CartSteps {

    @Then("I go to my cart")
    public void iGoToMyCart() {
        CartPage cartPage = new CartPage(WebDriverFactory.getDriver());
        cartPage.waitForMenu();
        cartPage.goToMyCart();
        cartPage.waitForCart();
        System.out.println(cartPage.allItemsList());
    }

    @And("I validate the displayed {string} in the cart")
    public void iValidateTheDisplayedPriceInTheCart() {
    }

    @And("I expect the search price is the same as the cart price")
    public void iExpectTheSearchPriceIsTheSameAsTheCartPrice() {
    }

}
