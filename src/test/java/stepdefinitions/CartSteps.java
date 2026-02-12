package stepdefinitions;

import base.DriverSetup;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CartPage;
import org.openqa.selenium.WebDriver;


public class CartSteps {
	
	WebDriver driver = DriverSetup.getDriver();

    CartPage cart =
            new CartPage(DriverSetup.getDriver());


    @When("User adds product to cart")
    public void user_adds_product_to_cart() {

        cart.addProductToCart();
    }


    @Then("Product should be added to cart")
    public void verify_product_added() {

        Assert.assertTrue(
                cart.isCartPageDisplayed(),
                "Cart page not displayed"
        );
    }


    @When("User opens cart")
    public void user_opens_cart() {

        cart.openCart();
    }


    @When("User removes product")
    public void user_removes_product() {

        cart.removeProduct();
    }


    @Then("Cart should be empty")
    public void verify_cart_empty() {

        Assert.assertTrue(
                cart.isCartEmpty(),
                "Cart not empty"
        );
    }
    
    @Then("Cart URL should contain cart")
    public void verify_cart_url() {
        Assert.assertTrue(
            driver.getCurrentUrl().contains("cart"));
    }

    @Then("Cart title should be visible")
    public void verify_cart_title() {

        Assert.assertTrue(
            driver.getTitle().length() > 0);
    }
    
    @Then("Cart URL should exist")
    public void verify_cart_url_exists() {

        Assert.assertTrue(
            driver.getCurrentUrl().length() > 0);
    }

}
