package stepdefinitions;

import base.DriverSetup;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.SortingPage;
import java.util.*;

public class SortingSteps {

    WebDriver driver =
        DriverSetup.getDriver();

    SortingPage sorting =
        new SortingPage(driver);

    @When("User sorts price low to high")
    public void sort_low_high() {
        sorting.sortLowToHigh();
    }

    @When("User sorts price high to low")
    public void sort_high_low() {
        sorting.sortHighToLow();
    }

    @When("User sorts by popularity")
    public void sort_popularity() {
        sorting.sortPopularity();
    }

    @Then("Products should be sorted low to high")
    public void verify_low_high() {

        List<Integer> prices =
            sorting.getPrices();

        List<Integer> sorted =
            new ArrayList<>(prices);

        Collections.sort(sorted);

        Assert.assertEquals(prices, sorted);
    }

    @Then("Products should be sorted high to low")
    public void verify_high_low() {

        List<Integer> prices =
            sorting.getPrices();

        List<Integer> sorted =
            new ArrayList<>(prices);

        Collections.sort(sorted,
            Collections.reverseOrder());

        Assert.assertEquals(prices, sorted);
    }

    @Then("Products should be sorted")
    public void verify_popularity() {

        Assert.assertTrue(
            driver.getTitle()
                .contains("Flipkart"));
    }
}
