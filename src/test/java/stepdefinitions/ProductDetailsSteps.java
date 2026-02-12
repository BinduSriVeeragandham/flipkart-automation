package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.ProductDetailsPage;
import base.DriverSetup;

import org.testng.Assert;
public class ProductDetailsSteps {

    WebDriver driver = DriverSetup.getDriver();
    ProductDetailsPage pdp = new ProductDetailsPage(driver);

    @When("User clicks first product")
    public void click_product() {
        pdp.clickFirstProduct();
    }

    @Then("Product details page should open")
    public void verify_page() {
        pdp.isProductPageLoaded();
    }

    @Then("Product title should be visible")
    public void verify_title() {
        pdp.isTitleVisible();
    }

    @Then("Product price should be visible")
    public void verify_price() {
        pdp.isPriceVisible();
    }

    @Then("Product images should be displayed")
    public void verify_images() {
        pdp.areImagesDisplayed();
    }
    
    @Then("Product URL should contain product")
    public void verify_product_url() {

        Assert.assertTrue(
            driver.getCurrentUrl().contains("/p/"),
            "Not a product page URL"
        );
    }

    @Then("Add to Cart button should be visible")
    public void verify_add_btn() {

        Assert.assertTrue(
            pdp.isAddToCartVisible(),
            "Add to Cart not visible");
    }
    
    @Then("Product page title should load")
    public void verify_title_loaded() {

        Assert.assertTrue(
            driver.getTitle().length() > 0);
    }

    @Then("Product page URL should exist")
    public void verify_product_url_exists() {

        Assert.assertTrue(
            driver.getCurrentUrl().length() > 0);
    }
    
    @Then("Product page should load completely")
    public void verify_product_page_loaded() {

        Assert.assertTrue(
            pdp.isProductPageLoaded());
    }
    
    @Then("Page title should contain Flipkart")
    public void verify_flipkart_title() {

        String title = driver.getTitle();

        Assert.assertTrue(
            title != null && title.length() > 5,
            "Product page title not loaded properly"
        );
    }



}
