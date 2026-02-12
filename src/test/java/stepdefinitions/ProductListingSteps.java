package stepdefinitions;

import base.DriverSetup;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ProductListingPage;
import pages.SearchPage;

public class ProductListingSteps {

    WebDriver driver = DriverSetup.getDriver();
    SearchPage search = new SearchPage(driver);
    ProductListingPage listing =
        new ProductListingPage(driver);

    int beforeFilter;

    @Then("Multiple products should be listed")
    public void verify_products() {
        Assert.assertTrue(
            listing.getProductCount() > 1);
    }

    @And("User applies price filter")
    public void applyPriceFilter() throws InterruptedException {
        beforeFilter = listing.getProductCount();
        listing.applyPriceFilter();
    }

    @And("User applies brand filter")
    public void apply_brand() throws InterruptedException {
        listing.applyBrandFilter();
    }

    @Then("Filtered results should display")
    public void verify_filtered() {

        Assert.assertTrue(
            listing.isFilterApplied());
    }
    
    @Then("Listing page title should load")
    public void verify_listing_title() {

        Assert.assertTrue(
            driver.getTitle().length() > 0);
    }


}
