package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import base.DriverSetup;
import org.openqa.selenium.By;
public class HomeSteps {

    WebDriver driver = DriverSetup.getDriver();
    HomePage home = new HomePage(driver);

    @Given("User launches Flipkart")
    public void launch_site() {

        home.openSite();
        home.closeLoginPopup();
    }

    @When("User closes login popup")
    public void close_popup() {

        home.closeLoginPopup();
    }

    @Then("Search box should be visible")
    public void verify_search() {

        Assert.assertTrue(
                home.isSearchVisible(),
                "Search box not visible → Home page not loaded"
        );
    }
    
    @Then("Homepage URL should be correct")
    public void verify_home_url() {
        Assert.assertTrue(
            driver.getCurrentUrl().contains("flipkart"));
    }

    @Then("Search placeholder should be visible")
    public void verify_placeholder() {
        String text = driver.findElement(By.name("q"))
                            .getAttribute("placeholder");

        Assert.assertTrue(text.length() > 0);
    }
    
    @Then("Home page title should load")
    public void verify_home_title() {

        Assert.assertTrue(
            driver.getTitle().length() > 0);
    }


}
