package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import pages.NavigationPage;
import base.DriverSetup;

public class NavigationSteps {

    WebDriver driver =
        DriverSetup.getDriver();

    NavigationPage nav =
        new NavigationPage(driver);

    @When("User navigates to mobiles category")
    public void open_category() {
        nav.openMobilesCategory();
    }

    @Then("Mobiles page should display")
    public void verify_category() {
        Assert.assertTrue(
            nav.isMobilesPageDisplayed());
    }

    @And("User clicks Flipkart logo")
    public void click_logo() {
        nav.clickFlipkartLogo();
    }

    @Then("User should be on home page")
    public void verify_home() {
        Assert.assertTrue(
            nav.isHomePage());
    }
    
    @Then("Mobiles URL should contain mobiles")
    public void verify_mobile_url() {
        Assert.assertTrue(
            driver.getCurrentUrl().toLowerCase()
                  .contains("mobile"));
    }

    @Then("Page title should contain mobiles")
    public void verify_title() {
        Assert.assertTrue(
            driver.getTitle().toLowerCase()
                  .contains("mobile"));
    }

}
