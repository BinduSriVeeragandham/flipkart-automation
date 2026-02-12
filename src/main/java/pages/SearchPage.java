package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By searchBox = By.name("q");
    By searchResults = By.xpath("//div[contains(@data-id,'')]");

    public void searchProduct(String product) {

        wait.until(ExpectedConditions
            .visibilityOfElementLocated(searchBox));

        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }

    public boolean isResultsDisplayed() {

        wait.until(ExpectedConditions
            .visibilityOfElementLocated(searchResults));

        return driver.findElements(searchResults).size() > 0;
    }
}
