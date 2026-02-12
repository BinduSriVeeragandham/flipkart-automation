package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import base.DriverSetup;
import io.cucumber.java.en.*;
import pages.SearchPage;


public class SearchSteps {

    WebDriver driver = DriverSetup.getDriver();
    SearchPage search = new SearchPage(driver);

    @When("User searches for {string}")
    public void search_product(String product) {
        search.searchProduct(product);
    }

    @Then("Search results should be displayed")
    public void verify_results() {
        search.isResultsDisplayed();
    }
    
    @Then("Search URL should contain iphone")
    public void verify_search_url() {
        Assert.assertTrue(
            driver.getCurrentUrl().contains("iphone"));
    }

    @Then("Search box should contain iphone")
    public void verify_search_text() {
        String value =
            driver.findElement(By.name("q"))
                  .getAttribute("value");

        Assert.assertTrue(value.contains("iphone"));
    }

    @Then("At least one product should display")
    public void verify_product_count() {
        int size =
            driver.findElements(
                By.xpath("//div[contains(@data-id,'')]")
            ).size();

        Assert.assertTrue(size > 0);
    }
    
    @Then("Search results URL should exist")
    public void verify_search_url_exists() {

        Assert.assertTrue(
            driver.getCurrentUrl().length() > 0);
    }


}

